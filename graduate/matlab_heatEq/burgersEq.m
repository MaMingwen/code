L = 1;
T = 1;
x = linspace(0,L,50);
t = linspace(0,T,50);

m = 0;
sol = pdepe(m,@burgerpde,@burgeric,@burgerbc,x,t );