import java.util.*;
public class minAbsoluteDiffPair {
    public static void main(String[] args) {
        int a1[]={4,1,8,7};
        int a2[]={2,3,6,5};
        Arrays.sort(a1);
        Arrays.sort(a2);
        int sum=0;
        for (int i = 0; i < a2.length; i++) 
        {
            sum=sum+Math.abs(a1[i]-a2[i]);
        }
        System.out.println(sum);
    }
}
