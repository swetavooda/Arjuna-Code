n=int(input())

board=[]
for i in range(0,n):
    p=list(map(int,input().split()))
    board.append(p)
board.reverse()
final_ans=[]
for j in range(0,n):
    money=board[0][j]
    i=0
    while i<=n-2:

        if j-1>=0:
            s=j-1
        else:
            s=j
        if j+1<n:
            l=j+1
        else:
            l=j
            
        add=board[i+1][s]
        
        for c in range(s,l+1):
            su=board[i+1][c]
            if su>=add:
                add=su
                j1=c
        money+=add
        j=j1
        i+=1
        
    final_ans.append(money)
    

final_ans.sort()
final_ans.reverse()
print(final_ans[0])
    
                
            
        
