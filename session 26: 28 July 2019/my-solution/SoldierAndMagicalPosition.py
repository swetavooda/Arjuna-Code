dead_lock=list(map(str,input().split()))
destination=input()
beg='0000'

"""case1: if the starting position is in daedlock it is not possible"""
if '0000' in dead_lock:
    print(-1)
    
    """case2: if one step forward and backward to destination is in deadlock.
    example:
    destination= '5678'
        deadlock= '4678' '6678' '5578' '5778' '5668' '5688' '5679' '5677'
        then it is impossible to reach destination"""
else:
    ans=[]
    for i in range(0,4):
        s=int(destination[i])
        if(s!=9):
            ans.append(destination[0:i]+str(s+1)+destination[i+1:])
        elif(s!=0):
            ans.append(destination[0:i]+str(s-1)+destination[i+1:])
    flag=0
    for i in ans:
        if i not in dead_lock:
            flag=1
    if flag==0:
        print(-1)
    
        """ check if a path while moving only front can be achived without getitng stuck
            if yes : then printing the count(no. of steps)
            the while conditions checks all the steps forward
                if checks weather in dead lock or not
                if not then move ahead and count"""
    else:
        start='0000'
        count=0
        for i in range(0,4):
            p=int(start[i])
            while(int(destination[i])>=p):
                start=start[0:i]+str(p)+start[i+1:]
                if destination[i]==start[i]:
                    if beg[i]!=start[i]:
                        count+=1
                        break
                    else:
                        break
                if start not in dead_lock:
                    p+=1
                else:
                    start=start[0:i]+str(int(p)-1)+start[i+1:]
                    count+=1
                    break
    print(count)
