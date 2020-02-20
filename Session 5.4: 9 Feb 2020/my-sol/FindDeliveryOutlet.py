n=int(input())
#grid storing all the delivery points
grid=[]

for i in range(0,n):
    grid.append(list(map(int,input().split())))

#defination to check wheter given point is in bounds of the grid
def in_bounds(x,y,mov):
    r=x+mov[0]
    c=y+mov[1]
    if(r>=0 and c>=0) and (r<n and c<n):
        return 1
    return 0

#bfs logic to find minimum distance to a delivery hub
def find_min(i,j):
    q=[[i,j,0]]
    move=[[-1,0],[1,0],[0,-1],[0,1]]
    visited=[i,j]
    while(q!=[]):
        pos=q.pop(0)
        for k in move:#for all possible moves
            if(in_bounds(pos[0],pos[1],k)):#if point in bounds
                x=pos[0]+k[0]
                y=pos[1]+k[1]                
                if(grid[x][y]==1):#if delivery hub found then return the min distance                  
                    return abs(i-x)+abs(j-y)
                elif [x,y] not in visited:#ifnot add the point to queue
                    q.append([x,y,pos[2]+1])
                    visited.append([x,y])
    return -1

                    
#list to store all minimum distances to delivery hubs
mins=[]
#calculate the min dist
for i in range(0,n):
    for j in range(0,n):
        if(grid[i][j]==0):
            mins.append(find_min(i,j))
            
if mins==[]:print(-1)
else:print(max(mins))
        
                    
                    
                
        
        
        
