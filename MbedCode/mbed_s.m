function mbed_s()
 
TIMEOUT = 5;    
XPOINTS = 1000;   
 
try
    %create serial object to represent connection to mbed
    mbed = serial('COM4', ...
                  'BaudRate', 9600, ...
                  'Parity', 'none', ...
                  'DataBits', 8, ...
                  'StopBits', 1);      
    
    set(mbed,'Timeout',TIMEOUT);        
    
    fopen(mbed);       
 
    position = 1;     
    time = 1;
    x = [(1:XPOINTS)' (1:XPOINTS)' (1:XPOINTS)'];
    xlabels = (1:XPOINTS);
    y = zeros(XPOINTS,1);
    
    while (1)       %loop forever (or until an error occurs)
        
        values = fscanf(mbed, '%d');    
        y(position,:) = values';    
        
    
        xlabels(position) = time;
        time = time + 1;
        if (position < XPOINTS)
            position = position + 1;
        else
            position = 1;
        end
 
        %display
        plot(x,y);
        drawnow;   
    end
 
    fclose(mbed);   
    
catch
    disp('Failed!');
    fclose(mbed);  
end 