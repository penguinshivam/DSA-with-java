
//  linklist
class linklist {
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

    public node getmid(node head){
        node fast= head.next;
        node slow= head;
        while (fast != null && fast.next!=null) {
            slow = slow.next;
            fast=fast.next.next;
        }
        return slow;//because slow is middle
    }
    // zig zag 
    /*step 1 get mid
     * reverse the 2nd half 
     * alternate merging
     */
    public void zigzag(){
        node fast= head.next;
        node slow= head;
        while (fast != null && fast.next!=null) {
            slow = slow.next;
            fast=fast.next.next;
        }
        node midnode=slow;



        node current=midnode.next;
        midnode.next=null;
        node previous=null;
        node next;
        while (current!=null) {
        next=current.next;
        current.next=previous;
        previous=current;
        current=next;
        }
        node right=previous;
        node left= head;
        node nextleft,nextright;
        while (right!=null &&left!=null) {
            nextleft=left.next;
            left.next=right;
            nextright=right.next;
            right.next=nextleft;
            left=nextleft;
            right=nextright;
        }
    }
}



public class zigzag {
    public static void main(String[] args) {
        linklist l1 =new linklist();
        l1.addfirst(6);
        l1.addfirst(5);
        l1.addfirst(4);
        l1.addfirst(3);
        l1.addfirst(2);
        l1.addfirst(1);
        l1.printlinklist();
        l1.zigzag();
        l1.printlinklist();
    }
    
}