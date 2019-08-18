final_combination=[]#list that stores all combinations
'''here the combinations for input:123 is=['111','12','21']'''

alp='0ABCDEFGHIJKLMNOPQRSTUVWXYZ'#to find codes.

'''logic to find all the combinations in which we can group digits to find codes
    find_all_combinations forms a list of all combinations'''
def find_all_comb(set,k):
    n=len(set)
    find_all_combinations(set,"",n,k)
def find_all_combinations(set,prefix,n,k):
    if k==0:
        suma=0
        for i in prefix:
            suma+=int(i)
            if suma>len(a):
                break
        if suma==len(a):
            final_combination.append(prefix)
        return
    for i in range(n):
        newPrefix=prefix+set[i]
        find_all_combinations(set,newPrefix,n,k-1)

'''logic to find all valid codes
    by using combinations we check if the group is valid or not 
    if valid we append to the ans list which contains all codes(possible)
    the def returns a list of all possible codes'''
def find_codes():
    ans=[]
    for i in final_combination:
        start=0
        final=[]
        flag=0
        for k in range(0,len(i)):
            send=a[start:start+int(i[k])]
            if send[0]=='0':
                flag=1
                break
            if int(send)>26:
                flag=1
                break
            else:
                final.append(alp[int(send)])
                start=start+int(i[k])
        if flag!=1:
            ans.append(final)
        
    return ans
    
    

a=input()
#to find combinations
for i in range(1,len(a)+1):
    find_all_comb(['1','2'],i)
#codes contains all possible codes.
codes=find_codes()

print(len(codes))


