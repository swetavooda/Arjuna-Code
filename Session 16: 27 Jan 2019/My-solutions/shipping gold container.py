#take input of first line.
c=input()
C=[]
C=c.split()
for j in range(len(C)):
    C[j]=int(C[j])


#take input of checkpoint positions and number of security personal.   
checkpoint_position={}#a dictionary to store checkpoint details.
a=[]
for i in range(C[0]):
    p=input()
    a=p.split()
    for j in range(len(a)):
        a[j]=float(a[j])
    checkpoint_position[i+1]=a


#to create a list containg the ranges of each security area in ascending order.    
l=[] #l is the list containg ranges. 
for i in checkpoint_position:
    l1=checkpoint_position[i]
    a=[l1[0]-l1[1],l1[0]+l1[1]]
    l.append(a)
l.sort()


#end is the end point of a way with security.
s=0#s is the distance without security.
'''conditions to intialize the values of s and end.'''
if (l[0][0]-C[1])>0:#if security starts after the journey of gold container.
    s=(l[0][0]-C[1])
    end=l[0][1]
elif l[0][1]>C[1]:#if security starts before or at the journey of gold container.
    end=l[0][1]
else:#if security area covers distance before the journey path.
    end=C[1]
    
'''loop to calculate the value of s'''    
for i in range(1,C[0]):
    if l[i][0]<=C[2]:#to take security area only in between the jouney of the container.
        if end>=l[i][0]:
             if end<l[i][1]:
                end=l[i][1]
        else:
            s+=(l[i][0])-end
            end=l[i][1]
    else:
        break
        
if C[2]-end>0:#to cover area after last security and end of journey.
    s+=C[2]-end
    
print(int(s))
