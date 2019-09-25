no_of_cities,n=map(int,input().split())
conndict={}#dictionary containing all connections and weight (costs)
costs={}#dictionary used to store final cost for travel.

for i in range(1,no_of_cities+1):
    conndict[i]=[]
    costs[i]=-1
    
for i in range (0,n):
    s,e,cost=map(int,input().split())
    conndict[s].append([e,cost])
    
start=int(input())
del costs[start]

for dest in costs:
    q=[[start,0]]#queue
    end=start
    while q!=[]:
        #print(q)
        popped=q.pop(0)
        if popped[0]==dest:#if reached requered destination.
            if costs[dest]==-1 or costs[dest]>popped[1]:
                costs[dest]=popped[1]
        for k in conndict[popped[0]]:
            if k[0]!=start:
                q.append([k[0],popped[1]+k[1]])#append to list the connecting towns and add cost.
        end=popped[0]#update current destination as end
if max([i for i in costs.values()])!=0 and min([i for i in costs.values()])!=-1:
    print(max([i for i in costs.values()]))#finding max value in costs dict
else:
    print(-1)
