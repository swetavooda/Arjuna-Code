
l=list(map(int,input().split()))
one_day,one_week,one_month=map(int,input().split())
costf=[]
cost=0
start=0
s=0

def wend(start):
    flag=0
    for i in range(start,len(l)):
        flag=1
        if l[i]<=l[start]+7:
            end=i
        else:
            break
    if flag==1:
        return end
    else:
        return start
    
def mend(start):
    flag=0
    for i in range(start,len(l)):
        flag=1
        if l[i]<=l[start]+30:
            end=i
        else:
            break
    if flag==1:
        return end
    else:
        return start
weekend=wend(start)
monthend=mend(start)
for i in range(0,len(l)):
    
    if weekend<i:
        weekend=wend(i)
    if monthend<i:
        monthend=mend(i)


    cost+=one_day
    #print('i=',i,cost,weekend,monthend)
    
    if i==weekend and weekend<=monthend and start==s:
        #print('inweekend',i)
        if cost>one_week:
            cost=one_week
            #costf+=cost
            start=i+1
            weekend=wend(start)
            
    
    if i==monthend:
        #print('inmonthend',i)
        if cost>one_month:
            cost=one_month
            start=i+1
            monthend=mend(start)
        if i==len(l)-1:
            #print("hi")
            costf.append([cost,s,i])
            cost=0
            s=i+1
            #print(cost)    
        else:
            costf.append([cost,s,i])
            cost=0
            s=i+1
    
s=costf[-1][-1]
if s!=len(l)-1:
    cost=(len(l)-s-1)*one_day
    #for i in range(s,len(l)):
    costf.append([cost,[s,len(l)-1]])   
#print(costf)
sum=0
for i in costf:
    sum+=i[0]
print(sum)










    
    
