number_of_athletes=int(input())
queue=list(map(int,input().split()))#given queue is stored in the list queue.
dict_numbermedals={}#dictionary containing college cose and number of medals won.
visited=[]
for i in queue:
    if i not in visited:
        count=0
        for j in queue:
            if i==j:
                count+=1
        dict_numbermedals[i]=count
        visited.append(i)

number_of_medals=[]#list containg number of medals won.in order.
for i in queue:
    number_of_medals.append(dict_numbermedals[i])
    
output=[]
for i in range(0,len(queue)):
    max_exists=False
    for j in range(i,len(queue)):
        if number_of_medals[i]<number_of_medals[j]:
            
            output.append(queue[j])
            max_exists=True
            break
    if max_exists==False:
        output.append(-1)
        
        
for i in output:
    print(i,end=" ")
