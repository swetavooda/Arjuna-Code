guava=list(map(int,input().split()))
L=int(input())
total=0
while(len(guava)!=1 and len(guava)>=L ):
    minimum,pos=sum(guava),0
    for i in range(len(guava)-L+1):
        if(minimum>=sum(guava[i:i+L])):
            minimum=sum(guava[i:i+L])
            pos=i
    total+=minimum
    # remove
    for i in range(L):
        guava.remove(guava[pos])
    guava.insert(0,minimum)
if(len(guava)==1 and L>1):
    print(total)
else:
    print(-1)
