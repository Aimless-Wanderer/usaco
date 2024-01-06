with open("triangles.in") as read:
    num_points = int(read.readline())
    points = []
    for _ in range(num_points):
        x, y = [int(j) for j in read.readline().split()]
        point = (x, y)
        points.append(point)

max_area = 0;
for i in range(num_points):
    for j in range(num_points):
        if i != j:
            if points[i][0] == points[j][0]:
                for k in range(num_points):
                    if k != i and k != j and points[i][1] == points[k][1]:
                        area = (abs(points[i][1]-points[j][1])*abs(points[i][0]-points[k][0]))/2
                        max_area = max(max_area, area)
            

print(int(max_area*2), file=open("triangles.out", "w"))