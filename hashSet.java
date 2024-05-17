import java.util.*;
public class hashSet {
    public static void main(String args[]){
        HashSet<Integer> set = new HashSet<>();
        HashSet<String> cities = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(4);
        set.add(2);
        set.add(1);

        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Noida");
        cities.add("Jammu");
        
            // Iterator (random) 
        // Iterator it = cities.iterator();
        // while( it.hasNext()){
            // System.out.println(it.next());
        // }
        
            // Advanced loop
        for(String city : cities){
            System.out.println(city);
        }

            // Operations
        System.out.println(set);
        set.clear();
        System.out.println(set.size());
        System.out.println(set.isEmpty());
        set.remove(2);
        if(set.contains(2)){
            System.out.println("set contain 2");
        }
        // if(set.contains(3)){
        //     System.out.println("set contains 3");
        // }
    

    }
}