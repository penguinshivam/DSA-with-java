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
    public void addlast(int data){    //o(1)
        node newnode=new node(data);
        size++;
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
        size++;
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
        size--;
    }


    public void removelast(){
        int val;
        if (head==null) {
            return;
        }
        
        else if(size==1){
            val=tail.data;
            head=tail=null;
            return; 
        }
        val=tail.data;
        node temp=head;
        for (int count=0;count<size-2;count++) {
            temp=temp.next;
        }
        temp.next=null;
        tail=temp;
        size--;
        System.out.println("removed data is "+val);
    }
    public int searchitrative(int data){
        if (head==null) {
            System.out.println("ll is empty");
            return -1;

        }
        node temp =head;
        int idx=0;
        while (temp!=null) {
            
            if (temp.data==data) {
                return idx+1;
            }
            temp=temp.next;
            idx++;

            
        }
        return -1;
    }
    public int helper(node head,int key){
        
        if(head==null){
            return -1;
        }

        if (head.data==key) {
            return 0;
        } 
        int idx = helper(head.next, key);
        if (idx ==-1) {
            return -1;
        }
        return idx+1;
    }
    public int searchrecursive(int data ){
        return helper(head,data);
    }
    public void reverse(){
        node previous=null;
        node current=tail=head;
        while (current!=null) {
        node next=current.next;
        current.next=previous;
        previous=current;
        current=next;
        }
        head=previous;
    }

    public void removenthfromlast(int index){  //0(n)
        int sz=0;
        if (index==0) {
            removefirst();
            return;
        }
        node temp=head;
        while (temp!=null) {
            temp=temp.next;
            sz++;
        }
        int count =1;
        node temp1=head;
        while (count<sz-index) {
            
            temp1=temp1.next;
            count++;
        }
        temp1.next=temp1.next.next;
        return;


    }
    public static void main(String[] args) {
        linkdlist l1=new linkdlist();
        
        l1.printlinklist();
        l1.addfirst(2);
        l1.printlinklist();
        l1.addfirst(1);
        l1.printlinklist();
        l1.addlast(4);
        l1.printlinklist();
        l1.addlast(6);
        l1.printlinklist();
        l1.addlast(7);
        l1.printlinklist();
        l1.addmiddle(2,3);
        l1.printlinklist();
        // l1.removefirst();
        // l1.printlinklist();
        // l1.removelast();
        // l1.printlinklist();
        // System.out.println(l1.searchrecursive(4));
        // l1.reverse();
        l1.removenthfromlast(3);
        l1.printlinklist();

        System.out.println(size);

    }    
}
