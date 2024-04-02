public class llques {
    
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
    public void deleteneleaftermnodes(int m ,int n){
        addfirst(0);
        node temp =head;
        while (temp!=null) {
            for (int i = 1; i <= m && temp!=null; i++) {
                temp=temp.next;
            }
            
            
            for (int i = 1; i <= n && temp!=null; i++) {
                temp.next=temp.next.next;
            }
        }
    }
    public void delNafterM(int n, int m){
        node temp = head,t;
        while( temp != null){
                for( int  i = 1 ; i< n && temp  != null; i++){
                    temp = temp.next;
                }
                if( temp == null){
                    return;
                }
                t = temp.next;
                for(int i = 1; i<= n && t != null; i++ ){
                
                t= t.next; 
                }
                temp.next = t;
                temp= t;
        }


        }
    public node getIntersectionNode(node head1,node head2){
        // node p1=head1.next;
        // node p2=head2.next;
        while (head2!=null) {
            node temp=head1;
            while (temp!=null) {
                if (temp==head2) {
                    return head2;
                }
                temp=temp.next;
            }
            head2=head2.next;
        }
        return null;
    }
    // ques 1
    // public static void main(String[] args){
    //     llques list = new llques();
    //     node head1, head2;
    //     head1 = new node(10);
    //     head2 = new node(3);
    //     node newNode = new node(6);
    //     head2.next = newNode;
    //     newNode = new node(9);
    //     head2.next.next = newNode;
    //     newNode = new node(15);
    //     head1.next = newNode;
    //     head2.next.next.next = newNode;
    //     newNode = new node(30);
    //     head1.next.next = newNode;
    //     head1.next.next.next = null;
    //     node intersectionPoint= list.getIntersectionNode(head1, head2);
    //     if (intersectionPoint == null) {
    //         System.out.print(" No Intersection Point \n");
    //     }else {
    //         System.out.print("Intersection Point: "+ intersectionPoint.data);
    //     }
    // }

    public static void main(String[] args) {
        llques l1 =new llques();
        l1.addfirst(10);
        l1.addfirst(9);
        l1.addfirst(8);
        l1.addfirst(7);
        l1.addfirst(6);
        l1.addfirst(5);
        l1.addfirst(4);
        l1.addfirst(3);
        l1.addfirst(2);
        l1.addfirst(1);
        l1.printlinklist();
        l1.delNafterM(2, 2);
        l1.printlinklist();
    }
}
