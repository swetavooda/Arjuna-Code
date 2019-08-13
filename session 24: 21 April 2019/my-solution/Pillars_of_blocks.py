first,second,third=map(int,input().split())
p1=list(map(int,input().split()))
p2=list(map(int,input().split()))
p3=list(map(int,input().split()))
p=[p1,p2,p3]
def summ(p):
    p1=sum(p[0])
    p2=sum(p[1])
    p3=sum(p[2])
    if p1==p2:
        if p2==p3:
            return(1)
        else:
            return(0)
    else:
        return(0)

def sort(p):
    for i in range(0,len(p)):
        for j in range(i,len(p)):
            if sum(p[i])<sum(p[j]):
                temp=p[i]
                p[i]=p[j]
                p[j]=temp
while 1:
    sort(p)
    #print('\n',p)
    q=p[0].pop(0)
    
    #print(q)
    #print(p)
    if summ(p):
        #print('hi')
        break
print(sum(p[0])) 
