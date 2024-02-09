
// C program to show the
// implementation of Jagged Arrays
  
#include <stdio.h>
#include <stdlib.h>
  
int main()
{
    // 2 Rows
    int* jagged[2];
  
    // Allocate memory for elements in row 0
    jagged[0] = malloc(sizeof(int) * 1);
  
    // Allocate memory for elements in row 1
    jagged[1] = malloc(sizeof(int) * 3);
  
    // Array to hold the size of each row
    int Size[2] = { 1, 3 }, k = 0, number = 100;
  
    // User enters the numbers
    for (int i = 0; i < 2; i++) {
  
        int* p = jagged[i];
  
        for (int j = 0; j < Size[k]; j++) {
            *p = number++;
  
            // move the pointer
            p++;
        }
        k++;
    }
  
    k = 0;
  
    // Display elements in Jagged array
    for (int i = 0; i < 2; i++) {
  
        int* p = jagged[i];
        for (int j = 0; j < Size[k]; j++) {
  
            printf("%d ", *p);
            // move the pointer to the next element
            p++;
        }
        printf("\n");
        k++;
        // move the pointer to the next row
        jagged[i]++;
    }
  
    return 0;
}
