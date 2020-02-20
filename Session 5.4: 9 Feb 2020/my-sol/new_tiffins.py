from itertools import combinations

#taking input into list
a=list(map(str,input().split()))
b=list(map(int,input().split()))
c=list(map(str,input().split()))

# all_orders contains a list with (name,timestamp,order)
all_orders=list(zip(a,b,c))
#set of all unique customers
names=set(a)

#dictionary containg each persons ordered tiffins in a set
dictt={}
for i in names:
    dictt[i]=[]
for i in all_orders:
    dictt[i[0]].append(i[2])
    x=dictt[i[0]]


finalcombs=[]
for i in dictt:
    c=dictt[i]
    l=combinations(c,3)
    finalcombs.extend(l)

c=0
ans=0
finalcombs.sort()
for i in range(0,len(finalcombs)):
    c=finalcombs.count(finalcombs[i])
    if c>ans:
        anstup=finalcombs[i]
        ans=c
    if c==3:
        break
list(anstup).sort()
for i in anstup:print(i)
