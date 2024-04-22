public class queue1 {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static class Queue{
       static Node head=null;
       static Node tail=null;

        
        public boolean isEmpty(){
            return head==null&&tail==null;
        }
        
        public void add(int data){
            Node newnode=new Node(data);
            if (head==null) {
                head=tail=newnode;
                return;
            }
            tail.next=newnode;
            tail=newnode;

        }
        public int remove(){
            if (isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }
            int front = head.data;
            if (tail==head) {
                tail=head=null;
            }
            else{
                head=head.next;
            }
            return front;

        }
        public int peek(){
            if (isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }
            return head.data;
        }
        

    }
    public static void main(String[] args) {
        Queue q= new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
