#function to find number of coins prepared with given no. of coins.
def coins(m,wastage):
    l=[]
    for i in range(0,m):
        l.append(1)
    count=0
    for i in l:
        if i==1:
            count+=1
        if count==wastage:
            l.append(1)
            count=0
    return len(l);



'''start of program'''
number_of_coins,wastage=[int(x)for x in input().split()]

#if wastage is 1.then ans is 1.
if wastage==1:
    print(1)
    exit()


#using binary search.
s=1
e=number_of_coins
m=(s+e)//2
while s<m and m<e:
    if coins(m,wastage)>number_of_coins:
        e=m
    elif coins(m,wastage)<number_of_coins:
        s=m
    if coins(m,wastage)==number_of_coins:
        break
    
    m=(s+e)//2#end of binary search.



#if the number of coins can be exactly made .
if coins(m,wastage)==number_of_coins:
    print(m)

    
#otherwise checking for values in the range of starting to end point.
else:
    for i in range(s,e+1):
        if coins(i,wastage)>=number_of_coins:
            print(i)
            break
    
    

    


