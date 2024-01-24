with open("lifeguards.in") as read:
    num_guards = int(read.readline())
    shifts = []
    for _ in range(num_guards):
        initial, final = [int(j) for j in read.readline().split()]
        shift = (initial, final)
        shifts.append(shift)

# num_guards = 3
# shifts = [(5,9),(1,4),(3,7)]       
max_time = 0;
for i in range(num_guards):
    time = [0]*1001
    total_time = 0
    for j in range(num_guards):
        if j != i:
            for k in range(shifts[j][0], shifts[j][1]):
                time[k] = 1
    for j in range(1000):
        if time[j] == 1:
            total_time += 1
    max_time = max(max_time, total_time)
    
# print(max_time)
print(int(max_time), file=open("lifeguards.out", "w"))