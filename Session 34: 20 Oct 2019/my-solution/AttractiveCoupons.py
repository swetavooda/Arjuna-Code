n=int(input())
l=[]

for i in range(n):
    k=list(map(int,input().split()))
    k.reverse()
    l.append(k)

l.sort()#sorting given input based on expiry hours(ascending order)

time=0
count=0
ans=0

"""logic: starting from each coupon in order in l,check if exceeds cumulative expiry time
            if yes skip otherwise increment count of number of coupons"""


for i in range(0,len(l)):
    time+=l[i][1]#time after the coupon is redeemable
    if time<=l[i][0]:#comparing expiry time
        count+=1
    else:
        time-=l[i][1]#if exceeds expiry we ignore coupon so reset time.

        
print(count)
