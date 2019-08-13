c,r=map(int,input().split())
grid=[]
for i in range(0,c):
    l=[]
    l=list(map(int,input().split()))
    grid.append(l)
colors=[]
for i in range(0,c):
    for j in range(0,r):
        if grid[i][j] not in colors:
            colors.append(grid[i][j])
        
addj={}
for i in range(0,c):
    for j in range(0,r):
        p=str(i)+str(j)
        addj[p]=[]
for i in range(0,c):
    for j in range(0,r):
        p=str(i)+str(j)
        if i+1<c:
            addj[p].append(i+1)
            addj[p].append(j)
        if i-1>=0:
            addj[p].append(i-1)
            addj[p].append(j)
        if j+1<r:
            addj[p].append(i)
            addj[p].append(j+1)
        if j-1>=0:
            addj[p].append(i)
            addj[p].append(j-1)

            
            
pairs=[]
for i in range(0,len(colors)):
    for j in range(i+1,len(colors)):
        pairs.append([colors[i],colors[j]])

output=[]
for pair in pairs:
    c1=pair[0]
    c2=pair[1]
    q=[]
    visited=[]
    finalans=[]
    wholevisited=[]
    print('pair',c1,c2)
    for i in range(0,c):
        for j in range(0,r):
            wholevisited+=visited
            #print('main',i,j,grid[i][j])
            if( grid[i][j]==c1 or grid[i][j]==c2 )and [i,j] not in wholevisited:
                #print('initial',q)
                q=[[i,j]]
                
                sum1=0
                visited=[]
                #print("before bfs",q)
                while q!=[]:
                    #print(q)
                    p=q.pop(0)
                    visited.append(p)
                    #print('visited',visited)
                    sum1+=1
                    #print('sum',sum1)
                    ind=str(p[0])+str(p[1])
                    print(ind)
                    m=0
                    while m<(len(addj[ind])):
                        #print('m',m)
                        a=addj[ind][m]
                        b=addj[ind][m+1]
                        v=[a,b]
                        if (grid[a][b]==c1 or grid[a][b]==c2) :
                            if v not in visited and v not in q:
                                q.append([a,b])
                        m+=2
                finalans.append(sum1)
                #print('sumlast',sum1)
                print('finalans',finalans)
            finalans.sort()
            finalans.reverse()
    if finalans!=[]:
        output.append(finalans[0])
        print('output',output)
    
output.sort()
output.reverse()
print(output[0])

