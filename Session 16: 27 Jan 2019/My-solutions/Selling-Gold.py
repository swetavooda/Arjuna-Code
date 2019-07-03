#number of months.
num_of_months=int(input())

'''months_data=input()
l=list(map(int,months_data.split()))'''

#to take the input into a list.
months_data=input()
#l is the list containing input data.
l=[]
l=months_data.split()
for j in range(len(l)):
    l[j]=int(l[j])
    
#nested loop to find minimun loss.
loss=False
for i in range(0,len(l)):
    for x in range(i+1,len(l)):
        s=l[i]-l[x]
        if s>=0 and loss==False:
            ans=s
            loss=True
        if loss==True and ans>=s and s>=0:
            ans=s

#since minimum loss cannot be negative.            
if loss==True:
    print(ans)
