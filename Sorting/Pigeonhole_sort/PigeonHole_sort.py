def Pigeonhole_sort(a):
    minf = min(a)
    maxf = max(a)
    size = maxf - minf + 1
    Holes = [0] * size
    for x in a:
        assert type(x) is int, "integers only please"
        Holes[x - minf] += 1

    i = 0
    for count in range(size):
        while Holes[count] > 0:
            Holes[count] -= 1
            a[i] = count + minf
            i += 1
a = [8, 3, 2, 7, 4, 6, 8]
print("Sorted order is : ", end = ' ')
Pigeonhole_sort(a)        
for i in range(0, len(a)):
    print(a[i], end = ' ')
     
