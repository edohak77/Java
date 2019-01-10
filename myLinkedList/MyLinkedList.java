package instigate.myLinkedList;

public class MyLinkedList {
    int size;
     private Node first;
     private Node last ;
     Node cuurent;

    public MyLinkedList() {
        size = 0;
        first = null;
        last = null;
        cuurent = null;
    }

    public void add(String elem){
        if (first == null){
            first = new Node(elem,cuurent,null);
            cuurent = new Node(elem,null,null);
            last = new Node(elem,null,cuurent);
            size++;
        }else {

            Node newNode =new Node(elem,last,cuurent);
            cuurent = new Node(elem,last,newNode);
            last.prev = cuurent;
            last.elem = elem;
            first.next = cuurent.prev;
            size++;

        }

//        cuurentToNull();
    }

    public String get(int index){
        String out = "";
        while (index >= 0){
            out = cuurent.elem;
            index--;
            cuurent = cuurent.prev;
        }
        return  out;
    }
    void cuurentToNull(){
        while (cuurent != null){
//            System.out.println(linkedList.cuurent.elem);
            cuurent = cuurent.prev;
        }
    }

    public class Node{
        String elem;
        Node next;
        Node prev;
//        int index;

        public Node(String elem, Node next, Node prev) {
            this.elem = elem;
            this.next = next;
            this.prev = prev;
//            this.index = index;
        }

    }
}
