import java.util.PriorityQueue;

public class PriorityQueueDemo {
    /*public static void main(String[] args) {
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        pq.add(10);
        pq.add(100);
        pq.add(2);
        pq.add(35);
        pq.add(2000);
        pq.add(5);
        while (!pq.isEmpty()){
            System.out.println(pq.peek());
            pq.poll();
        }
    }

     */
    static class Node {
        Node next;
        int data;
        int priority;
        public Node(int data, int priority)
        {
            this.data = data;
            this.priority = priority;
        }
    }

        Node front;
        Node rear;

        public PriorityQueueDemo() {
            front = null;
            rear = null;

        }
        public void enqueue(Node newnode) {
            if (front == null || newnode.priority < front.priority) {
                newnode.next = front;
                front = newnode;
            } else {
                Node temp = front;

                while (temp.next != null && temp.next.priority <= newnode.priority) {
                    temp = temp.next;
                }
                newnode.next = temp.next;
                temp.next = newnode;

            }
        }
        public void display()
        {
            Node temp = front;
            while(temp != null)
            {
                System.out.println(temp.data + " " + temp.priority);
                temp = temp.next;
            }
        }

    public static void main(String[] args) {
        Node n1= new Node(15,4);
        Node n2 = new Node(10,3);
        Node n3 = new Node(20,3);
        Node n4 = new Node(50,2);
        Node n5  = new Node(22,6);
        PriorityQueueDemo obj = new PriorityQueueDemo();
        obj.enqueue(n1);
        obj.enqueue(n2);
        obj.enqueue(n3);
        obj.enqueue(n4);
        obj.enqueue(n5);
        obj.display();


    }
}
