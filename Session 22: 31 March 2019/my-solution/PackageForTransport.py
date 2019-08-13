weights=list(map(int,input().split()))#taken input.
weights.sort()
weights.reverse()


k=int(input())


boats=0#ans
indexs=[]#list containing indexes of weights put on the boat.(initialised to minimize error of recounting same weight)

'''logic:
    while going along the list we check if the weight is equal to k then add 1 to boats .
    otherwise we check other elements after that and check if sum is <=k and add it to a list 'add' .
    finally we check for greatest value in add and count them for packaging and increase boat by 1.
'''
for i in range(0,len(weights)):
    if weights[i]>k:
        continue
    elif weights[i]==k and i not in indexs:
        boats+=1
        indexs.append(i)
    elif weights[i]<k and i not  in indexs:
        s=weights[i]
        j=i+1
        add=[]
        while j<len(weights) :
            if weights[j]<=k-s and j not in indexs:
                add.append([weights[j],j])
            j+=1
        add.sort()
        add.reverse()
        
        if add!=[]:
            indexs.append(add[0][1])
            indexs.append(i)
            boats+=1
        else:
            indexs.append(i)
            boats+=1
            
print(boats)
    
