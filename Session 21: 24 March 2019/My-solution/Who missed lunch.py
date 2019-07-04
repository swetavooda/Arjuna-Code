no_of_students=int(input())
boxes=list(map(int,input().split()))#input of order of boxes on table.
preference=list(map(int,input().split()))#input of order of prefernces of students.

no_of_appends=0#condition to terminate loop.
'''logic:
    if the firt box is same as prefernce of first student in queue: we pop both out of queue.
    if not we pop student and append at the end of queue.and increase the append count.
    when to terminate?
        when the number of times queue is appended is equal to the no. of students that means the boxes dont match any of their prefernces,
        so we termianate if no_of_appends>=len(preference)
'''
while(no_of_appends<len(preference)):
    if boxes[0]==preference[0]:
        boxes.pop(0)
        preference.pop(0)
        no_of_appends=0
    else:
        q=preference.pop(0)
        preference.append(q)
        no_of_appends+=1
print(len(preference))
