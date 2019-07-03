number_of_candidates=int(input())
number_of_rounds=int(input())

#a list containing performance in each round.
game=[]
for i in range(0,number_of_rounds):
    p=list(map(str,input().split()))
    game.append(p)

#perfect is a when all players hit 'H'.i.e,scored 10.
perfect=['H '*number_of_candidates]

ans=0
count=0
for i in game:
    if i==perfect:#if all score 10.
        count+=1#increment count.
        print(i,'got perfect',end="")
        print("count=",count)
    else:
        if count>ans:
            ans=count#else checking for max 10 score rounds.
            print("ans=",ans,"at ",i)
        count=0#and changing count to 0.
if count>ans:
    ans=count
print(ans)
    
    
    
