C=list(map(int,input().split()))
M=list(map(int,input().split()))
M.sort()
number_of_offers=C[1]

#esell is a dictionary containg all offers.
esell={}
for i in range(1,number_of_offers+1):
    p=input()
    esell[i]=list(map(int,p.split()))


l=[]
#checking each days exchange offer.
for i in esell:
    a=esell[i]
    if a[1]>=a[2]:#sorting the offers such that index(1)<index(2)
        b=a[1]
        a[1]=a[2]
        a[2]=b
    l.append(a)
l.sort()
'''list containg all offers(index(0)-day,index(1)-tv to
be exchanged,index(2)-tv that u would get.'''
for d in range(1,number_of_offers+1):#checks each days offers.
    for k in range(0,number_of_offers):#checks tvs in offer
        for i in range(len(M)):#checks tv with mechanic.
            if d==l[k][0]:#if its on same day.
                if l[k][1]==M[i] and M[i]<=l[k][2]:#if tv with mechanic,he would exchange.
                    M[i]=l[k][2]

sum=0
for x in range(C[0]):
    sum+=M[x]
print(sum)    
