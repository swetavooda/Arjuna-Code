andrea_n=int(input())
a=[]
for i in range(0,andrea_n):
    p=int(input())
    a.append(p)
#print('done')
maria_n=int(input())
m=[]
for i in range(0,maria_n):
    p=int(input())
    m.append(p)
#print('done')
ap=[]
mp=[]

chance=input()
for i in range (0,min(andrea_n,maria_n)):
    #print(ap,mp)
    if chance=='Even':
        if i%2==0:
            ap.append(a[i]-m[i])
            mp.append(m[i]-a[i])
            
    
    else:
        if i%2!=0:
            ap.append(a[i]-m[i])
            mp.append(m[i]-a[i])
#print(ap,mp)
if sum(ap)>sum(mp):
    print('andrea')
            
else:
    print('Maria')
