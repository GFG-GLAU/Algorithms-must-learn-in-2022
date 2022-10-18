
# Selection sort in Python
def selectionSort(array, size):
    for i in range(size):
        minpos = i
        for j in range(i+1, size):
            if array[j] < array[minpos]:
                minpos = j
        (array[i], array[minpos]) = (array[minpos], array[i])
arr=[]
n=int(input())
for i in range(0,n):
 element=int(input())
 arr.append(element)
size = len(arr)
selectionSort(arr, size)
print('array after sort:')
print(arr)
