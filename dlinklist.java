class doublylinklist {
    public static class node {
        int data;
        node next;
        node prev;
        public node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
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
        head.prev=newnode;
        // head=>newnode
        head=newnode;

    }
    public void addlast(int data){
        node newnode= new node(data);
        size++;
        if(head==null){
            head=tail=newnode;
            return;
        }
        tail.next=newnode;
        newnode.prev=tail;
        tail=newnode;

    }

    public void removefirst(){
        int val;
        if (head==null) {
            return;
        }
        
        else if(size==1){
            val=head.data;
            head=tail=null;
            return; 
        }
        val=head.data;
        System.out.println("removed data is "+val);
        head=head.next;
        head.prev=null;
        size--;
    }
    public void removelast(){
        int val;
        if (head==null) {
            return;
        }
        
        else if(size==1){
            val=head.data;
            head=tail=null;
            return; 
        }
        val=tail.data;
        System.out.println("removed data is "+val);
        
        tail=tail.prev;
        tail.next=null;
        size--;
    }
    public void reverse(){
        node previous=null;
        node current=tail=head;
        while (current!=null) {
        node next=current.next;
        current.next=previous;
        current.prev=next;
        previous=current;
        current=next;
        }
        head=previous;
    }



    public void printlinklist(){
        if (head==null) {
            System.out.println("ll is empty");
        }
        node temp =head;
        while (temp!=null) {
            System.out.print(temp.data+"<=>");
            temp=temp.next;
        }
        System.out.println("null");
    }
}
public class dlinklist {
    public static void main(String[] args) {
        doublylinklist dll=new doublylinklist();
        dll.addfirst(2);
        dll.addfirst(3);
        dll.addfirst(4);
        dll.addfirst(5);
        dll.addlast(1);
        // dll.removelast();
        // dll.removefirst();
        dll.printlinklist();
        dll.reverse();
        dll.printlinklist();

        System.out.println(dll.size);
    }
}
