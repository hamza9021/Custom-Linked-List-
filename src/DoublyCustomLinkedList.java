public class DoublyCustomLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public DoublyCustomLinkedList() {
        this.size = 0;
    }

    void insertFirst(int val){
        Node temp = new Node(val);
        temp.next = head;
        temp.pre = null;
        if(head != null){
            head.pre = temp;
        }
        head = temp;
        size++;
    }

    void insertLast(int val){

        if(head == null){
            insertFirst(val);
        }

        Node node = new Node(val);
        Node temp = head;


        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;

        size++;
    }

    void insert(int val,int index){

        if(head==null){
            insertFirst(val);
            return;
        }

        Node node = new Node(val);
        Node temp = head;

        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        if(temp.next==null){
            temp.next = node;
            node.pre  = temp;
            node.next = null;
            return;
        }
        node.next = temp.next;
        temp.next.pre = node;
        temp.next = node;
        node.pre = temp;
    }

    void displayForward(){
        Node temp = head;
        System.out.print("Start -> ");
        while(temp!=null) {
            System.out.print(temp.value + " -> <- ");
            temp = temp.next;
        }
        System.out.print(" End");
    }

    void displayReverse(){
        Node temp = head;
        Node last=null;
        while(temp!=null) {
            last = temp;
            temp = temp.next;
        }
        System.out.print("Start -> ");
        while(last!=null) {
            System.out.print(last.value + " -> <- ");
            last = last.pre;
        }
        System.out.print(" End");

    }







    private class Node{
        int value;
        Node next;
        Node pre;

        Node(int value){
            this.value = value;
        }

        public Node(Node next, int value, Node pre) {
            this.next = next;
            this.value = value;
            this.pre = pre;
        }



    }
}
