
#input
n=int(input())
angles=list(map(int,input().split(",")))

#checking constraints
if n>50:
    print("Invalid Input N")
    exit()
for i in angles:
    if(i>90 or i<-89):
        print("Invalid Input Angles")
        exit()
#finding all combinations of three angles
comb=[]
ans=0
for i in range(0,n):
    for j in range(i+1,n):
        for k in range(j+1,n):
            #if all angles are unique then triangle is formed
            if(angles[i]!=angles[j] and angles[i]!=angles[k] and angles[k]!=angles[j]):
                ans+=1
            
            


print(ans)
