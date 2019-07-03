x=list(map(int,input().split()))
number_of_frames=x[0]
number_of_friends=x[1]


purchase_dict={}
for i in range(1,number_of_friends+1):
    purchase_dict[i]=[]

charges=list(map(int,input().split()))
charges=charges[:number_of_frames]
charges.sort()
charges.reverse()

j=1
for i in range(0,len(charges)):
    if j<=number_of_friends:
        purchase_dict[j].append(charges[i])
        if j==number_of_friends:
            j=1
        else:
            j+=1
cost=0        
for i in purchase_dict:
    a=(purchase_dict[i])
    count=0
    for j in a:
        cost+=j*(count+1)
        count+=1
print(cost)
        
    
    
