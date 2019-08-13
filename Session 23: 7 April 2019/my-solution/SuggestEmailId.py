n=int(input())
inp=[]
for i in range(0,n):
    p=input()
    inp.append(p)
ans=inp
for i in range(0,n):
    check=inp[i]
    count=0
    for j in range (0,n):
        if j!=i and check==inp[j]:
            count+=1
            app=check+str(count)
            ans[j]=app
for i in ans:
    print(i)
                            
        
