x=list(map(int,input().split()))
number_of_houses=x[0]
intensity=x[1]

house_positions=list(map(int,input().split()))

street=[]
for i in range(1,max(house_positions)+1):
    if i in house_positions:
        street.append(1)
    else:
        street.append(0)

lamp=[]
count=0
i=0
while i<len(street):
    if street[i]==1:
        j=i+intensity
        print(j)
        if j>len(street)-1:
            j=len(street)-1
            print('in if',j,i)
        
        while j>=i:
            print('in while',j)
            if street[j]==1:
                lamp.append(j+1)
                count+=1
                i=j+intensity
                print('in while in if',j,i,count,lamp)
            else:
                j-=1
    i+=1

print(lamp)
print(count)

    
