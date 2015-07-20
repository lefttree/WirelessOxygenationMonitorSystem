baudrate=9600;
spress = serial('COM4');
set(spress,'BaudRate',baudrate,'Parity','none','FlowControl','none');
fopen(spress);
fprintf(spress,'a');
pause(0.1);
fprintf(spress,'<C0');
pause(0.1);
fprintf(spress,'d1770');
pause(0.1);
fprintf(spress,'$');
pause(0.1);

log = [];
ah=figure('KeyPressFcn',@figlisten);
image(1);
colormap(jet(256));
while 1==1
    if strcmp(get(ah,'Visible'),'off')
        break
    end
    val = fscanf(spress,'%c');%,1
    scanv = textscan(val, '- %*u %*u %u');
    disp(scanv{1})
    log(end+1)=scanv{1};
    barh = round(scanv{1}/256);
    if barh>256; barh=256; end
    bar=zeros(256,1);
    bar(1:barh) = barh;
    image(bar);
    axis off;
    pause(0.05);
    log(end+1)=scanv{1};
end

%stop data
fprintf(spress,'!');
%clean up
fclose(spress);
delete(spress);
clear spress;

csvwrite('pressure_log.txt',log);
% r1=10;
% r2=10;
% r3=10;
% rx=0.01:.01:20;
% VB = rx./(r3+rx);
% VD = r1/(r2+r1);
% 
% VBD = VB-VD;
% figure(5);
% plot(rx,VBD);