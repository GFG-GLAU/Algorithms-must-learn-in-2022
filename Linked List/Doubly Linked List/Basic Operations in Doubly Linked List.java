public class DoublyLL {
    Node head;
    static class Node{
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
    }
    public void insertAtFirst(int data) {
        Node newnode = new Node(data);
        if (head == null) {
            head = newnode;
            newnode.prev = null;
        } else {
            newnode.next = head;
            head.prev = newnode;
            head= newnode;
        }
    }
    public void insertatLast(int data){
        Node newnode = new Node(data);
        if(head==null){
            head = newnode;
        }
        else{
            Node temp = head;
            while(temp.next!=null) {
                temp = temp.next;
            }
            temp.next=newnode;
            newnode.prev=temp;
            newnode.next=null;
        }

    }

    public void insertAtAny(Node newnode,int pos){
        Node temp= head;
        for(int i=0;i<pos-2;i++){
            temp=temp.next;
        }
        newnode.next =temp.next;
        newnode.prev=temp;
        temp.next=newnode;

    }

    public void display(){
        Node temp =head;
        if(head==null){
            System.out.println("empty");
            return;
        }
        while(temp!= null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
        }

    public void deleteAtFirst() {
        if (head == null) {
            System.out.println("empty list");
        }
        if (head.next == null) {
            head = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    public void deleteAtLast(){
        if(head==null){
            System.out.println("emptyList");
        }
        if(head.next==null){
            head=null;
        }
        Node temp=head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next=null;

    }


    public void deleteNode(Node head,int pos){
        if(head==null){
            System.out.println("empty list");
            return ;
        }
        if(pos==1){
            head=head.next;
            head.prev=null;
            return;
        }
        Node temp=head;
        for(int i=0;i<pos-2;i++){
            temp=temp.next;
        }
        Node next=temp.next.next;
        next.prev=temp;
        temp.next=next;
    }
    
     public void reverse(){
        if(head==null){
            System.out.println("Empty list");
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        while(temp.prev!=null){
            System.out.print(temp.data+" -> ");
            temp=temp.prev;
        }
        System.out.print(temp.data);

    }

    public static void main(String[] args) {
        DoublyLL obj = new DoublyLL();
        obj.insertAtFirst(4);
        obj.display();
        obj.insertAtFirst(60);
        obj.insertAtFirst(75);
        obj.insertAtFirst(5);
        obj.insertAtFirst(23);
        obj.display();
        obj.insertatLast(45);
        obj.display();
        obj.deleteAtFirst();
        obj.display();
        obj.deleteAtLast();
        obj.display();
        obj.deleteNode(obj.head,2);
        obj.display();
        obj.insertAtAny(new Node(333),3);
        obj.display();
        obj.insertatLast(33);
        obj.display();
        obj.reverse();
    }
}
