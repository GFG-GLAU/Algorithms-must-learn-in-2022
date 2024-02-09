public class CircularQueue { 
    static class Queue{ 
        static int size; 
        static int[] arr; 
        static int rear=-1; 
        static int front=-1; 
 
        Queue(int size){ 
            this.size=size; 
            arr= new int[size]; 
        } 
 
        public boolean isEmpty(){ 
            return (rear==-1) && (front==-1); 
        } 
        public boolean isFull(){ 
            return (rear+1)%size==front; 
        } 
 
        public void add(int data){ 
            if(isFull()){ 
                System.out.println("Queue is full"); 
                return; 
            } 
            if(front==-1){ 
                front=0; 
            } 
            rear=(rear+1)%size; 
            arr[rear]=data; 
        } 
 
        public int delete(){ 
            if(isEmpty()) { 
                System.out.println("Queue is Empty"); 
                return -1 ; 
            } 
            int res=arr[front]; 
            if(rear==front){ 
                rear=front=-1;   //only one element is present 
            } 
            else{ 
                front=(front+1)%size; 
            } 
            return res; 
        } 
 
        public int peek(){ 
            if(isEmpty()) { 
                System.out.println("Queue is Empty"); 
                return -1 ; 
            } 
            return arr[front]; 
        } 
    } 
 
    public static void main(String[] args) { 
        Queue obj = new Queue(6); 
        obj.add(10); 
        obj.add(20); 
        obj.add(40); 
        obj.add(50); 
        obj.add(30); 
        /* 
        System.out.print(obj.delete()+" | "); 
        obj.add(100); 
        System.out.print(obj.delete()+" | "); 
        obj.add(45);*/ 
        while(!obj.isEmpty()){ 
            System.out.print(obj.peek()+" | "); 
            obj.delete(); 
        } 
    } 
 
}
