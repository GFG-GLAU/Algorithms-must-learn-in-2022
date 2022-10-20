public class QueueByLL { 
    static class Node { 
        int data; 
        Node next; 
        Node(int data) { 
            this.data = data; 
            next = null; 
        } 
    } 
 
    static class Queue { 
        static Node head; 
        static Node tail; 
        public static boolean isEmpty() { 
            return (head == null) && (tail == null); 
        } 
 
        public static void add(int data) { 
            Node newnode = new Node(data); 
            if (tail == null) {           //ll is empty 
                tail = head = newnode; 
            } 
            tail.next = newnode; 
            tail = newnode; 
        } 
 
        public static int delete() { 
            if (isEmpty()) { 
                System.out.println("Empty list"); 
                return -1; 
            } 
            int front = head.data; 
            if (head == tail) { 
                tail = null; 
            } 
            head = head.next; 
            return front; 
        } 
 
        public static int peek() { 
            if (isEmpty()) { 
                System.out.println("Empty list"); 
                return -1; 
            } 
            return head.data; 
        } 
    } 
 
 
    public static void main(String[] args) { 
        Queue obj = new Queue(); 
 
        //Queue<Integer> q= new LinkedList<>(); 
        //Queue <Integer> q=new ArrayDeque<>(); 
 
        obj.add(50); 
        obj.add(33); 
        obj.add(78); 
        while(!obj.isEmpty()){ 
            System.out.print(obj.peek()+" | "); 
            obj.delete(); 
        } 
 
    } 
}
