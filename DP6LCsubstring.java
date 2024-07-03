public class DP6LCsubstring {
    public static int LCsubstring(String str1,String str2,int n,int m) {
        int ans=0;
        int dp[][]=new int [n+1][m+1];
        for (int i = 0; i < n+1; i++) {
            dp[i][0]=0;
        }
        for (int j = 0; j < m+1; j++) {
            dp[0][j]=0;
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (str1.charAt(i-1)==str2.charAt(j-1)) {
                    dp[i][j]=dp[i-1][j-1]+1;
                    ans=Math.max(dp[i][j], ans);        
                }else{
                    dp[i][j]=0;
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return ans;
    }
    public static void main(String[] args) {
        String str1="ABCDE";
        String str2="ACDEF";
        System.out.println(LCsubstring(str1, str2, str1.length(), str2.length()));
    }
}
