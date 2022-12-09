#include <iostream>
using namespace std;
 
class Stack{
private:
    int size;
    int top;
    int* S;
public:
    Stack(int size);
    ~Stack();
    void push(int x);
    int pop();
    int isFull();
    int isEmpty();
    void display();
    int stackTop();
};
 
Stack::Stack(int size) {
    this->size = size;
    top = -1;
    S = new int[size];
}
 
Stack::~Stack() {
    delete[] S;
}
 
void Stack::push(int x) {
    if (isFull()){
        cout << "Stack Overflow!" << endl;
    } else {
        top++;
        S[top] = x;
    }
}
 
int Stack::pop() {
    int x = 1;
    if (isEmpty()){
        cout << "Stack Underflow!" << endl;
    } else {
        x = S[top];
        top--;
    }
    return x;
}
 
int Stack::isFull() {
    if (top == size-1){
        return 1;
    }
    return 0;
}
 
int Stack::isEmpty() {
    if (top == -1){
        return 1;
    }
    return 0;
}
 
void Stack::display() {
    for (int i=top; i>=0; i--){
        cout << S[i]<<" " << flush;
    }
    cout << endl;
}
 
int Stack::stackTop() {
    if (isEmpty()){
        return -1;
    }
    return S[top];
}
 
 
int main() {
 
    int A[] = {1, 2, 3, 4, 5};
 
    //finding the size..
    Stack stk(sizeof(A)/sizeof(A[0]));
 
    // inserting elements in stack
    for (int i=0; i<sizeof(A)/sizeof(A[0]); i++){
        stk.push(A[i]);
    }
    stk.push(11);
 
    cout << "Stack full: " << stk.isFull() << endl;
 
    // display stack;
    cout << "Stack: " << flush;
    stk.display();
 
 
    // Top element
    cout << "Top element: " << stk.stackTop() << endl;
 
    // Pop out all elements from stack
    cout << "Popped out elements: " << flush;
    for (int i=0; i<sizeof(A)/sizeof(A[0]); i++){
        cout << stk.pop() << ", " << flush;
    }
    cout << endl;
    
    stk.pop();
 
    cout << "Stack empty: " << stk.isEmpty() << endl;
    return 0;
}
