l=list(map(int,input().split()))
d=l[1]-l[0]
start=0
count=0
counts=[]#contains count of all equally spaced numbers.


for i in range(1,len(l)):
    if l[i]-l[i-1]==d:
        count+=1
        
    else:
        counts.append([start,count+start])
        start=i-1
        count=0
        d=l[i]-l[i-1]
        s=i
        count+=1
counts.append([start,count+start])

''' example  
    if input= 1 2 3 4 5 7 9 11 15 20 25
    counts contains
    counts=[[0, 4], [4, 7], [7, 8], [8, 10]] #i.e from index 0:4 , 4:7 , 7:8 , 8:10 they are equally spaced
'''

final=[]        
for i in counts:
    final.append(l[i[0]:i[1]+1])
    
#final will contain ; final=[[1, 2, 3, 4, 5], [5, 7, 9, 11], [11, 15], [15, 20, 25]]

ans=[]
'''finding all the possible ladders.'''
for k in final:
    for i in range(3,len(k)+1):
        for j in range(0,len(k)):
            if j+i<=len(k):
                ans.append(k[j:j+i])
                
print(len(ans))
