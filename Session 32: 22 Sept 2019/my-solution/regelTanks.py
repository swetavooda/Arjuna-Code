n=int(input())
l=[]
for i in range(0,n):
    k=list(map(int,input().split()))
    k.append(0)
    k.append(0)
    l.append(k)
l.sort()
#print(l)
i=0
j=1
count=0

while i<len(l)-1:
    print(l)
    #print(i)
    if l[i][0]<l[j][0]:
        if l[i][1]<l[j][1]:
            if l[j][3]<=l[i][2]:
                l[j][3]=l[i][2]
                if l[j][2]==0:
                    l[j][2]=l[i][2]+l[j][2]+1
                else:
                    l[j][2]=l[i][2]+l[j][2]
            
            del l[i]
            j=i+1
        else:
            
            count+=1
            j+=1
    else:
        #i+=1
        count+=1
        j+=1
    if j==len(l):
        i+=1
        j=i+1
    
            
ans=0
for i in l:
    print(i)
    if i[2]>ans:
        print('in ',i)
        ans=i[2]
print(ans+1)
