no_inputs=int(input())
given=[]
for i in range(0,no_inputs):
    given.append(list(map(int,input().split())))
xstart=0
xsend=0
hieght=0
ans=[]
for i in range(0,len(given)):
    if given[i][0]<=xsend:
        y=hieght
    else:
        hieght=0
    xstart=given[i][0]
    xsend=xstart+given[i][1]-1
    hieght+=given[i][1]
    if len(ans)>0:
        if ans[-1]>hieght:
            ans.append(ans[-1])
        else:
            ans.append(hieght)
    else:
        ans.append(hieght)
for i in ans:
    print(i,end=" ")
            
