with open("censor.in") as read:
    S = read.readline().strip()
    T = read.readline().strip()
    while S.find(T) != -1:
        S = S.replace(T, '')

#print(S)
print(S, file=open("censor.out", "w"))