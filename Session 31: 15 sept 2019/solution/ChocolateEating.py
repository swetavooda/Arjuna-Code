choco=list(map(int,input().split()))#list containing chocolates.

'''loop to subract chocolates break when len=1 or less'''
while len(choco)>1:
    choco.sort()#sorting list
    choco.reverse()#reverse(to get decreasing order)
    choco[0]=choco[0]-choco[1]
    choco[1]=0
    choco.remove(choco[1])
    if choco[0]==0:
        choco.remove(choco[0])#remove from list if zero chocolates.
    
        
if choco!=[]:
    print(choco[0])
else:
    print(0)

