package org.ankur.ds;

public class LinkedList {
    Node head;

    static class Node{
        Object data;
        Node next;
        Node(Object d) {
            data = d;
            next = null;
        }
    }
    public static LinkedList insert(LinkedList list,Object data){
        Node new_node = new Node(data);

        if(list.head == null){
            list.head = new_node;
        }else {
            Node last = list.head;
            while (last.next!=null){
                last=last.next;
            }
            last.next=new_node;
        }
        return list;
    }
    public static void printList(LinkedList list){
        Node currNode = list.head;
        System.out.println("Linked List : ");
        while (currNode!=null){
            System.out.print(currNode.data);
            if (currNode.next!=null)
                System.out.print(" --> ");
            currNode=currNode.next;
        }
        System.out.println();
    }

    public static LinkedList deleteByValue(LinkedList lst , Object value){
        Node currNode = lst.head,prev=null;
        if (currNode.data.equals(value)){
            lst.head=currNode.next;
            System.out.println(value +" Deleted from Linked List");
            return lst;
        }
        while (currNode!=null && !currNode.data.equals(value)){
            prev = currNode;
            currNode = currNode.next;
        }
        if (currNode!=null){
            prev.next=currNode.next;
            System.out.println(value +" Deleted from Linked List");
        }
        if (currNode==null){
            System.out.println(value+" Not Found");
        }
        return lst;
    }

    public static LinkedList deleteByIndex(LinkedList lst , int index){
        Node currNode = lst.head,prev=null;
        if(index==0 && currNode != null){
            lst.head=currNode.next;
            System.out.println("Index "+index +" Deleted from Linked List");
            return lst;
        }
        int count=0;
        while (currNode!=null){
            if (count == index){
                prev.next=currNode.next;
                System.out.println("Index "+index +" Deleted from Linked List");
                break;
            }else {
                prev = currNode;
                currNode = currNode.next;
                count++;
            }
        }
        if (currNode==null)
            System.out.println("index "+index+" not found");
        return lst;
    }

    public static void main(String[] args) {
        LinkedList lst = new LinkedList();
        lst = insert(lst,9);
        lst = insert(lst,8);
        lst = insert(lst,7);
        lst = insert(lst,6);
        lst = insert(lst,5);
        lst = insert(lst,4);
        lst = insert(lst,3);
        lst = insert(lst,2);
        lst = insert(lst,1);
        lst = insert(lst,0);
        lst = insert(lst,"A");
        lst = insert(lst,"N");
        lst = insert(lst,"K");
        lst = insert(lst,"U");
        lst = insert(lst,"R");


        printList(lst);
        deleteByIndex(lst,0);
        printList(lst);
        deleteByValue(lst,7);
        printList(lst);
        deleteByValue(lst,9);
        printList(lst);
        deleteByValue(lst,99);
        deleteByIndex(lst,1);
        printList(lst);
        deleteByValue(lst,"K");
        printList(lst);
    }
}
