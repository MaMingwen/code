%各种热性质系数均以金属Fe为例。
thermalconductivity_Fe = 76.2; %热传导系数
MassDensity_Fe = 7.87; %质量密度
Specific_heat_Fe = 0.44; %比热
tlist = 0:0.01:2;
%创造模型
model = createpde("thermal", "transient");

%创建区域。二维圆盘。
C1 = [1
    0
    0
    1
    ];
gd = C1;
name = char('C1');
name = name';
sf = 'C1';
[dl,bt] = decsg(gd,sf,name);

%创建几何区域。
geometryFromEdges(model,dl);

%pdegplot(dl,"EdgeLabels","on","FaceLabels","on")
%xlim([-1.5,1.5])
%axis equal

thermalProperties(model,"ThermalConductivity",thermalconductivity_Fe, ...
    "MassDensity",MassDensity_Fe, ...
    "SpecificHeat",Specific_heat_Fe ...
    );

%初边值条件
%边值条件
model.StefanBoltzmannConstant = 5.670373E-8;
thermalBC(model,"Edge",[1,2,3,4],...
                       "Emissivity",0.1,...
                       "AmbientTemperature",80);
%初值条件
thermalIC(model,0);

%生成网格
m1 = generateMesh(model);

%求解
results = solve(model,tlist);

%可视化结果
[qx,qy] = evaluateHeatFlux(results);

pdeplot(model,"XYData",results.Temperature(:,end), ...
                     "Contour","on",...
                     "FlowData",[qx(:,end),qy(:,end)], ...
                     "ColorMap","hot")
