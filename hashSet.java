import java.util.*;

public class hashSet {
    public static void main(String[] args) {
        HashSet<String> hs=new HashSet<>();
        hs.add("delhi");
        hs.add("Noida");
        hs.add("Noida");
        hs.add("beng");
        System.out.println(hs);

        hs.remove(4);
        System.out.println(hs);
        System.out.println(hs.contains(6));
        Iterator it =hs.iterator();
        while (it.hasNext()) {
            
        }

    }
}
