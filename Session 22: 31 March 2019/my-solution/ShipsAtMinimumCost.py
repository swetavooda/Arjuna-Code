no_islands,no_ships=map(int,input().split())
ships=[]
for i in range(0,no_ships):
    ships.append(list(map(int,input().split())))
source,destination,stops=map(int,input().split())

graph={}
for i in range(0,no_islands+1):
    graph[i]=[]
for i in ships:
    graph[i[0]].append([i[1],i[2]])
    graph[i[1]].append([i[0],i[2]])
def dfs(graph,src,stops,prize,dest):
    p=prize
    change=stops
    if dest==destination:
        ans.append([prize,stops])
    elif dest not in visited:
        visited.append(src)
        for i in graph[dest]:
            dfs(graph,dest,change+1,p+i[1],i[0])


popped=[source,-1]
visited=[source]
ans=[]
#popped=q.pop(0)
#visited.append(popped[0])
for i in range(0,len(graph[popped[0]])):
    k=graph[popped[0]]
    if k[i][0] not in visited:
        #q.append([k[i][0],popped[1]+1])
        dfs(graph,popped[0],popped[1]+1,k[i][1],k[i][0])


ans.sort()
for i in ans:
    if i[1]<=stops:
        print(i[0])
        break
        
    
    
    
