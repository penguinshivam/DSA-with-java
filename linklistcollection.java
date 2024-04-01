import java.util.LinkedList;
public class linklistcollection {

    public static void main(String[] args) {
        // create
        LinkedList<Integer>ll=new LinkedList<>();
        ll.addLast(3);
        ll.addLast(7);
        ll.addFirst(5);
        System.out.println(ll);
        ll.removeLast();
        ll.removeFirst();
        System.out.println(ll);


    }
}
