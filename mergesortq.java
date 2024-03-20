import java.util.Arrays;

public class mergesortq {
    public static void mergeSort(String[] arr) {
        if (arr == null || arr.length <= 1) {
            return; 
        }
        int mid = arr.length / 2;
        String[] leftArray = Arrays.copyOfRange(arr, 0, mid);
        String[] rightArray = Arrays.copyOfRange(arr, mid, arr.length);
        
        mergeSort(leftArray);
        mergeSort(rightArray);
        
        merge(arr, leftArray, rightArray);
    }
    
    private static void merge(String[] arr, String[] leftArray, String[] rightArray) {
        int leftIndex = 0, rightIndex = 0, mergeIndex = 0;
        
        while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            if (leftArray[leftIndex].compareTo(rightArray[rightIndex]) < 0) {
                arr[mergeIndex++] = leftArray[leftIndex++];
            } else {
                arr[mergeIndex++] = rightArray[rightIndex++];
            }
        }
        
        while (leftIndex < leftArray.length) {
            arr[mergeIndex++] = leftArray[leftIndex++];
        }
        
        while (rightIndex < rightArray.length) {
            arr[mergeIndex++] = rightArray[rightIndex++];
        }
    }
    
    public static void main(String[] args) {
        String[] arr = { "sun", "earth", "mars", "mercury" };
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
