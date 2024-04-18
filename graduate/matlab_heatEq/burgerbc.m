function [pl,ql,pr,qr] = burgerbc(xl,ul,xr,ur,t)
%零边值
pl = ul;
ql = 0;
pr = ur;
qr = 0;
end
