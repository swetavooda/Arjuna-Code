 
maxe = 10000
  
# Function to get minimum number of trials needed in worst 

def muffinDrop(n, f): 
    
    muffinFloor = [[0 for x in range(f+1)] for x in range(n+1)] 
  
    # We need one trial for one floor and 0 trials for 0 floors 
    for i in range(1, n+1): 
        muffinFloor[i][1] = 1
        muffinFloor[i][0] = 0
  
    # We need j trials for one muffin and j floors. 
    for j in range(1, f+1): 
        muffinFloor[1][j] = j 
  
    '''logic for creating matrix
         A matrix  where entery muffinFloor[i][j] will represent minimum 
     number of trials needed for i muffins and j floors. '''
    for i in range(2, n+1): 
        for j in range(2, f+1): 
            muffinFloor[i][j] = maxe 
            for x in range(1, j+1): 
                res = 1 + max(muffinFloor[i-1][x-1], muffinFloor[i][j-x]) 
                if res < muffinFloor[i][j]: 
                    muffinFloor[i][j] = res 
  
    # muffinFloor[n][f] contains result 
    return muffinFloor[n][f] 
  
# n muffins and f floors 
n,f=map(int,input().split())
print(str(muffinDrop(n, f))) 
  

