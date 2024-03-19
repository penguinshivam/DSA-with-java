public class Test{
 public static void insertionsort(int arr[]) {
     for (int i = 1; i < arr.length; i++) {
         int j=i-1;
         int temp=arr[i];
         while (j>=0 && arr[j]>temp) {
             arr[j+1]=arr[j];
             j--;
         }
         arr[j+1]=temp;
     }

   
 }
   public static void main(String[] args) {
    System.out.println("hello");
 }   
}