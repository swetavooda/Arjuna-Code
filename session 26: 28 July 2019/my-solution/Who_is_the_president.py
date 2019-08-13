votes=list(map(int,input().split()))
time=list(map(int,input().split()))
check=list(map(int,input().split()))
for i in range(0,len(check)):
    for j in range(0,len(time)):
        if check[i]>=time[j]:
            position=j
    vote_list=votes[0:position+1]
    
    #print("vote-list",vote_list)
    for j in range(0,len(vote_list)):
        BorisTrump=0
        DonaldJohnson=0
        if(vote_list[j]==0):
            BorisTrump+=1
        else:
            DonaldJohnson+=1
    if(BorisTrump>DonaldJohnson):
        print(0,end=" ")
    elif(BorisTrump<DonaldJohnson):
        print(1,end=" ")
    else:
        print(vote_list[-1],end=" ")
