#include <iostream>
using namespace std;
void heap(int arr[], int N, int i)
{
    int largest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;
    if (l < N && arr[l] > arr[largest])
        largest = l;
    if (r < N && arr[r] > arr[largest])
        largest = r;
    if (largest != i) {
        swap(arr[i], arr[largest]);
        heap(arr, N, largest);
    }
}
void HeapSort(int arr[], int N)
{
    for (int i = N / 2 - 1; i >= 0; i--)
        heap(arr, N, i);
    for (int i = N - 1; i > 0; i--) {
        swap(arr[0], arr[i]);
        heap(arr, i, 0);
    }
}
void print(int arr[], int N)
{
    for (int i = 0; i < N; ++i)
        cout << arr[i] << " ";
    cout << "\n";
}
int main()
{
    int arr[] = { 12, 11, 13, 5, 6, 7 };
    int N = sizeof(arr) / sizeof(arr[0]);
    HeapSort(arr, N);
    cout << "Sorted array is \n";
    print(arr, N);
}
