function [c,f,s] = burgerpde(x,t,u,dudx)
%burgers 方程主方程
%u_t + u * u_x = v u_{xx}
v = 0.01;
c = 1;
f = v * dudx;
s = u * dudx;
end

