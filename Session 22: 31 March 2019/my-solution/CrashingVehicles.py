road=list(map(int,input().split()))

def direction(n):#def to find direction of vehicle.
    if n>0:
        return('r')
    else:
        return('l')
            
while(True):#this loop is run until there r no changes in the road for len(road-1 times.
    i=0
    count=0
    while(i<len(road)-1 and road!=[]):
        #if the direction of i is to right and i+1 to left,and i>i+1,then i+1 crashes
        if abs(road[i])>abs(road[i+1]) and direction(road[i])=='r' and direction(road[i+1])=='l':
            del road[i+1]
            count=0
            #if the direction of i is to right and i+1 to left,and i<i+1,then i crashes
        elif abs(road[i])<abs(road[i+1]) and direction(road[i])=='r' and direction(road[i+1])=='l':
            del road[i]
            count=0
            #if the direction of i is to right and i+1 to left,and i-i+1,then both crash.    
        elif abs(road[i])==abs(road[i+1]) and direction(road[i])=='r' and direction(road[i+1])=='l':
            del road[i]
            del road[i]
            count=0
        else:
            count+=1#count calculates no. of times there are no crashes.
        i+=1
    #if consecutive no crashes =len-1(count) or road is empty we break.    
    if count==len(road)-1 or road==[]:
        break
    
if road==[]:
    print(-1)
else:
    for i in road:
        print(i,end=" ")
