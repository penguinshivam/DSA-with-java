// import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

public class DP7LongestIncresingSubseq {
    public static int LIS(int arr1[]) {
        int n=arr1.length;
        HashSet<Integer> set=new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        } 
        int h=0;
        int arr2[]=new int[set.size()];
        for (int num : set) {
            arr2[h]=num;
            h++;
        }
        Arrays.sort(arr2);
        int m =arr2.length;

        int dp[][]=new int [n+1][m+1];
        for (int i = 0; i < n+1; i++) {
            dp[i][0]=0;
        }
        for (int j = 0; j < m+1; j++) {
            dp[0][j]=0;
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (arr1[i-1]==arr2[j-1]) {
                    dp[i][j]=dp[i-1][j-1]+1;
                    // str.append(str2.charAt(j-1));
        
                }else{
                    int ans1=dp[i-1][j];
                    int ans2=dp[i][j-1];
                    dp[i][j]=Math.max(ans1, ans2);
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
            
        }
        // System.out.println(str);
        return dp[n][m];
        
    }
    public static void main(String[] args) {
        int arr1[]={50,3,10,7,40,80};
        System.out.println(LIS(arr1));
    }
}
