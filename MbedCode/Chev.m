clear all;

% load('good')
% load('after_butt')
% 
% s=p;
% t=good(:,1);

fs=200;
wp1=5/(fs/2);
ws1=10/(fs/2);
rp1=0.01;
rs1=40;
[N1,wc1]=cheb1ord(wp1,ws1,rp1,rs1);
[num1,den1]=cheby1(N1,rp1,wc1,'low');
[H1,W1]=freqz(num1,den1);
plot(fs*W1/(2*pi),abs(H1));

% p=filtfilt(num1,den1,s);
% plot(t,p);
% hold on;
% plot(t,s,'r');
% figure;
% p=filtfilt(num1,den1,p);
% plot(t,p);