x=list(map(int,input().split()))
number_of_allies=x[0]
number_of_pairs=x[1]

amount_of_gold=list(map(int,input().split()))
charges={}
for i in range(1,number_of_allies+1):charges[i]=amount_of_gold[i-1]

pairs=[]
for i in range(0,number_of_pairs):
    pairs.append(list(map(int,input().split())))



pairs_dict={}
for i in range(1,number_of_allies+1):pairs_dict[i]=[]


for i in range(0,len(pairs)):
    pairs_dict[pairs[i][0]].append(pairs[i][1])
    pairs_dict[pairs[i][1]].append(pairs[i][0])


sum=0
visited=[]
ans=0
for i in pairs_dict:
    print(i)
    if pairs_dict[i]!=[] and i not in visited:
        print('in if',i)
        q=[i]
        
        visited.append(i)
        cost=[]
        sum=charges[i]
        while q!=[]:
            r=q.pop(0)
            print('r',r)
            for j in range(0,len(pairs_dict[r])):
                #print(pairs_dict[i][j])
                if (pairs_dict[r][j]) not in visited:
                    print('pairs_dict[i][j]',pairs_dict[r][j])
                    q.append(pairs_dict[r][j])
                    print('q',q)
                    visited.append(pairs_dict[r][j])
                    if sum>charges[pairs_dict[r][j]]:
                        sum=charges[pairs_dict[r][j]]
        print(i,visited)
        ans+=sum
        print('ans',i,sum,ans)
    elif pairs_dict[i]==[]:
        print('in elif',i)
        ans+=charges[i]
        visited.append(i)

print(ans)
