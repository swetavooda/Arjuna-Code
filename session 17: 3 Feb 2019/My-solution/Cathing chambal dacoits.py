n,a=map(int,input().split())
given=[]
for i in range(0,a):
    given.append([int(k) for k in input().split()])
given.sort()
s=int(input())


m_graph={}
for i in range(0,n):
    m_graph[i+1]=[]
#print(m_graph)

for i in range(len(given)):
    m_graph[given[i][0]].append(given[i][1])
    m_graph[given[i][1]].append(given[i][0])

#print(m_graph)
k_graph={}
for i in range(0,n):
    k_graph[i+1]=[]
#print(k_graph)

for j in range(1,n+1):
    for i in range(1,n+1):
        if i in m_graph[j] or (i in k_graph[j]):
            continue
        else:
            if j!=i:
                k_graph[j].append(i)
                k_graph[i].append(j)
                #print('k_graph[j].append(i)',j,i)
                #print('k_graph[j].append(i)',i,j)
#print(k_graph)


q=[[s,0]]
popped=[]
visited=[s]

while q!=[]:
    r=q.pop(0)
    popped.append(r)
    #print(popped)
    for l in range(0,len(k_graph[r[0]])):
        if (k_graph[r[0]][l]) not in visited:
            q.append([k_graph[r[0]][l],r[1]+1])
            visited.append(k_graph[r[0]][l])
            #print('l,k,q,visited',l,q,visited)

popped.sort()
sum=0
for i in range(1,n+1):
    if i not in visited:
        print(0,end="")
    else:
        for j in range(0,len(popped)):
            if popped[j][0]!=s and popped[j][0]==i:
                print(popped[j][1],end='')

    

