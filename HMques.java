import java.util.*;

public class HMques{
    public static void majorityele(int arr[]) {
        HashMap<Integer,Integer> hm =new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            // if (hm.containsKey(arr[i])) {
            //     hm.put(arr[i], hm.get(arr[i])+1);
            // }else{
            //     hm.put(arr[i], 1);
            // }
            hm.put(arr[i],hm.getOrDefault(arr[i], 0)+1);
        }
        for (Integer key : hm.keySet()) {
            if(hm.get(key)>arr.length/3){
                System.out.println(key);
            }
        }
    }
    public static boolean validAnagram(String s,String t) {
        if (s.length()!=t.length()) {
            return false;
        }
        HashMap <Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (map.get(ch)!=null) {
                if (map.get(ch)==1) {
                    map.remove(ch);
                }
                else{
                    map.put(ch, map.get(ch)-1);
                }
            }else{
                return false;
            }
        }
        return map.isEmpty();
    }
    public static void main(String[] args) {
        int arr[]= {1,2,3,5,1,3,5,1,3,1};
        majorityele(arr);
        String s="tulip";
        String t="pilut";
        System.out.println(validAnagram(s, t));

    }
}