package instigate.myLinkedList;

import java.util.LinkedList;

public class MainLinkedList {
    public static void main(String[] args) {
        MyLinkedList linkedList =new MyLinkedList();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");
        linkedList.add("e");
        linkedList.add("f");

     while (linkedList.cuurent != null){
         System.out.println(linkedList.cuurent.elem);
         linkedList.cuurent = linkedList.cuurent.prev;
     }
        System.out.println("-------------------------");
        System.out.println("size: " + linkedList.size);
        while (linkedList.cuurent != null){
            System.out.println(linkedList.cuurent.elem);
            linkedList.cuurent = linkedList.cuurent.next;
        }

    }
}
