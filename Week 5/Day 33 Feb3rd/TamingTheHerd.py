#with open("taming.in") as read:
    # totalDays = int(read.readline())
    # breakout_log = []
    # for _ in range (totalDays):
    #     breakout_log.append(int(read.readline()))
breakout_log = [-1, 1, -1, 1, 2, -1, -1, 5, -1]    
breakout_log[0] = 0

for i in range (len(breakout_log)):
    days = breakout_log[i]
    if days != -1 & days != 0:
        count = 0
        for j in range(i, i-days-1, -1):
            count+= 1
            print(days-count, end = '\n')
            breakout_log[j] = days-count
            print(breakout_log[j], end = '\n')
            
            
min = max = 0  
def printlog():
    for i in range (len(breakout_log)):
        print(breakout_log[i], end=" ")
printlog()
#print(min + " " + max, file=open("taming.out", "w"))