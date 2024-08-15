public class CircularCustomLinkedList {


    Node head;
    Node tail;

    void insertFirst(int val){
        Node node = new Node(val);

        if(head==null){
            head = node;
            tail = node;
            return;
        }

        tail.next = node;
        node.next = head;
        tail = node;


    }


    void display(){
        Node temp = head;

       if(head !=  null){
           do {
               System.out.print(temp.value + " -> ");
               temp = temp.next;
           }
           while(temp != head);
       }
    }




        class Node{
            int value;
            Node next;

            public Node(int value) {
                this.value = value;
            }

            public Node(int value, Node next) {
                this.value = value;
                this.next = next;
            }
        }
}
