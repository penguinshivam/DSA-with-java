public class DP3TargetSumSubset {
    public static boolean TargetSumTable(int numbers[],int TargetSum,int n) {
        boolean dp[][]=new boolean[n+1][TargetSum+1];
        
        for (int i = 0; i < n+1; i++) {
            dp[i][0]=true;
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < TargetSum+1; j++) {
                int v=numbers[i-1];
                if (v<=j&&dp[i-1][j-v]==true) {
                    // int p1=v+dp[i-1][j-v];
                    // int p2=dp[i-1][j];
                    dp[i][j]=true;
                }else if (dp[i-1][j]==true) {
                    dp[i][j]=true;
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[n][TargetSum];
    }
    public static void main(String[] args) {
        int numbers[]={4,2,7,1,3};
        int TargetSum=10;
        System.out.println(TargetSumTable(numbers, TargetSum, numbers.length));
    }
}
