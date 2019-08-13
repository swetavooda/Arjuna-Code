#no_of_days,shares=int(input().split()
no_of_days,shares=[int(x) for x in input().split()]
price=list(map(int,input().split()))
start=price[0]
ans=0
diff=0
for i in range(0,no_of_days):
    start=price[i]
    for j in range(i+1,no_of_days):
        if(price[j]>start):
            sell=price[j]
            diff=sell-start
        if diff>ans:
            ans=diff
print(shares*ans)
            
