
import java.util.*;

// import javax.print.DocFlavor.INPUT_STREAM;


public class a1 {


    public static void main(String[] args) {
        
        ArrayList<Integer> list =new ArrayList<>();

        list.add(2);
        list.add(4);
        list.add(3);
        list.add(7);
        list.add(6);
        list.add(1,11);
        // System.out.println(list);


        // int element=list.get(1);
        // System.out.println(element);
        // list.remove(1);
        // System.out.println(list);
        // list.set(2, 10);
        // System.out.println(list);
        // System.out.println(list.contains(10));
        // System.out.println(list.contains(11));
        // System.out.println(list.size());

        // for (int i = 0; i < list.size(); i++) {
        //     System.out.print(list.get(i));
        // }
        // System.out.println("reverse of arraylist");
        // ArrayList<Integer> list1 =new ArrayList<>();
        // // ArrayList<Integer> list2 =new ArrayList<>();
        // list1.add(2);
        // list1.add(4);
        // list1.add(3);
        // list1.add(7);
        // list1.add(6);
        // System.out.println(list1);

        // System.out.println(list1);
        // for (int i = list1.size()-1; i >= 0; i--) {
        //     System.out.print(list1.get(i)+" ");
        //     list2.add(list1.get(i));
        // }
        // System.out.println(list2);
        // int max = Integer.MIN_VALUE;
        // for (int i = 0; i < list1.size(); i++) {
        //     if (list1.get(i)>max) {
        //         max=list1.get(i);
        //     }
        //     max=Math.max(max, list1.get(i));
        // }
        // System.out.println("max element = "+max);
        
        // int idx1 =2;
        // int idx2= 3;
        // int temp = list1.get(idx1);
        // int temp2 = list1.get(idx2);
        // list1.set(idx1,temp2);
        // list1.set(idx2,temp);
        // swap(list1,idx1, idx2);
        // ascending order sort
        // Collections.sort(list1);
        // desending
        // Collections.sort(list1,Collections.reverseOrder());
        // System.out.println(list1);
        ArrayList<ArrayList<Integer>> mainlist=new ArrayList<>();
        ArrayList<Integer> list5 = new ArrayList<>();
        // list5.add(4);
        // list5.add(3);
        // list5.add(7);
        // list5.add(6);
        // list5.add(2);
        for (int i = 1; i <= 5; i++) {
            list5.add( 1*i);
        }
        mainlist.add(list5);
        ArrayList<Integer> list6 = new ArrayList<>();
        // list6.add(8);
        // list6.add(5);
        // list6.add(4);
        // list6.add(3);
        // list6.add(3);
        for (int i = 1; i <= 5; i++) {
            list6.add( 2*i);
        }
        mainlist.add(list6);
        ArrayList<Integer> list7 = new ArrayList<>();
        // list6.add(8);
        // list6.add(5);
        // list6.add(4);
        // list6.add(3);
        // list6.add(3);
        for (int i = 1; i <= 5; i++) {
            list7.add( 3*i);
        }
        mainlist.add(list7);
        
        for (int i = 0; i < mainlist.size(); i++) {
            ArrayList<Integer> curr = mainlist.get(i);
            for (int j = 0; j < curr.size(); j++) {
                System.out.print(curr.get(j)+" ");
            }
            System.out.println();
           
        }
        System.out.println(mainlist);

    }
}
