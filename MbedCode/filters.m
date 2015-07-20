% clear all;
% clc;

load('butt_band_pass')
load('cheb_low_pass')
% load('good');
% load('test1')
% 
% s=good(:,2);
% t=good(:,1);


p=filtfilt(num,den,s);
p2=filtfilt(num1,den1,p);
figure;
subplot(2,1,2);
plot(t,p2);
legend('Filtered');
xlabel('Time:s');
subplot(2,1,1);
% hold on;
plot(t,s,'r');
legend('Original');
xlabel('Time:s');

