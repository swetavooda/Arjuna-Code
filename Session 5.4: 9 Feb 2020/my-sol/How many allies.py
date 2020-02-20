#taking input
n,e=map(int,input().split())
edges={}
for i in range(0,n):
    edges[i]=[]
    
#storing edges in form  of a dictionary
for i in range(0,e):
    x,y=map(int,input().split())
    edges[x].append(y)
    edges[y].append(x)

queries=int(input())
l=[]
for i in range(0,queries):
    l.append(list(map(int,input().split())))

#bfs to find all the points at a given distance(d) from (x)
def bfs(x,d):
    ans=0
    visited=[x]
    q=[[x,0]]
    while(q!=[]):
        pos=q.pop(0)
        if(pos[1]==d):
            ans+=1
        dist=pos[1]+1
        for i in edges[pos[0]]:
            if i not in visited:
                q.append([i,dist])
                visited.append(i)
    return ans

#printing ans
for i in l:
    print(bfs(i[0],i[1]))
            
            
    
