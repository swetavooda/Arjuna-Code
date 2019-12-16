stones,pairs=map(int,input().split())
num_stones=list(map(int,input().split()))
start=pairs*2

total=0
for i in range(0,len(num_stones)):
    total+=num_stones[i]//2 #calculating number of pairs possible
    
'''if the given number of stones is not satisfiying required pairs i.e.,totalpairsformed<pairsrequired'''
''' else arithmetically all combinations taken for types of stones for getting required pairs can be represented as:
            numberOfPairs*2 + numberOfStones -1'''
if total<pairs:
    print(-1)
else:
    print(start+stones-1)
