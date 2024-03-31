

public class linklist2 {
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
    // floyd's finding cycle algo
    public static boolean cycle(node head){
        node slow = head;
        node fast = head;

        while (fast!= null && fast.next!=null) 
        {
            slow=slow.next;
            fast=fast.next.next;   
            
            if (slow==fast) {
                return true;
            }
        }
        return false;
    }

    public static void removecycle(node head){
            node slow = head;
            node fast = head;
            boolean cycle=false;
            while (fast!= null && fast.next!=null) 
            {
                slow=slow.next;
                fast=fast.next.next;   
                
                if (slow==fast) {
                    cycle=true;
                    break;
                }
            }
            if (cycle==false) {
                return;
            }


            slow=head;
            node prev=null;
            while (slow!=fast) {
                prev=fast;
                slow=slow.next;
                fast=fast.next;
            }
            prev.next=null;
        }
        
    
    public static void main(String[] args) {
        head=new node(1);
        head.next=new node (2);
        head.next.next=new node (3);
        head.next.next.next=head.next;
        System.out.println(cycle(head));
        removecycle(head);
        System.out.println(cycle(head));
    }
}
