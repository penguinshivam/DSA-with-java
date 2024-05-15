// import java.util.*;
// public class fromback {
//     public static void main(String[] args) {
//         LinkedList<Integer> ll =new LinkedList<>();
//         ll.addFirst(1);
//         ll.addFirst(2);
//         ll.addFirst(3);
//         ll.addFirst(4);
//         ll.addFirst(5);
//         ll.addFirst(6);
//         ll.addFirst(7);
//         System.out.println(ll);
//         int m =3;
//         // for (int i = 0; i < ll.size()-m; i++) {
//             ll.add((ll.size()+1)-m, 10);
//         // }
//         System.out.println(ll);
//     }
// }
// import java.util.*;
public class fromback{
    public static class node {
        int data;
        node next;
        public node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static node head;
    public static node tail;
    public static int size;

    public void addfirst(int data){    //o(1)
        // step 1 create a new node
        node newnode=new node(data);
        size++;
       if(head==null){
           head=tail=newnode;
           return;
       }
      
       // new node next => head
       newnode.next=head;
       // head=>newnode
       head=newnode;
    }
    public void printlinklist(){
        if (head==null) {
            System.out.println("ll is empty");
        }
        node temp =head;
        while (temp!=null) {
            System.out.print(temp.data+"==>");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public void addmfromlast(int index,int data){
            node newnode=new node(data);
            size++;
            node temp=head;
            // if (head==null) {
            //     head=tail=newnode;
            //     return;
            // }
            int count =0;
        
        while (count<size-1-index) {
            
            temp=temp.next;
            count++;
        }
        newnode.next=temp.next;
        temp.next=newnode;
        
    }
    public static void main(String[] args) {
        fromback l1=new fromback();
        l1.addfirst(1);
        l1.addfirst(2);
        l1.addfirst(3);
        l1.addfirst(1);
        l1.printlinklist();
        System.out.println(size);
        int m=3;
        l1.addmfromlast(m,10);
        l1.printlinklist();

    }
}