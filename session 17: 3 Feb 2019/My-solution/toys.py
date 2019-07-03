number_of_boxes=int(input())
C=[int(j) for j in input().split()]

#converting into imutable,i.e,tuple.
C=tuple(C[:number_of_boxes])
initial=list(C)
final=list(C)
final.sort()
final.reverse()#final is the final arrangment we want.

count=0
while initial!=final:#we check loop till we get the final arrangement.
    i=0
    while i<(number_of_boxes-1):
        if initial[i]<initial[i+1]:#if there is no toy.
            p=initial[i]
            initial[i]=initial[i+1]#swaping
            initial[i+1]=p
            i+=2#checking for the positions after those two.
        else:#if there is a toy.
            i+=1#increment of i to check next position.
    count+=1
print(count)
    



