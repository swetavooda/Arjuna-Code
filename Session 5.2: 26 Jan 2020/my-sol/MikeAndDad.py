p,q=map(int,input().split())
a=[]
for i in range(0,p):
    a.append(int(input()))
l=list(range(1,q+1))
dictQ=[]
ans={}
FinalAns={}
for i in a:
    ans[i]=0
    FinalAns[i]=0
for i in range(1,q+1):
    dictQ.append([0,i,[]])
    for j in a:
        if(j%i==0):
            ans[j]+=1
            dictQ[i-1][0]+=1
            dictQ[i-1][2].append(j)
newDict=dictQ
def removeElement(dic,i,R):
    for j in dic:
        if R in j[2]:
            j[2].remove(R)
            j[0]-=1
    for j in dic:
        if j[0]==0:
            dic.remove(j)
        elif j[1]==i:
            for k in j[2]:
                ans[k]-=1
            dic.remove(j)
    return dic



dictQ.sort()
while dictQ:
    i=dictQ[0]
    if i[0]==0:
        dictQ.remove(i)
    elif i[0]==1:
        ans[i[1]]=i[2][0]
        FinalAns[i[2][0]]=i[1]
        del ans[i[2][0]]
        dictQ=removeElement(dictQ,i[1],i[2][0])
    elif i[0]!=0:
        R=i[2][0]
        p=ans[R]
        for k in i[2]:
            if ans[k]<p:
                p=k
        FinalAns[R]=i[1]
        del ans[R]
        dictQ=removeElement(dictQ,i[1],R)
   
print(len(FinalAns))
