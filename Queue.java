public class Queue {
    static class Que{
        static int arr[];
        static int size;
        static int rear;
        static int front;

        Que(int n){
            arr = new int [n];
            size=n;
            rear=-1;
            front=-1;
        }
        public boolean isEmpty(){
            return rear==-1&&front ==-1;
        }
        public boolean isFull(){
            return (rear+1)%size==front;
        }
        public void add(int data){
            if (isFull()) {
                System.out.println("isFull");
                return;
            }
            // if (rear == size-1){
            //     System.out.println("queue is full");
            // }
            if (front==-1) {
                front =0;   
            }
            rear=(rear+1)%size;
            arr[rear]=data;

        }
        public int remove(){
            if (isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }
            int result =arr[front];
            // for (int i = 0; i < rear; i++) {
            //     arr[i]=arr[i+1];
            // }
            if (rear==front) {
                rear = front =-1;
            }else
            {
                front=(front+1)%size;
            }
            return result;

        }
        public int peek(){
            if (isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }
            return arr[front];
        }

    }
    public static void main(String[] args) {
        Que q= new Que(3);
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        q.add(4);
        System.out.println(q.remove());
        q.add(5);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
