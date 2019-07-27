planets=list(map(int,input().split()))#contains list of planets in each galaxy.
time=int(input())#the time for which guardians are out.
#speed at which death hole must consume planets,initially taken as min number of planets in a galaxy
speed=len(planets)-1

check_hours=max(planets)
'''logic:
    starting from min spped we are going to check the time for each of speed
    if it is greater than or equal to time exit loop'''
while(check_hours>time):
    speed+=1
    check_hours=0
    for i in planets:
        if i<=speed:
            check_hours+=1#if less  that spped planets only one hour.
        else:
            check_hours+=((i//speed)+1)# if there are more planets.
print(speed)
