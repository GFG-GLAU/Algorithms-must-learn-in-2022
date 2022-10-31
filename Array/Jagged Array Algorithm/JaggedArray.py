# at first we will create an array of c columns and r rows
c = 4
r = 3
arr = [[0] * c for i in range(r)]
# loop will run for the length of the outer list
for i in range(r):
# loop will run for the length of the inner lists
    for j in range(c):
        if i < j: arr[i][j] = 8 elif i > j:
            arr[i][j] = 4
        else:
            arr[i][j] = 7
for r in arr:
    print( ' '.join([str(x) for x in r] ) )
