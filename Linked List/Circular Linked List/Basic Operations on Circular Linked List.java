public class CircularSinglyLL {
    Node head;
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;

        }

    }


    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null) {  //list is empty
            head = newNode;
            newNode.next = head;
            return;
        }
        Node temp=head;
        while(temp.next!=head){
            temp=temp.next;
        }
        temp.next=newNode;
        newNode.next=head;
        head=newNode;
    }
    // insert at the end


    public void insertALast(int data){
        Node newnode=new Node(data);
        Node temp=head;
            while(temp.next!=head){
                temp=temp.next;
            }
            temp.next=newnode;
            newnode.next=head;
    }

    public void insertAtAny(Node newnode , int pos){
        if(head==null){
            head=newnode;
            newnode.next=head;
            return;
        }
        Node temp=head;
        for(int i=0;i<pos-2;i++){
            temp=temp.next;
        }
        newnode.next=temp.next;
        temp.next=newnode;
    }

    public void deleteFirst(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        Node temp=head;
        while(temp.next!=head){
            temp=temp.next;
        }
        head=head.next;
        temp.next=head;

    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {    //only one element is present
            head = null;
            return;
        }
        Node temp=head;
        while(temp.next.next!=head){
            temp=temp.next;
        }
        temp.next=head;
    }

    public void deleteElement(Node head, int pos){
        if(pos==1){
            deleteFirst();
            return;
        }
        Node temp=head;
        for(int i=0;i<pos-2;i++){
            temp=temp.next;
        }
        Node next =temp.next.next;
        temp.next=next;
    }

    public void display(){
        if(head==null){
            System.out.println("list is empty");
        }
        else{
            Node temp = head;
            while(temp.next!= head){
                System.out.print(temp.data+" -> ");
                temp=temp.next;
            }
            System.out.print(temp.data);
            System.out.println();
        }
    }


    public static void main(String[] args) {
        CircularSinglyLL obj = new CircularSinglyLL();
        obj.addFirst(45);
        obj.addFirst(23);
        obj.addFirst(22);
        obj.addFirst(58);
        obj.addFirst(60);
        obj.display();
        obj.insertALast(100);
        obj.display();
        obj.insertAtAny(new Node(400), 2);
        obj.display();
        obj.deleteFirst();
        obj.display();
        obj.deleteLast();
        obj.display();
        obj.deleteElement(obj.head,2);
        obj.display();
    }
}
