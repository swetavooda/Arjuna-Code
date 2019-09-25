min=999999                   #declaring a global min value
def isSafe(sr,sc):           #checks whether it is possible to go ahead on that path, if yes return True or else False
    if(sr<0 or sr>=len(l) or sc<0 or sc>=len(l) or l[sr][sc]==0 or path[sr][sc]==1):
        return False
    return True

def findpath(sr,sc,dr,dc):          
    if(sr==dr and sc==dc):       #base case when we reached the dest. row and col
        ans=0                    #ans for each sol
        for i in range(len(l)):
            for j in range(len(l)):
                if(path[i][j]==1): ans+=1
        global min                   #global min value is taken
        if(min>ans): min=ans         #min has the minimum path taken to reach the destination
        return
    if(isSafe(sr,sc)):              #Checks whether it is possible to take that possible path
        path[sr][sc]=1           
        findpath(sr+1,sc,dr,dc)     #Go up
        findpath(sr-1,sc,dr,dc)     #Go down
        findpath(sr,sc+1,dr,dc)     #Go right
        findpath(sr,sc-1,dr,dc)     #Go left
        path[sr][sc]=0

n=int(input())        #Dimensions of board
l=[[0 for i in range(n)] for i in range(n)]   #2d board 
a=[[0 for i in range(n)] for i in range(n)]   #temp board to find minimum value
for i in range(n):
    l1=list(map(int,input().split()))   #Taking inputs from user
    for j in range(len(l1)):
        l[i][j]=l1[j]
        a[i][j]=l1[j]
min1=0;sr=0;sc=0;dr=0;dc=0;ans=0;
while(min1!=999999):
    min1=999999
    path=[[0 for i in range(n)] for i in range(n)]  #Solution matrix which will contains shortest path
    for i in range(n):
        for j in range(n):
            if(a[i][j]>1 and min1>a[i][j]):   
                min1=a[i][j]             #Finding the minimum value on the board
                dr=i;dc=j                #Assigining dest. row and col to that index on board
    if(min1!=999999):                    #if there is no min. found we exit out of the while loop
        a[dr][dc]=0
        findpath(sr,sc,dr,dc)           #Backtracking function to find minimum path from source to dest.
        if(min==999999):
            ans=-1                      #If min is 999999, we don't find any path we make ans=-1 and break
            break
        ans+=min                        #If min path is found, add the min. steps to ans
        min=999999
    sr=dr;sc=dc                         #Update the source row and col to dest. row and col and peform next iteration with next minimum
print(ans)                              #print the ans
