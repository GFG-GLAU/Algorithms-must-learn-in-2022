public class PriorityQueuebyArray {
    static class Queue{
        int size;
        Element[] arr;
        int front;
        int rear;

        Queue(int size){
            this.size=size;
            arr=new Element[size];
            front=rear=-1;
        }
        public boolean isEmpty(){
            return rear==-1;
        }

        public boolean isFull(){
            return rear==size-1;
        }
        public void insert(int data,int priority) {
            Element obj = new Element(data, priority);
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            if (isEmpty()) {
                front =0;
                rear++;
                arr[rear]= obj;
            }
            else{
                int i;
                for( i = rear;i>=front;i--){
                    if (obj.priority < arr[i].priority) {
                        arr[i + 1] = arr[i];
                    }
                    else {
                        break;
                    }
                }
                arr[i+1]=obj;
                rear++;
            }
        }

        public void dequeue()
        {
            if (isEmpty()){
                System.out.println("queue underflow");
            }
            else
                System.out.println(arr[front].data + " " + arr[front].priority);

            front++;
            if(front>rear)
            {
                front = rear =-1;
            }
        }


        public void display(){
            for(int i =0;i<size;i++){
                System.out.println(arr[i].data+" "+arr[i].priority);
            }
        }
    }
    static class Element{
        int data;
        int priority;
        Element(int data,int priority){
            this.data=data;
            this.priority=priority;
        }
    }

    public static void main(String[] args) {
        Queue obj = new Queue(5);
        obj.insert(100,1);
        obj.insert(90,3);
        obj.insert(80,4);
        obj.insert(75,10);
        obj.insert(15,2);
        obj.display();
        obj.dequeue();
    }
}
