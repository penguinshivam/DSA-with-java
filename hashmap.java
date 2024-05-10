import java.util.*;

public class hashmap {
    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("US", 100);
        hm.put("china", 50);
        hm.put("UK", 150);
        System.out.println(hm);
        System.out.println(hm.get("Idia"));
        System.out.println(hm.containsKey("UK"));
        System.out.println(hm.remove("UK"));
        System.out.println(hm);
        hm.put("US", 106);
        System.out.println(hm);
        System.out.println(hm.size());
        // hm.clear();
        System.out.println(hm.isEmpty());
        
        Set<String> keys = hm.keySet();

        System.out.println(keys);
        for (String str : keys) {
            System.out.println("keys = "+str+",values = "+hm.get(str));
        }
    }
}
