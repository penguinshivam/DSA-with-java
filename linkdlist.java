public class linkdlist {
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
    
    public void addfirst(int data){    //o(1)
         // step 1 create a new node
         node newnode=new node(data);
        if(head==null){
            head=tail=newnode;
            return;
        }
       
        // new node next => head
        newnode.next=head;
        // head=>newnode
        head=newnode;
    }
    public void addlast(int data){    //o(1)
        node newnode=new node(data);
        if (head==null) {
            head=tail=newnode;
            return;
        }
        tail.next=newnode;
        tail=newnode;
    }
    public void addmiddle(int index,int data){  //0(n)
        if (index==0) {
            addfirst(data);
            return;
        }
        node newnode=new node(data);
        node temp=head;
        if (head==null) {
            head=tail=newnode;
            return;
        }
        int count =0;
        
        while (count<index-1) {
            
            temp=temp.next;
            count++;
        }
        newnode.next=temp.next;
        temp.next=newnode;

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
    public static void main(String[] args) {
        linkdlist l1=new linkdlist();
        
        l1.printlinklist();
        l1.addfirst(1);
        l1.printlinklist();
        l1.addfirst(2);
        l1.printlinklist();
        l1.addfirst(5);
        l1.printlinklist();
        l1.addlast(6);
        l1.printlinklist();
        l1.addlast(7);
        l1.printlinklist();
        l1.addmiddle(3,5);
        l1.printlinklist();

    }    
}
