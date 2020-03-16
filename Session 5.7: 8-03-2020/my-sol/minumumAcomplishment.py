a=list(map(int,input().split()))
n=int(input())
if len(a) < n:
    print(-1) #too many days
else:
    dictionary = {} # this will contain the current day and the job that was last finished
    for i,job in enumerate(a):
        # the best case scenario where all jobs need to be finished in one day 
        dictionary[0, i] = max(dictionary.get((0, i-1), 0), job)
    
            
    for i in range(1, n):
        for j in range(i, len(a)):
            mx = a[j]
            for k in range(j, i-1, -1):
                mx = max(mx, a[k])
                dictionary[i, j] = min(dictionary.get((i, j), float('inf')), mx + dictionary[i-1, k-1])
       
    print (dictionary[n-1, len(a)-1])
