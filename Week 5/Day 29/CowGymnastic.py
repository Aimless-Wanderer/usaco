with open("gymnastics.in") as read:
	num_sessions, num_cows = [int(i) for i in read.readline().split()]
	sessions = []
	for i in range(num_sessions):
		sesh = [int(j) for j in read.readline().split()]
		sessions.append(sesh)
  
consistent_pairs = 0

for i in range (1, num_cows+1):
    for j in range(1, num_cows+1):
        greater = True
        if i != j:
            for k in range(len(sessions)):
                if sessions[k].index(i) > sessions[k].index(j):
                    greater = False
            if greater:
                consistent_pairs+=1
            
print(int(consistent_pairs), file=open("gymnastics.out", "w"))