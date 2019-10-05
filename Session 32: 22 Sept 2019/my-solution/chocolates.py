# Python3 program to Prall possible paths from 
# top left to bottom right of a mXn matrix 

''' 
 mat: Pointer to the starting of mXn matrix 
i, j: Current position of the robot 
	(For the first call use 0, 0) 
m, n: Dimentions of given the matrix 
pi: Next index to be filed in path array 
*path[0..pi-1]: The path traversed by rob till now 
				(Array to hold the path need to have 
				space for at least m+n elements) 
'''
ans=[]
finalans=[]
def printAllPathsUtil(mat, i, j, m, n, path, pi): 
    ans=[]
    # Reached the bottom of the matrix 
    # so we are left with only option to move right 
    if (i == m - 1): 
        for k in range(j, n): 
                path[pi + k - j] = mat[i][k] 

        for l in range(pi + n - j): 
                #print(path[l], end = " ")
                ans.append(path[l])
        #print()
        finalans.append(ans)
        return

    # Reached the right corner of the matrix 
    # we are left with only the downward movement. 
    if (j == n - 1): 

        for k in range(i, m): 
                path[pi + k - i] = mat[k][j] 

        for l in range(pi + m - i): 
                #print(path[l], end = " ")
                ans.append(path[l])
        #print()
        finalans.append(ans)
        return
        

    # Add the current cell 
    # to the path being generated 
    path[pi] = mat[i][j] 

    # Print all the paths 
    # that are possible after moving down 
    printAllPathsUtil(mat, i + 1, j, m, n, path, pi + 1) 

    # Print all the paths 
    # that are possible after moving right 
    printAllPathsUtil(mat, i, j + 1, m, n, path, pi + 1) 



# Driver Code
mat=[]
n = int(input())
m = int(input())
for i in range(0,n):
    l=list(map(int,input().split()))
    mat.append(l)
	

path = [0 for i in range(n + m)] 
printAllPathsUtil(mat, 0, 0, n, m, path, 0) 

finalans.sort()
finalans.reverse()
P=finalans[0]
A=P[0]
count=1
select=[]
sum1=0
for P in finalans:
    count=1
    sum1=0
    inhand=1
    for i in range(0,len(P)):
        if P[i]<0:
            if -(P[i])>inhand:
                count+=(-P[i]-inhand+1)
                inhand=1
                
            else:
                inhand+=P[i]
                if inhand==0:
                    count+=1
                    inhand=1
        else:
            inhand+=P[i]
    select.append(count)
    
select.sort()
print(select[0])

