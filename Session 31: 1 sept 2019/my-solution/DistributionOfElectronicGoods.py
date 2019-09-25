no_of_cities,n=map(int,input().split())
conndict={}#dictionary containing all connections and weight (costs)
costs={}#dictionary used to store final cost for travel.

for i in range(1,no_of_cities+1):
    conndict[i]=[]
    costs[i]=0
    
'''taking input and storing in conndict
    example: for input:
    4 3
    3 4 1
    2 1 2
    2 3 3
    2 
    conndict={1: [], 2: [[1, 2], [3, 3]], 3: [[4, 1]], 4: []}
    first element containg destinatio and next containing cost'''
for i in range (0,n):
    s,e,cost=map(int,input().split())
    conndict[s].append([e,cost])
    
start=int(input())
del costs[start]

'''logic:
    for each destination we find out the cost using bfs'''
for dest in costs:
    q=[[start,0]]#queue
    end=start
    while end!=dest and q!=[]:
        popped=q.pop(0)
        if popped[0]==dest:#if reached requered destination.
            costs[dest]=popped[1]
        for k in conndict[popped[0]]:
            q.append([k[0],popped[1]+k[1]])#append to list the connecting towns and add cost.
        end=popped[0]#update current destination as end
        
'''end of logic we get costs={1: 2, 3: 3, 4: 4}'''
if max([i for i in costs.values()])!=0:
    print(max([i for i in costs.values()]))#finding max value in costs dict
else:
    print(-1)
