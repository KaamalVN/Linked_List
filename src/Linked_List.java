import java.util.Scanner;

public class Linked_List {
    static Scanner scanner=new Scanner(System.in);
    static int lengths;
    Node head;
    Node tail;

    public static void main(String[] args) {
        Linked_List linkedList = new Linked_List();
        boolean exiter=true;
        int option;
        int data;
        int index;
        do {
            System.out.print("Choices \n1 to Append \n2 to Prepend \n3 to Insert at Index \n4 to Remove Last \n5 to Remove First \n6 to Remove from Index \n7 to Get element from Index \n8 to Set element in an Index \n9 to print \n10 to exit \nEnter Choice: ");
            option = scanner.nextInt();
            switch(option){
                case 1:
                    System.out.print("Enter data to append: ");
                    data=scanner.nextInt();
                    append(linkedList,data);
                    System.out.println("Data Appended");
                    break;
                case 2:
                    System.out.print("Enter data to prepend: ");
                    data = scanner.nextInt();
                    prepend(linkedList,data);
                    System.out.println("Data Prepended");
                    break;
                case 3:
                    System.out.print("Enter data to Insert : ");
                    data= scanner.nextInt();
                    System.out.print("Enter position to Insert : ");
                    index = scanner.nextInt();
                    insert(linkedList,index,data);
                    System.out.println("Element Inserted Successfully");
                    break;
                case 4:
                    removeLast(linkedList);
                    break;
                case 5:
                    removeFirst(linkedList);
                    break;
                case 6:
                    System.out.print("Enter Index to remove element from : ");
                    index= scanner.nextInt();
                    removeIndex(linkedList,index);
                    break;
                case 7:
                    System.out.print("Enter position to Insert : ");
                    index = scanner.nextInt();
                    Node element=getNode(linkedList,index);
                    System.out.println("Element at index "+index+" : "+element.value);
                    break;
                case 8:
                    System.out.print("Enter data to Set : ");
                    data= scanner.nextInt();
                    System.out.print("Enter position to Set : ");
                    index = scanner.nextInt();
                    setNode(linkedList,index,data);
                    break;
                case 9:
                    printList(linkedList);
                    System.out.println("Length of Linked List is : "+lengths);;
                    break;
                case 10:
                    System.out.println("Exiting...");
                    exiter=false;
            }
        }
        while(exiter);
    }



    static class Node{
        int value;
        Node next;
        Node(int data){
            value=data;
            next = null;
        }
    }

    static void append(Linked_List linkedList,int data){

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

    static void prepend(Linked_List linkedList,int data) {

        Node newNode = new Node(data);
        newNode.next=null;

        if(linkedList.head==null){
            linkedList.head=newNode;
        }
        else{
            newNode.next=linkedList.head;
            linkedList.head=newNode;
        }
        lengths++;

    }

    static void insert(Linked_List linkedList,int position,int value){

        if(position<0 || position>lengths){
            System.out.println("Invalid Position");
        }
        else if(position==0){
            prepend(linkedList,value);
        }
        else if(position==lengths){
            append(linkedList,value);
        }
        else{
            Node temp = getNode(linkedList,position-1);
            Node newNode = new Node(value);
            newNode.next=temp.next;
            temp.next=newNode;
            lengths++;
        }

    }
    static void removeLast(Linked_List linkedList){
        if(lengths==0){
            System.out.println("Linked list is empty");
        }
        Node temp = linkedList.head;
        Node prev = linkedList.head;
        while(temp.next!=null){
            prev=temp;
            temp=temp.next;
        }
        linkedList.tail=prev;
        prev.next=null;
        lengths--;
        System.out.println("Last element removed : "+temp.value);
    }


    static void removeFirst(Linked_List linkedList) {
        if(lengths==0){
            System.out.println("Linked list is empty");
        }
        else{
            Node temp=linkedList.head;
            linkedList.head=temp.next;
            temp.next=null;
            lengths--;
            if(lengths==0){
                linkedList.tail=null;
            }
            System.out.println("First element removed : "+temp.value);
        }
    }

    static void removeIndex(Linked_List linkedList, int index) {
        if(index<0 || index>lengths){
            System.out.println("Invalid Position");
        }
        if(index==0){
            removeFirst(linkedList);
        }
        if(index==lengths){
            removeLast(linkedList);
        }
        else{
            Node temp = getNode(linkedList,index-1);
            Node prev=temp.next;
            temp.next=prev.next;
            prev.next=null;
            lengths--;
            System.out.println("Element at index "+index+" removed : "+temp.value);
        }

    }
    static Node getNode(Linked_List linkedList,int index){
        if(index<0 || index>lengths){
            return null;
        }
        Node temp=linkedList.head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp;
    }
    static void setNode(Linked_List linkedList,int index,int data){
        Node temp=getNode(linkedList,index);
        if(temp!=null){
            temp.value=data;
            System.out.println("Element Set Successfull");
        }
        else{
            System.out.println("Element Set Unsuccessfull");
        }
    }
    static void printList(Linked_List linkedList){
        if(lengths==0){
            System.out.println("No elements in linked list");
        }
        else{
            Node start = linkedList.head;
            System.out.println("Elements in linked list are : ");
            while(start!=null){
                System.out.print(start.value+" ");
                start=start.next;
            }
            System.out.println();
        }

    }




}
