#include <stdio.h>
  
int main()
{
    int var = 789;
  
    // pointer for var
    int* ptr2;
  
    // double pointer for ptr2
    int** ptr1;
  
    // storing address of var in ptr2
    ptr2 = &var;
  
    // Storing address of ptr2 in ptr1
    ptr1 = &ptr2;
  
    // Displaying value of var using
    // both single and double pointers
    printf("Value of var = %d\n", var);
    printf("Value of var using single pointer = %d\n", *ptr2);
    printf("Value of var using double pointer = %d\n", **ptr1);
  
    return 0;
}
