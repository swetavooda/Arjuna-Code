rows=int(input())
cols=int(input())
matrix=[]
for i in range(0,rows):
    matrix.append(list(map(int,input().split())))
    
#all possible movements (right, left, upward and downward) 
pos=[[-1,0],[1,0],[0,-1],[0,1]]

#using bfs algorithm
def bfs(r,c):
    q=[[r,c,0]]#queue for the nodes
    visited=[[r,c]]
    while(q!=[]):
        p=q.pop(0)
        for k in pos:
            row=p[0]+k[0]
            col=p[1]+k[1]
            if (row>=0 and col>=0) and (row<rows and col<cols):#limits inside grid
                if (matrix[row][col]==0):#if reached the exit door
                    return p[2]+1 #return the number of steps.
                elif((matrix[row][col]>0) and ([row,col]not in visited)):
                    q.append([row,col,p[2]+1])
                    visited.append([row,col])
    return 500
            
ans=[]
#print the answer
for i in range(0,rows):
    for j in range(0,cols):
        if(matrix[i][j]<=0):
            print(matrix[i][j],end=" ")
        else:
            print(bfs(i,j),end=" ")
    print()
