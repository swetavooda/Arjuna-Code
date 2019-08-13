no_of_walks,speeds=[int(x) for x in input().split()]
data=[]
for i in range(0,no_of_walks):
    _input=list(map(int,input().split()))
    _input.reverse()
    data.append(_input)
data.sort()
data.reverse()
days=[]
sum=0
for i in range(0,len(data)):
    if data[i][1] not in days and len(days)<2:
        days.append(data[i][1])
        sum+=data[i][0]
print(sum)
        
    
    
    
