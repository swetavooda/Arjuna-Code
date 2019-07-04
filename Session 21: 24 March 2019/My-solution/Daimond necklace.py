no_of_friends,connections=map(int,input().split())
f_graph={}#a dictionary containing edges and weights of every line in graph.

'''initialising empty list to each vertex(node) of graph'''
for i in range(0,no_of_friends):
    f_graph[i+1]=[]
    
'''assiging adjacency and weights of each node from input.'''    
for i in range(0,connections):
    p=list(map(int,input().split()))
    f_graph[p[0]].append([p[1],p[2]])
    f_graph[p[1]].append([p[0],p[2]])
    
    
friends,k=map(int,input().split())

shared_list=list(map(int,input().split()))

#bfs
shared=len(shared_list)#shared contains no. of friends to whoom pic was shared.
q=shared_list#queue for bfs.
visited=[]
while(q!=[]):
    popped=q.pop(0)
    visited.append(popped)
    for i in range(0,len(f_graph[popped])):
        if f_graph[popped][i][1]<=k and(f_graph[popped][i][0] not in visited):
            shared+=1
            q.append(f_graph[popped][i][0])
            visited.append(f_graph[popped][i][0])

print(shared)
