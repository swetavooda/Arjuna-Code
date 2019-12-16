import operator

n,maxTheme,total=map(int,input().split())
decCost=list(map(int,input().split()))
sellingPrice=list(map(int,input().split()))

dictpriority={}#dictionary storing themes cost and price in order(max-min profit)

'''sorting the dictpriority '''
dictpriority[0]=sellingPrice[0]
cost=0
for i in range(1,maxTheme):
    cost+=decCost[i-1]
    dictpriority[i]=sellingPrice[i]-cost#calculating profit
priority = sorted(dictpriority.items(), key=operator.itemgetter(1))#sorting
priority.reverse()



coinsNeeded={}#dictionary to store effective spends for coins needed to buy and sell new theme

'''calculating coinsneeded to reach and the hieghest priority theme'''
coinsNeeded[0]=0
cost=0
for i in range(0,maxTheme-1):
    cost+=decCost[i]
    coinsNeeded[i+1]=cost

idols=n#total idols

'''logic: going in order and checking if we have enough coins to buy the theme with highest priority possible
            for each theme in priority order
            if enough coins found add effective cost to total coins'''
while idols>0: #run loop till all idols are sold
    for i in priority:
        if total>=coinsNeeded[i[0]]:#if enough coins to buy theme
            total+=i[1]
            break
    idols-=1
    
print(total)           
