chess=[]
#functions to find if check possible from kings side
def inbounds(i,j):
    
    if not(i>=0 and i<8):
        return False
    if not(j>=0 and j<8):
        return False
    return True
def isPawn(c,si,sj,chess):
    if(c.lower):
        #i=si-1
        for j in (1,-1):
            if(inbounds(si-1,sj+j)):
                if(chess[si-1][sj+j]==c):
                    return True
        return False
    else:
        for j in (1,-1):
            if(inbounds(si+1,sj+j)):
                if(chess[si+1][sj+j]==c):
                    return True
        return False
    
def isKnight(c,si,sj,chess):
    l=[(2,1),(2,-1),(-2,1),(-2,-1),(1,2),(1,-2),(-1,2),(-1,-2)]
    for i in l:
        if(inbounds(si+i[0],sj+i[1]) and chess[si+i[0]][sj+i[1]]==c):
           return True
    return False
            
def isBishop(c,si,sj,chess):
    #down-right
    i=si+1
    j=sj+1
    while(i<8 and j<8):
        if chess[i][j]==c:
            return True
        if(chess[i][j]!='-'):
            break
            
        i+=1
        j+=1
    #down-left
    i=si+1
    j=sj-1
    while(i<8 and j>0):
        if chess[i][j]==c:
            return True
        if(chess[i][j]!='-'):
            break
            
        i+=1
        j-=1
    #top-right
    i=si-1
    j=sj+1
    while(i>0 and j<8):
        
        if chess[i][j]==c:
            return True
        if(chess[i][j]!='-'):
            break
            
        i-=1
        j+=1
    #top-left
    i=si-1
    j=sj-1
    while(i>0 and j>0):
        if chess[i][j]==c:
            return True
        if(chess[i][j]!='-'):
            break
            
        i-=1
        j-=1
    return False
    
def isRook(c,si,sj,chess):
    i=si+1
    #down
    while(i<8):
        if chess[i][sj]==c:
            return True
        if(chess[i][sj]!='-'):
            break
            
        i+=1
    #up
    i=si-1
    while(i>0):
        #print(chess[i][sj])
        if chess[i][sj]==c:
            return True
        if(chess[i][sj]!='-'):
            break
        i-=1
    #right
    j=sj+1
    while(j<8):
        if chess[si][j]==c:
            return True
        if(chess[i][sj]!='-'):
            break
        j+=1
    #left
    j=sj-1
    while(j>0):
        if chess[si][j]==c:
            return True
        if(chess[i][sj]!='-'):
            break
        j-=1
    return False

        
    
def findKing(c,chess):
    #black
    if(c=='k'):
        for i in range(0,8):
            if c in chess[i]:
                return i,chess[i].index(c)
    #white
    else:
        for i in range(7,-1,-1):
            if c in chess[i]:
                return i,chess[i].index(c)


#driver code starts here
#take input       
for i in range(0,8):
    chess.append(input())

#find king position
#black (top,small)
i,j=findKing('k',chess)
#rook
if(isRook('R',i,j,chess)):
    print("black king in danger")
    exit()
#bishop
if(isBishop('B',i,j,chess)):
    print("black king in danger")
    exit()
#knight
if (isKnight('N',i,j,chess)):
    print("black king in danger")
    exit()
#pawn
if(isPawn('P',i,j,chess)):
    print("black king in danger")
    exit()

#find king position
#white (bottom,cap)
i,j=findKing('K',chess)
#rook
if(isRook('r',i,j,chess)):
    print("white king in danger")
    exit()
#bishop
if(isBishop('b',i,j,chess)):
    print("white king in danger")
    exit()
#knight
if (isKnight('n',i,j,chess)):
    print("white king in danger")
    exit()
#pawn
if(isPawn('p',i,j,chess)):
    print("white king in danger")
    exit()

print("all is well")
    
