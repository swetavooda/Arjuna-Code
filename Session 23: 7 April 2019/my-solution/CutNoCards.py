a=input()
ch=1
i=0
count=0
magic=False
ans=a[0]
ansc=1
while ch<len(a):
    #print('ch',ch)
    
    while i<len(a):
        if i+ch<=len(a):
            
            s=a[i:i+ch]
            t=i+ch
            if i==0:
                ans=s
                ansc=ch
            #print('s',s,'t',t)
            if s=='9'*ch:
                ch+=1
            if t+(ch)<=len(a):
                e=a[t:t+ch]
               # print(t,t+ch)
                #print(s,e)
                if int(e)-int(s)!=1:
                    count=1
                #print(s,e,int(e)-int(s),count)
        else:
            t=i+ch
        i=t
        
    if count==1:
        magic=False
    else:
        if len(a)<(ansc*2):
            magic=False
            break
        else:
            magic=True
            break
    if ansc==ch:
        ch+=1

    i=0
    count=0
    magic=False
if magic==True and ans[0]!='0':
    
    print("YES",ans)
elif magic==True and ans[0]=='0' and ansc==1:
    print("YES",ans)
else:
    print("NO")
        
