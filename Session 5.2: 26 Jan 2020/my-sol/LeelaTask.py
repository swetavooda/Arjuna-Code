from itertools import product
from itertools import permutations
from itertools import combinations_with_replacement

n=int(input())
l=list(map(int,input().split()))
l.sort()
M=int(input())
k=""
for i in range(0,n):
    k+=str(l[i])
def lenD(num):
    if len(str(num))>=n:
        return True
    return False
if M==2 or (M%2==0):
    if(M!=2):
        flagnum=1
    if not((2 in l) or (4 in l) or (6 in l) or (0 in l)or (8 in l)):
        print(-1)
        exit()
if M==5 or M%5==5:
    if M!=5:
        flagnum=1
    if not((5 in l) or (0 in l)):
        print(-1)
        exit()
if M==10 or M%10==0:
    if M!=10:
        flagnum=1
    if (0 not in l):
        print(-1)
        exit()
    

def no_repeat(k):
    flagnum=1
    flag=0
    if flagnum==1:
        for p in permutations(k):
            if p[0]!='0':
                k=''.join(p)
                num=int(k)
                #ans.append(num)
                if num%M==0:
                    print(num)
                    print(int(num/M))
                    exit()
                    flag=1
                    break
        if flag==0:
            return False

def find_ans(l):
    flag=0
    for num in l:
        if(num==153171):print('here')
        if num%M==0:
            
            print(num)
            print(int(num/M))
            exit()
            flag=1
            break
        if flag==0:
            return False
        

def find_list(l):
    final=[]
    flag =0
    for k in l:
        for p in permutations(k):
            if p[0]!='0':
                k=''.join(p)
                num=int(k)
                final.append(num)

    final.sort()
    flag=0
    for x in final:        
        if x%M==0:
            
            print(x)
            print(int(x/M))
            exit()
    return final
                
            
def getCombinations(string,length):
    return list(combinations_with_replacement(string,length))

a=no_repeat(k)
for i in range (n+1,10):
    q=getCombinations(k,i-n)
    send=[]
    for j in q:
        new_string=k
        for x in range(0,len(j)):
            new_string+=j[x]
        send.append(new_string)
    newList=find_list(send)
        
print(-1)
