number_of_trainees,number_of_junction,number_narrow_roads=[int(x)for x in input().split()
]
given=[]
for i in range(0,number_narrow_roads):
    given.append([int(k) for k in input().split()])
given.sort()

graph={}
for i in range(0,number_of_junction):
    graph[i+1]=[]
#print(m_graph)

for i in range(len(given)):
    graph[given[i][0]].append(given[i][1])
    graph[given[i][1]].append(given[i][0])
ans=[]
counti=0
for j in range(1,number_of_trainees+1):
    q=[[j,0]]
    popped=[]
    visited=[j]
    while q!=[]:
        r=q.pop(0)
        print('r=',r)
        popped.append(r)

        for i in range(0,len(graph[r[0]])):
            if graph[r[0]][i] not in visited:
                q.append([graph[r[0]][i],r[1]+1])
                visited.append(graph[r[0]][i])
                if graph[r[0]][i]==number_of_junction:
                    ans.append([graph[r[0]][i],r[1]+1])
                    break
    if number_of_junction not in visited:
        counti+=1
    print(j,'popped=',popped,'visited=',visited)
print('before sort ans=',ans)
count=counti
ans.sort()
for i in ans:
    if i[1]!=ans[0][1]:
        count+=1
print('\n',count)
