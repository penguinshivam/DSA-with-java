import java.util.*;

public class linkHashMap {
    public static void main(String[] args) {
        
        LinkedHashMap<String,Integer> lhm = new LinkedHashMap<>();
        lhm.put("India",100);
        lhm.put("USA",150);
        lhm.put("UK",50);
        lhm.put("China",10); 
        System.out.println(lhm);

        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("India",100);
        hm.put("USA",150);
        hm.put("UK",50);
        hm.put("China",10); 
        System.out.println(hm);

        
    }
    
}
