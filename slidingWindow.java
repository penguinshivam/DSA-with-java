import java.util.*;
public class slidingWindow{
    static class Pair{
        int val;
        int idx;
        public Pair(int ar,int idx){
            this.val=ar;
            this.idx=idx;
        }

    }
    public static void slidinWindow(int arr[], int k, int res[]){
        PriorityQueue<Pair> pq = new PriorityQueue<>();

            //1st window
            for( int i = 0; i<k; i++){
                pq.add(new Pair(arr[i],i));
            }

            res[0] = pq.peek().val;

            for(int i = k;i<arr.length;i++){
                while(pq.size() > 0&& pq.peek().idx <= (i-k)){
                    pq.remove();
                }

                pq.add(new Pair(arr[i],i));
                res[i-k+1] = pq.peek().val;
            }

            //print
            for(int i = 0 ; i<res.length;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
    }
    public static void main(String[] args) {
        int arr[]  = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int res[] = new int[arr.length - k+1];
        slidinWindow(arr,k,res);
    }
}