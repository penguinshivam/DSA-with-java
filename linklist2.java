

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

        private node getmid(node head){
            node fast= head.next;
            node slow= head;
            while (fast != null && fast.next!=null) {
                slow = slow.next;
                fast=fast.next.next;
            }
            return slow;//because slow is middle
        }

        private node merge(node head1 ,node head2){
            node mergell = new node (-1);
            node temp = mergell;

            while (head1!=null && head2!=null) {
                if (head1.data<=head2.data) {
                    temp.next=head1;
                    head1=head1.next;
                    temp=temp.next;
                }
                else{
                    temp.next=head2;
                    head2=head2.next;
                    temp=temp.next;
                }
            }
            while (head1!=null) {
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }
            while (head2!=null) {
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
            return mergell.next;
        } 
        
        public node mergesort(node head){
            if (head == null || head.next==null) {
                return head;
            }
            node mid=getmid(head);
            node righthead=mid.next;
            mid.next=null;
            node newleft=mergesort(head);
            node newright=mergesort(righthead);

            return merge(newleft,newright);
        }
    public static void main(String[] args) {
        // head=new node(1);
        // head.next=new node (2);
        // head.next.next=new node (3);
        // head.next.next.next=head.next;
        // System.out.println(cycle(head));
        // removecycle(head);
        // System.out.println(cycle(head));
        linklist2 l1 =new linklist2();
        l1.addfirst(1);
        l1.addfirst(2);
        l1.addfirst(3);
        l1.addfirst(4);
        l1.printlinklist();
        
        // l1.head=l1.mergesort(l1.head);
        l1.printlinklist();

    }
}
