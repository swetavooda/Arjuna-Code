no_of_people,n=map(int,input().split())
initiated=[]
suspects=[]
for i in range(0,n):
    a,b=map(int,input().split())
    initiated.append(a)
    suspects.append(b)
flag=0
for i in suspects:
    if i not in initiated:
        print(i)
        flag=1
        break
if flag==0:
    print(-1)
