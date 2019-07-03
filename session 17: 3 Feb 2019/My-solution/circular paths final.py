
x=int(input())
final_ans=[]
charge=list(map(int,input().split()))
total=sum(charge)


X=list(map(int,input().split()))
a=X[0]
b=X[1]
sum=0
order=[]
for i in range(1,x+1):
    order.append(i)
frozen_order=tuple(order)

if a==b:
    price=[]
    'clockwise'
    c_order=order[order.index(a):]+order[0:order.index(a)]
    c_charge=charge[order.index(a):]+charge[0:order.index(a)]
    p=0
    for i in range(0,len(c_order)-1):
        p+=c_charge[i]
        price.append([p,'c',c_order[i]])
        
    'anticlockwise'
    
    anticharge=c_charge
    anticharge.reverse()
    
    a_order=order[order.index(a):]+order[0:order.index(a)]
    a_charge=anticharge
    
    p=0
    for i in range(0,len(a_order)-1):
        p+=a_charge[i]
        price.append([p,'a',a_order[i]])
        
    'findind least charges'
    price.sort()
    point=price[0][2]
    
    if price[0][1]=='c':
        i=1
        add=0
        for i in range(1,len(price)):
            if price[i][1]=='a' and c_order.index(price[i][2])>=c_order.index(point):
                add=price[i][0]
                break
    else:
        i=1
        add=0
        for i in range(1,len(price)):
            if price[i][1]=='c' and c_order.index(price[i][2])<=c_order.index(point):
                add=price[i][0]
                break
    
    final_ans=[]
    for i in range(0,len(price)):final_ans.append(2*(price[i][0]))
    
    final_ans.sort()
    final_ans.append(final_ans[0]+2*(add))
    final_ans.append(2*total)
    final_ans.sort()
    print(final_ans[0])
    
    
else:
    
    c_order=order[order.index(a):]+order[0:order.index(a)]
    c_charge=charge[order.index(a):]+charge[0:order.index(a)]

    c_dict={}
    for i in range(0,len(c_order)):
        c_dict[c_order[i]]=c_charge[i]

    #direct path.    
    sum=0
    for i in range(0,c_order.index(b)):
        sum+=c_dict[c_order[i]]
    ans=sum
    cdirect_ans=sum

    #indirect path.
    p=ans
    for j in range(c_order.index(b),len(c_order)):
        p+=2*(c_dict[c_order[j]])
        if p<ans:
            ans=p
    clockwise_ans=ans

    cp_ans=[]
    p=0
    for i in range(0,c_order.index(b)):
        p+=2*(c_dict[c_order[i]])
        cp_ans.append(p)
    cp_ans.sort()
    final_ans.append(clockwise_ans)

    antiorder=order
    antiorder.reverse()

    anticharge=c_charge
    anticharge.reverse()

    a_order=order[order.index(a):]+order[0:order.index(a)]
    a_charge=anticharge

    a_dict={}
    for k in range(0,len(a_order)):
        a_dict[a_order[k]]=a_charge[k]
    
    #direct path.
    sum=0
    for l in range(0,a_order.index(b)):
        sum+=a_dict[a_order[l]]
    ans=sum
    adirect_ans=sum

    #indirect path.
    p=ans
    for m in range(a_order.index(b),len(a_order)):
        p+=2*(a_dict[a_order[m]])
        if p<ans:
            ans=p
    anticlockwise_ans=ans

    final_ans.append(anticlockwise_ans)

    ap_ans=[]
    p=0
    for i in range(0,a_order.index(b)):
        p+=2*(a_dict[a_order[i]])
        ap_ans.append(p)
    ap_ans.sort()
    
    final_ans.append(adirect_ans+cp_ans[0])
    final_ans.append(cdirect_ans+ap_ans[0])

    final_ans.sort()
    print(final_ans[0])
