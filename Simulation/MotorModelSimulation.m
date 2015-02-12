J=.1;
b=1
k=.1
r=5;
L=.5

%make Laplase variable.
s=tf('s')

%this is the plant transfer function... also called a DC motor dynamic
%model:
p=k/(J*L*s*s +(b*L+J*r)*s + k^2)

step(p)
pzplot(p)


Tau=10000;
%this is the PID controller transfer function
PID=100/(1/Tau*s + 1);

closedLoopSys=PID*p/(1-PID*p)
step(p)
