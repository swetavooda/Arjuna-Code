king_num=[]
guess_num=[]
guess_set=[]
king=input()
guess=input()
for i in range (0,len(king)):
    king_num.append(king[i])
for i in range (0,len(guess)):
    guess_num.append(guess[i])
    guess_set.append(guess[i])
arrow=0
bow=0
for j in range(0,2):
    for i in range(0,len(king_num)):
        
        if(j==0):
            if(king_num[i]==guess_num[i]):
                arrow+=1
                guess_set.remove(king_num[i])
                #del guess_set[guess_set.index(king_num[i])]
        else:  
            if(king_num[i] in guess_set):
                bow+=1
                guess_set.remove(king_num[i])
                
            
            
ans=str(arrow)+'A'+str(bow)+'B'
print(ans)
