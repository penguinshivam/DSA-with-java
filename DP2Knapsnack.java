

public class DP2Knapsnack {
    public static int p01knapsack(int val[],int wt[],int W,int n) {
        if (W==0||n==0) {
            return 0;
        }
        if (wt[n-1]<=W) {
            int ans1=val[n-1]+p01knapsack(val, wt, W-wt[n-1], n-1);
            int ans2=p01knapsack(val, wt, W, n-1);
            return Math.max(ans1, ans2);
        }
        else{
            return p01knapsack(val, wt, W, n-1);
            
        }
    }

    public static int p01knapsackMemo(int val[],int wt[],int W,int n,int dp[][]) {
        if (W==0||n==0) {
            return 0;
        }
        if (dp[n][W]!=-1) {
            return dp[n][W];
        }
        if (wt[n-1]<=W) {
            int ans1=val[n-1]+p01knapsackMemo(val, wt, W-wt[n-1], n-1,dp);
            int ans2=p01knapsackMemo(val, wt, W, n-1,dp);
            
            dp[n][W]= Math.max(ans1, ans2);
            return dp[n][W];
        }
        else{
            dp[n][W]= p01knapsackMemo(val, wt, W, n-1,dp);
            return dp[n][W];
            
        }   
    }
    public static int p01knapsackTable(int val[],int wt[],int W,int n) {
        int dp[][]=new int[n+1][W+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0]=0;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j]=0;
        }
        for (int i = 1; i < val.length+1; i++) {
            for (int j = 1; j < W+1; j++) {
                int w=wt[i-1];
                int v=val[i-1];
                if (w<=j) {
                    int p1=v+dp[i-1][j-w];
                    int p2=dp[i-1][j];
                    dp[i][j]=Math.max(p1, p2);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[n][W];
    }
    public static int unboundedKnapsack(int val[],int wt[],int W,int n) {
        int dp[][]=new int[n+1][W+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0]=0;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j]=0;
        }
        for (int i = 1; i < val.length+1; i++) {
            for (int j = 1; j < W+1; j++) {
                if (wt[i-1]<=j) {
                    dp[i][j]=Math.max(val[i-1]+dp[i][j-wt[i-1]], dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[n][W];
    }
    
    public static void main(String[] args) {
        int val[]={15,14,10,45,30};
        int wt[]={2,5,1,3,4};
        int w=7;
        int dp[][]=new int[val.length+1][w+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j]=-1;
            }
        }
        // System.out.println(p01knapsack(val,wt,w,val.length));
        // System.out.println(p01knapsackMemo(val, wt, w, val.length, dp));
        // System.out.println(p01knapsackTable(val, wt, w, val.length));
        System.out.println(unboundedKnapsack(val, wt, w, val.length));
        // p01knapsackMemo();
    }
}
