public class divideandconquer {
    public static void merge(int arr[],int si,int mid,int ei) {
        int temp[]=new int[ei-si+1];
        int i=si;
        int j=mid+1;
        int k=0;
        while (i<=mid && j<=ei) {
            if (arr[i]<arr[j]) {
                temp[k]=arr[i];
                i++;
            }
            else{
                temp[k]=arr[j];
                j++;
            }
            k++;
        }
        while (i<=mid) {
            temp[k]=arr[i];
            k++;
            i++;
        }
        while (j<=ei) {
            temp[k]=arr[j];
            k++;
            j++;
        }
        for (int l = 0; l < temp.length; l++) {
            arr[si+l]=temp[l];
        }
    }
    public static void mergesort(int arr[],int si,int ei) {
        if (si<ei) {
            int mid=si+(ei-si)/2;
            mergesort(arr, si, mid);
            mergesort(arr, mid+1, ei);
            merge(arr, si, mid, ei);
        }
    }
    public static void printarray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static int partition(int arr[],int si,int ei) {
        int pivot=arr[ei];
        int i=si-1;
        for (int j = si; j < ei; j++) {
            if (arr[j]<pivot) {
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp=arr[i+1];
        arr[i+1]=arr[ei];
        arr[ei]=temp;
        return i+1;
    }
    // public static void 


    public static void quicksort(int arr[],int si,int ei) {
        if (si<ei) {
            int pi=partition(arr, si, ei);
            quicksort(arr, si, pi-1);
            quicksort(arr, pi+1, ei);
        }
    }

    public static void main(String[] args) {
        int arr[] = {5,11,7,8,1,0};
        mergesort(arr, 0, arr.length-1);
        // quicksort(arr, 0, arr.length-1);
        printarray(arr);
    }
}
