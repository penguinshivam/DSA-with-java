public class DP5LCS {
    public static int LCS(String str1,String str2,int n,int m) {
        if (n==0||m==0) {
            return 0;
        }
        if (str1.charAt(n-1)==str2.charAt(m-1)) {
            return LCS(str1, str2, n-1, m-1)+1;

        }else{
            int ans1=LCS(str1, str2, n-1, m);
            int ans2=LCS(str1, str2, n, m-1);
            return Math.max(ans1, ans2);
        }
    }
    public static int LCS2memo(String str1,String str2,int n,int m) {
        int dp[][]=new int [n+1][m+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                dp[i][j]=-1;
            }
        }
        if (n==0||m==0) {
            return 0;
        }
        if (dp[n][m]!=-1) {
            return dp[n][m];
        }
        if (str1.charAt(n-1)==str2.charAt(m-1)) {
            return dp[n][m]=LCS2memo(str1, str2, n-1, m-1)+1;

        }else{
            int ans1=LCS2memo(str1, str2, n-1, m);
            int ans2=LCS2memo(str1, str2, n, m-1);
            return dp[n][m]=Math.max(ans1, ans2);
        }
    }
    public static int LCS3table(String str1,String str2,int n,int m) {
        // StringBuilder str =new StringBuilder();
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
        String str1="abcdge";
        String str2="abedgc";
        System.out.println(LCS(str1, str2, str1.length(), str2.length()));
        System.out.println(LCS2memo(str1, str2, str1.length(), str2.length()));
        System.out.println(LCS3table(str1, str2, str1.length(), str2.length()));

    }
}
