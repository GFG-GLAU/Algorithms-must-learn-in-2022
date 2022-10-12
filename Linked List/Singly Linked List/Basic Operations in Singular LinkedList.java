class LinkedL {
    Node head;

    static class Node{
        String data;
        Node next;

        public Node(String data){
            this.data=data;
            this.next=null;

        }
    }


    //Method to add element in first
    public void addFirst(String data){
        Node newNode = new Node(data);
        if(head == null){  //list is empty
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;

    }

    //Method to add element in last
    public void addLast(String data){
        Node newNode = new Node(data);
        if(head == null){    //list is empty
            head = newNode;
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp=temp.next;
        }
        temp.next = newNode;

    }

    //Method to insert element a given position
    public void insertElement(int pos,Node newnode){

        Node temp = head;
        for(int i=0;i<pos-2;i++) {
            temp = temp.next;
        }
            newnode.next=temp.next;
            temp.next=newnode;
    }


    //Method to delete first element
    public void deleteFirst(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        head=head.next;

    }


    //Method to delete element from last
    public void deleteLast(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        if(head.next==null){    //only one element is present
            head =null;
            return ;
        }

        Node secondLast = head;
        Node last  =head.next;
        while(last.next!=null){
            last = last.next;
            secondLast=secondLast.next;
        }
        secondLast.next=null;

    }
    
    
    //Method to delete node from any given position
    public void deleteElement(Node head,int pos){
        if(pos==1){
            head=head.next;
        }
        Node temp=head;
        for(int i=0;i<pos-2;i++){
            temp=temp.next;
        }
        Node next =temp.next.next;
        temp.next=next;
    }
    
    //Method to print the updated list
    public void printlist(){
        if(head == null){
            System.out.println("List is empty");
            return ;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp=temp.next;
        }
        System.out.println("Null");
    }

    public static void main(String[] args) {
        LinkedL list = new LinkedL();
        list.addFirst("a");
        list.addFirst("is");
        list.addFirst("this");
        list.addLast("list");
        list.addLast("used in");
        list.addLast("java");
        list.printlist();
        list.insertElement(4,new Node("Linked"));
        list.printlist();
        list.deleteFirst();
        list.printlist();
        list.deleteLast();
        list.printlist();
        list.deleteElement(list.head, 3);
        list.printlist();
    }
}
