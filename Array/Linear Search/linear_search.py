# linear search
def search(arr, x):
 
    for i in range(len(arr)):
 
        if arr[i] == x:
            return i
 
    return -1

l = input("Enter the list of numbers: ").split()
print("The list of numbers is: ", search(
    l, input("Enter the number to search: ")))
