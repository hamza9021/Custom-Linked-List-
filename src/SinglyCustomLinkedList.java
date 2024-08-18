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
        if(index==size-1){
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

    public void insertRecursion(int val,int index){
        head = insertRecursion(val,index,head);
    }
    private Node insertRecursion(int val,int index,Node node){
        if(index == 0 ){
            Node temp = new Node(val,node);
            size++;
            return temp;
        }
        index = index - 1;
        node.next = insertRecursion(val, index ,node.next);

        return node;
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


    public Node getNode(int index){
        if(index==0){
            return head;
        }
        if(index == size-1){
            return tail;
        }
       Node temp = head.next;
       while(index > 1){
           temp = temp.next;
           index--;
       }
       return temp;
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


//    Duplicats

    public void duplicates(){
        Node node = head;
        while(node.next != null){
            if(node.value == node.next.value){
                node.next = node.next.next;
                size--;
            }
            else {
                node = node.next;
            }
        }
        tail = node;
        tail.next= null;
    }

    public void bubbleSort(int row, int col) {
        if (row == 0) {
            return;
        }

        if (col < row) {
            Node first = getNode(col);
            Node second = getNode(col + 1);

            if (first.value > second.value) {
                // Swap nodes
                if (first == head) {
                    first.next = second.next;
                    second.next = first;
                    head = second;
                } else if (second == tail) {
                    Node pre = getNode(col - 1);
                    pre.next = second;
                    tail = first;
                    first.next = null;
                    second.next = first;
                } else {
                    Node pre = getNode(col - 1);
                    pre.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            bubbleSort(row, col + 1);
        } else {
            bubbleSort(row - 1, 0);
        }
    }


    



}
