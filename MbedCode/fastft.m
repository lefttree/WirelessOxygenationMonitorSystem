% clear all;
% clc;
% 
% load('test1');
% load('after_butt');
% load('after_cheb');
% s=p;
% t=good(:,1);

fs=200;
L=1000;
NFFT = 2^nextpow2(L); % Next power of 2 from length of y
Y = fft(p2,NFFT)/L;
f = fs/2*linspace(0,1,NFFT/2+1);
plot(f,2*abs(Y(1:NFFT/2+1))) 
xlabel('Frequency (Hz)')
ylabel('|Y(f)|')