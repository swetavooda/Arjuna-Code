from itertools import permutations

l=list(map(int,input().split()))
temp=list(set(permutations(l,len(l))))#contains list of all permutations possible.
count=0

'''logic: for every element in the list we will check if it satisfies the condition,
          of perfect square pairs,if not flag=0 and we break out of loop and check for other elements
          else flag remains 1 and count is incremented.
'''          
for j in temp:
    flag=-1
    i=0
    while i<len(j)-1:
        n=j[i]+j[i+1]
        sq=int(n**.5)
        if sq*sq!=n:
            flag=0
            break
        else:
            flag=1
        i+=1
    if flag==1:
        count+=1
print(count)
