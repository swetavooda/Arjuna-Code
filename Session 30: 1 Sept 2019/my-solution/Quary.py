l=list(map(int,input().split()))


ans=0

''' for every index we will check min of both sides maximum(i.e., left hand side max and right hand side max)
    and we will compare with the present hieght
        if it is lesser that hieght then add to sum'''
for i in range(1,len(l)-1):
    hieght=min(max(l[0:i]),max(l[i+1:]))
    if l[i]<hieght:
            ans+=hieght-l[i]
print(ans)        
