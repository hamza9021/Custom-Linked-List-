public class SinglyCustomLinkedList {


    private Node head;
    private Node tail;

    private int size;

    SinglyCustomLinkedList(){
        this.size = 0;
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        if(tail==null){
            tail = head;
        }
        size++;
    }

    public void insertLast(int val){
        if(tail == null){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;

    }

    public void insert(int val,int index){
        if(index==0){
            insertFirst(val);
            return;
        }
        if(index==size){
            insertLast(val);
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
                temp = temp.next;
        }

        Node node = new Node(val,temp.next);
        temp.next = node;
        size++;

    }


    public int delete(int index){
        Node temp = head;
        if(index==0){
            return deleteFirst();
        }
        if(index==size-1){
            return deleteLast();
        }
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        int val = temp.next.value;
        temp.next = temp.next.next;

        return val;
    }

    public int deleteFirst(){
        int val = head.value;
        head = head.next;
        if(head==null){
            tail=null;
        }
        size--;
        return val;
    }

    public int deleteLast(){
        Node temp = head;
        if(size<=1){
            return deleteFirst();
        }
        for (int i = 1; i < size-1; i++) {
            temp = temp.next;
        }
        tail = temp;
        tail.next = null;
        return tail.value;
    }


    public Node getNode(int val){
        Node temp = head;
        while(temp!=null) {
            if (temp.value == val) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.print("End");
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
