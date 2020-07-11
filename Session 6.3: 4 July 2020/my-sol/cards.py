m,n=map(int,input().split(','))
cards=[]
#cheking constarints
if(m<1 or m>20 or n<1 or n>50):              
    print("Invalid Input")
    exit()
    
#taking input
for i in range(0,m):
    l=list(map(int,input().split(',')))
    cards.append(l)



maxc=0
ans=""
pos=0
""" for each deck pop the first maximum numbered card and add to string"""
while(True):
    flag=0#to check if there is empty deck
    maxc=-1
    for i in range(0,m):       
        if(cards[i]!=[]):
            flag=1
            maxa=max(maxc,cards[i][-1])
            if(maxa!=maxc):
                pos=i
                maxc=maxa
    if(flag==1):
        popped=cards[pos].pop(-1)
        ans+=str(popped)
    else:#if all decks empty
        break
print(ans)

"""
but this solution doest work for inputs such as:
3,3
1,3,4
4,3,2
5,1,1

correct output: 432341151
acording to testcases: 432341115
"""
"""this problem occurs when all decks or anytwo decks show same cards numbers
in that case we must pick up the caard whose next card is the highest"""
#solution
"""
m,n=map(int,input().split(','))
cards=[]
if(m>20 or m<1) :
    print("Invalid Input")
    exit()
if(n>50 or n<1) :
    print("Invalid Input")
    exit()
for i in range(0,m):
    l=[]
    
    l=list(map(int,input().split(',')))
    l.reverse()
    cards.append(l)
    

cards.sort()
cards.reverse()
maxc=0
ans=""
pos=0
while(True):
    flag=0
    maxc=0
    for i in range(0,m):
        #print(cards)
        if(cards[i]!=[]):
            flag=1
            maxa=max(maxc,cards[i][0])
            if(maxa!=maxc):
                pos=i
                maxc=maxa
    if(flag==1):
        popped=cards[pos].pop(0)
        ans+=str(popped)
        cards.sort()
        cards.reverse()
    else:
        break
print(ans)
        
"""
