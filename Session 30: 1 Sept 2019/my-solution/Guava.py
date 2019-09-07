given=tuple(map(int,input().split()))
l=int(input())
n=len(given)
s=(n-l+1)%(l-1)
groups=given

#condition to check weather possible or not.
if s+l-1==l or l-1==1:
    ans=[]#contains price charged for every merge.
    leastsum=sum(groups)#least sum of 'l' consequtive guavas.
    temp=list(given)#temp list to keep track of piles of guava after evry merge.
    while len(temp)!=1:
        prev=tuple(temp)#prev contains previuos list of groups.
        temp=[]
        leastsum=sum(prev)
        i=0
        while i<=len(prev)-l:#loop to find min sum of 'l' consequtive groups (leastsum)
            suma=0
            for j in range(0,l):
                suma+=prev[j+i]
            if leastsum>=suma:
                leastsum=suma
                pos=i
            i+=1
            
        ans.append(leastsum)
        
        #entering new group data into temp.
        for k in range(0,pos):
            temp.append(prev[k])
        temp.append(leastsum)
        for k in range (pos+l,len(prev)):
            temp.append(prev[k])
            
    #final ans is sum of all grouping charges.
    print(sum(ans))

else:
    print(-1)
