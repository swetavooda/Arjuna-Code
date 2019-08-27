dialpad=[['0','1','2'],['3','4','5'],['6','7','8'],['9',None,None]]#list containing postion of dialpad
start='0'#contains current position.
x=0
y=0
number=input()
''' logic:
        for every digit in the number we are going it check in the while loop and fine position until we reach destination.
        given priority U,L,D,R
        first we check number of steps for going up and down whichever is less we consider that one.
        then we start printing the position by mobing in the given direction'''
for i in number:
    upcount=0
    downcount=0
    while start!=i:
        a=x
        while i not in dialpad[a]:#counting upcount
            if a-1>=0:
                upcount+=1
                a-=1
            else:
                upcount=0
                break
        b=x
        while i not in dialpad[b]:#counting downcount
            if b+1<=3:
                downcount+=1
                b+=1
            else:
                downcount=0
                break
        if upcount>=downcount:#since U more priority than D.
            while i not in dialpad[x]:#moving on step up and checking
                if x-1>=0:
                    x-=1
                    start=dialpad[x][y]
                    print('U',end="")
        elif upcount<downcount:#if it takes less steps downward.
            while i not in dialpad[x]:#moving one step down and checking.
                if x+1<=3:
                    x+=1
                    start=dialpad[x][y]
                    print('D',end="")
        if i in dialpad[x]:#if number in same row
            if y-1>=0:#boundry condtion
                if dialpad[x][y-1]==i:#if found on left.
                    y-=1
                    start=dialpad[x][y]
                    print('L',end="")
                elif y-2>=0 and dialpad[x][y-2]==i:#if found on two steps right.
                    y-=2
                    start=dialpad[x][y]
                    print('LL',end="")
            if y+1<3:#boundry condtion
                if dialpad[x][y+1]==i:#if fount right
                    y+=1
                    start=dialpad[x][y]
                    print('R',end="")
                elif y+2<3 and dialpad[x][y+2]==i:#if found two steps right.
                    y+=2
                    start=dialpad[x][y]
                    print('RR',end="")
                
            if i==dialpad[x][y]:
                start=i
    if start==i:
        print('-',end="")
            
                    
                
