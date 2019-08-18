no_of_inputs=int(input())

kingdoms_dict={}#dictionary containg all information
''' example: 1:[6,[2,4]] here 6 is the army in thousands and the list [2,4] is the list of allies'''
for i in range(0,no_of_inputs):
    given=list(map(int,input().split()))
    if len(given)>2:
        kingdoms_dict[given[0]]=[given[1],given[2:]]
    else:
        kingdoms_dict[given[0]]=[given[1]]
q=[]
total=0
q.append(int(input()))
'''logic: for each of the alies we append them in the queue(q) and find army strenght 
            by finding value from dictionary kingdoms_dict'''
while q!=[]:
    total+=kingdoms_dict[q[0]][0]
    if len(kingdoms_dict[q[0]])>1:
        for i in range(0,len(kingdoms_dict[q[0]][1])):
            q.append(kingdoms_dict[q[0]][1][i])
    q.pop(0)
print(total)
        
