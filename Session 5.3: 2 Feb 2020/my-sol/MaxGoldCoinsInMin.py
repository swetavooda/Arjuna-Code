minmain=[]
def printAllPathsUtil(mat, i, j, m, n, path, pi): 

    # Reached the bottom of the matrix 
    # so we are left with only option to move right
    min0=[]
    full=[]
    if (i == m - 1): 
        for k in range(j, n): 
            path[pi + k - j] = mat[i][k] 

        for l in range(pi + n - j):
            full.append(path[l])
        min0.append(min(full))
        return min0

    # Reached the right corner of the matrix 
    # we are left with only the downward movement. 
    if (j == n - 1): 
        for k in range(i, m): 
            path[pi + k - i] = mat[k][j] 

        for l in range(pi + m - i):
            full.append(path[l])
        min0.append(min(full))
        return min0

    # Add the current cell 
    # to the path being generated 
    path[pi] = mat[i][j] 

    # Print all the paths 
    # that are possible after moving down 
    ans=printAllPathsUtil(mat, i + 1, j, m, n, path, pi + 1)
    if(ans!=None):
        minmain.extend(ans)

    # Print all the paths 
    # that are possible after moving right 
    ans=printAllPathsUtil(mat, i, j + 1, m, n, path, pi + 1)
    if(ans!=None):
        minmain.extend(ans)


# The main function that prints all paths 
# from top left to bottom right 
# in a matrix 'mat' of size mXn 
def printAllPaths(mat, m, n): 

    path = [0 for i in range(m + n)] 
    printAllPathsUtil(mat, 0, 0, m, n, path, 0) 

r,c=map(int,input().split())
mat=[]
for i in range(0,r):
    mat.append(list(map(int,input().split())))

mat[0][0]=11111
mat[r-1][c-1]=11111
printAllPaths(mat, r,c)
print(max(minmain))
