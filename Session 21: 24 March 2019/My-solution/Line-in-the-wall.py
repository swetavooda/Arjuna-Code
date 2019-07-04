no_of_rows=int(input())
input_=[]#input given my user.
mylist=[]
''' mylist consists of numbers 0's or 1's.
    if the brick ends to the next right then that position is given 1 otherwise 0.
    example:
      for given:
        input_=[[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
        mylist=[[1,0,1,0,1,1],[0,0,1,1,0,1],[1,0,0,1,0,1],[0,1,0,0,0,1],[0,0,1,1,0,1],1,0,0,1,1,1]] 
'''
    
for i in range(0,no_of_rows):
    line=list(map(int,input().split()))
    input_.append(line)
    p=[]
    for element in line:
        for j in range(1,element):
            p.append(0)
        p.append(1)
    mylist.append(p)
    
columns=sum(input_[0])#no.of columns equal to sum of numbers in any list of input.

ans=[]#stores all answers for each line.

'''logic:
    if there is a zero in any row corresponding to that column which is 1(i.e, where there is an edge)
    then count is increased by one.
    after counting along all rows we add count to ans 
    finally we sort ans and print least value in ans
'''
for i in range(0,no_of_rows):
    for j in range(0,columns):
        if mylist[i][j]==1 and (j!=columns-1):
            count=0
            for row in range(0,no_of_rows):
                if mylist[row][j]==0:
                    count+=1
            ans.append(count)
            
ans.sort()
print(ans[0])
        
