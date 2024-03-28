import java.util.Array;
public class sorting {
    
public static int compare(int a,int b){
    // a < b -ve
    // a==b 0
    // a > b +ve
    return a- b;
    // return b-a;collection 
}    
public static void printarr(int arr[]){
     for(int i = 0;i<arr.length;i++) {
        System.out.print(arr[i]+" ");
     }
     System.out.println();
}


public static void counting(int arr[]){
      int largest = Integer.MIN_VALUE ;
    for( int i = 0;i<arr.length;i++){
        largest = Math.max(largest,arr[i]);
    }
    int count[] = new int[largesr+1];
    for(int i = 0;i<arr.length;i++){
        count[arr[i]]++;

    }
    int j = 0;
    for(int i = 0;i<count.length;i++){
        while(count[i]> 0){
         arr[j] = i;
         j++;
          count[i]--;

}    }
}
    
}
public static void main(String args[]){
    int arr = {5,4,1,3,2};
    // Array.sort(arr);
    // array.sort(arr,start,end)        ----.Array
    // array.sort(arr,start,end,collection.reverseOrder())    ---.collections; works on oject type (int-->integer)
    counting(arr);
    printArr(arr);
}