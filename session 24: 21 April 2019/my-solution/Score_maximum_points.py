n=int(input())
l=list(map(int,input().split()))
for i in range(0,n):
    if l[i]==-1:
        l[i]=0
q=[0]
graph={}
for i in range(0,n):
    graph[i]=[]
i=1
while i<n:
    p=q.pop(0)
    graph[p].append(i)
    graph[p].append(i+1)
    graph[i].append(p)
    graph[i+1].append(p)
    q.append(i)
    q.append(i+1)
    i+=2
notconsider=[]
finaladd=[]
for i in range(0,n):
    #print(i)
    add=[i]
    s=i
    notconsider=[i]
    for j in range(0,len(graph[s])):
        notconsider.append(graph[s][j])
        
    for k in range(0,n):
        if k not in notconsider:
            add.append(k)
            for m in range(0,len(graph[k])):
                notconsider.append(graph[k][m])
                    
    #print(notconsider)
    #print(add)
    sum=0
    for i in add:
        sum+=l[i]
    finaladd.append(sum)
    #print(sum)
    #print(finaladd)

finaladd.sort()
finaladd.reverse()
print(finaladd[0])
    
