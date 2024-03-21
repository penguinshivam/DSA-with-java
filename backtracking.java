public class backtracking {
    public static void printarr(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void change(int arr[],int i,int val) {
        if (i==arr.length) {
            printarr(arr);
            return;
        }
        arr[i]=val;
        change(arr, i+1, val+1);
        arr[i]=val-2;
    }

    public static void subSets(String str,String ans,int i){
        // base case
        if (i==str.length()) {
            if (ans.length()==0) {
                System.out.println("NULL");
            }
            System.out.println(ans);
            return;
            
        }
        // recusion
        // yes call
        subSets(str, ans+str.charAt(i), i+1);
        // no call
        subSets(str, ans, i+1);

    }
    
    
    
    public static void main(String[] args) {
        // int arr[]=new int[5];
        // change(arr,0,1);
        subSets("abc", "", 0);
        // printarr(arr);
    }
}
