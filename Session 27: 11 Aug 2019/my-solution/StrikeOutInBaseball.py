all_possibilities=[]
def _permutation_repeat(text,prefix,n,k):
    if k==0:
        all_possibilities.append(prefix)
        return
    for i in range(n):
        new_prefix=prefix+text[i]
        _permutation_repeat(text,new_prefix,n,k-1)
def permutation_repeat(text,k):
    _permutation_repeat(text,"",len(text),k)
count=0
no_of_balls=int(input())
permutation_repeat('01',no_of_balls)
for i in all_possibilities:
    if '000' not in i:
        count+=1
print(count)
