% clear all;
% clc;

% load('s');
% load('s1');
% load('s2');
% load('s3');

% load('good')
% 
% s=good(:,2);
% t=good(:,1);

fs=200;
wp=[0.9,50]/(fs/2);
ws=[0.2,99]/(fs/2);
rp=0.5;
rs=40;
[N,wc]=buttord(wp,ws,rp,rs);
[num,den]=butter(N,wc);
[H,W]=freqz(num,den);
plot(fs*W/(2*pi),abs(H));
% figure;
% hold on;% p=filtfilt(1.5*num,den,s);
% plot(t,p);
% hold on;
% plot(t,s,'r');

% plot(s0,'--g');
% plot(offset,'--r');