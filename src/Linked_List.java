public class Linked_List {
    static int lengths;
    Node head;
    Node tail;

    public static void main(String[] args) {
        Linked_List linkedList = new Linked_List();
        append(linkedList,1);
        append(linkedList,2);
        append(linkedList,3);
        append(linkedList,4);
        printList(linkedList);
        System.out.println(lengths);
        remove(linkedList);
        printList(linkedList);
        System.out.println(lengths);
        insert(linkedList,1,8);
        printList(linkedList);
        System.out.println(lengths);

    }

    static class Node{
        int value;
        Node next;
        Node(int data){
            value=data;
            next = null;
        }
    }

    static void append(Linked_List linkedList, int data){
        Node newNode = new Node(data);
        newNode.next=null;

        if(linkedList.head==null){
            linkedList.head=newNode;
        }
        else{
            Node last = linkedList.head;
            while(last.next!=null){
                last=last.next;
            }
            last.next=newNode;

        }
        lengths++;
    }

    static void printList(Linked_List linkedList){
        Node start = linkedList.head;
        while(start!=null){
            System.out.print(start.value+" ");
            start=start.next;
        }
        System.out.println();
    }

    static void remove(Linked_List linkedList){
        Node temp = linkedList.head;
        Node prev = linkedList.head;
        while(temp.next!=null){
            prev=temp;
            temp=temp.next;
        }
        linkedList.tail=prev;
        prev.next=null;
        lengths--;
    }

    static void insert(Linked_List linkedList,int position,int value){
        Node head = linkedList.head;
        Node temp = linkedList.head;
        Node newNode = new Node(value);
        if(position==1){
            linkedList.head=newNode;
            newNode.next=head;
        }
        else{
            while(position>1){
                temp=temp.next;
                position--;
            }
            Node next = temp.next;
            temp.next=newNode;
            newNode.next=next;
        }
        lengths++;
    }
}
