charges=list(map(int,input().split()))#contains charges.
n=int(input())
plans=[]#conatins list of all plans.
for i in range(0,n):
    plans.append(list(map(int,input().split())))
c=tuple(map(int,input().split()))#choice

choice=list(c)  
#ans=[]
finalans=()
''' checking or repeating the same plan for possible number of times
    i.e., if number of fruits in plan > choice break from loop(loop terminates)'''
for plan in plans:
    check=list(c)
    cost=0
    flag=0
    counter=0
    j=0
    choice=check
    while plan[j]<=choice[j]:
        check[j]=choice[j]-plan[j]
        counter+=1
        j+=1
        if counter==len(choice):
            cost+=plan[-1]
        if j==len(choice):
            j=0
            counter=0
            choice=check
            ans=(cost,tuple(choice))
            flag=1
            
    if flag==1:
        finalans+=(ans,)
#final ans contains all possible ways for reapeting plans.on format(cost,fruitsleft)

'''for left over fruits we will check other plans'''    
''' this step is important because we can use various plans at a time to find out least price'''
for i in range(0,len(finalans)):
    check=finalans[i][1]
    for plan in plans:
        check=list(finalans[i][1])
        cost=finalans[i][0]
        counter=0
        j=0
        flag=0
        choice=tuple(check)
        while plan[j]<=choice[j]:
            check[j]=choice[j]-plan[j]
            counter+=1
            j+=1
            if counter==len(choice):
                cost+=plan[-1]

            if j==len(choice):
                j=0
                counter=0
                choice=tuple(check)
                flag=1
                ans=(cost,tuple(choice))
        if ans not in finalans and flag==1 :
            finalans+=(ans,)
            
ans=[]                    
#costfinal=finalans[0][0]
''' for all left over fruits we will buy separately'''
for i in finalans:
    choice=list(i[1])
    cost=i[0]
    for j in range(0,len(i[1])):
        cost+=i[1][j]*charges[j]
        choice[j]=0
    ans.append([cost,tuple(choice)])
cost=0
for j in range(0,len(c)):
    cost+=c[j]*charges[j]
ans.append([cost,c])

ans.sort()
print(min(ans)[0])
