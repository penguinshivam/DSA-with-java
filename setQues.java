import java.util.*;

public class setQues {
    public static void countDistintElement(int arr[]){
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            hs.add(arr[i]);
        }
        System.out.println(hs.size());
    }
    public static void UnionAndIntersection(int ar1[],int ar2[]) {
        HashSet<Integer> hm = new HashSet<>();
        for (int i = 0; i < ar1.length; i++) {
            hm.add(ar1[i]);
        }
        for (int i = 0; i < ar2.length; i++) {
            hm.add(ar2[i]);
        }
        System.out.println("Union ="+hm.size()+","+hm);
        int count=0;

        hm.clear();
        int ar[]=new int[ar2.length];
        for (int i = 0; i < ar1.length; i++) {
            hm.add(ar1[i]);
        }
        for (int i = 0; i < ar2.length; i++) {
            if (hm.contains(ar2[i])) {
                count++;   
                // System.out.println(ar2[i]);
                ar[count]=ar2[i];
                hm.remove(ar2[i]);
            }
        }
        System.out.print("intersection ="+count+",[");
        for (int i = 0; i < ar.length; i++) {
            if(ar[i]!=0)
            System.out.print(ar[i]+",");
        }
        System.out.print("]");
    }
    public static void FindItineraryFromTik() {
        HashMap<String,String> tickets = new HashMap<>();
        tickets.put("Chennai","bengaluru");
        tickets.put("Mumbai","Delhi");
        tickets.put("Goa","Chennai");
        tickets.put("Delhi","Goa");
        String start =getStart(tickets);
        System.out.println();
        System.out.print(start);
        for (String key : tickets.keySet()) {
            System.out.println(key);
            System.out.print("==>"+tickets.get(start));
            start=tickets.get(start);
        }
        System.out.println();
    }
    public static String getStart(HashMap<String,String> tickets) {
        HashMap<String,String> revMap = new HashMap<>();
        for (String  key : tickets.keySet()) {
            revMap.put(tickets.get(key), key);
        }
        for (String  key : tickets.keySet()) {
            if (!revMap.containsKey(key)) {
                return key;
            }
        }
        return null;
    }
    public static void largestSubArrWith0Sum(int arr[]){
        HashMap<Integer,Integer> hm =new HashMap<>();
        int len=0;
        int sum=0;
        for (int j = 0; j < arr.length; j++) {
            sum +=arr[j];
            if(hm.containsKey(sum))
            {
                len=Math.max(len, j-hm.get(sum));
            }else{
                hm.put(sum, j);
            }
        }
        System.out.println(len);
    }
    public static void subArrSumEqualTok(int arrr[],int k){
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0, 1);
        int sum=0;
        int ans=0;
        for (int i = 0; i < arrr.length; i++) {
            sum+=arrr[i];
            if (hm.containsKey(sum-k)) {
                ans+=hm.get(sum-k);
            }
            hm.put(sum, hm.getOrDefault(sum, 0)+1);
        }
        System.out.println(ans);
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numToIndex.containsKey(complement)) { 
                return new int[] { numToIndex.get(complement), i };
            }
            numToIndex.put(nums[i], i);
        }
        return new int[] {};
    }


    public static void main(String[] args) {
        int arr[]={4,3,2,5,6,7,3,4,2,1};
        countDistintElement(arr);
        int ar1[]={7,3,9};
        int ar2[]={6,3,9,2,9,4};
        UnionAndIntersection(ar1, ar2);
        FindItineraryFromTik();
        int ar[]={15,-2,2,-8,1,7,10};
        largestSubArrWith0Sum(ar);
        int arrr[]= {10,2,-2,-20,10};
        int k =-10;
        subArrSumEqualTok(arrr,k);
        int ar3[]={2,9,3,8,6};
        int j =10;
        System.out.println(twoSum(ar3,j));
    }
}
