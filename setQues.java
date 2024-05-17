import java.util.*;

public class setQues {
    public static void countDistintElement(int arr[]){
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            hs.add(arr[i]);
        }
        System.out.println(hs.size());
    }
    public static void main(String[] args) {
        int arr[]={4,3,2,5,6,7,3,4,2,1};
        countDistintElement(arr);
        int ar1[]={7,3,9};
        int ar2[]={6,3,9,2,9,4};
        HashMap<Integer,Integer> hm = new HashMap<>();
        for (int i = 0; i < ar1.length; i++) {
            hm.put(ar1[i], hm.getOrDefault(ar1[i], 0)+1);
        }
        for (int i = 0; i < ar2.length; i++) {
            hm.put(ar2[i], hm.getOrDefault(ar2[i], 0)+1);
        }
        System.out.println(hm.keySet());
        
        System.out.println();
        
    }
}
