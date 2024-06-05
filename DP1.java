import java.util.*;

public class DP1 {
    public static int fib(int n) {
        if (n==0||n==1) {
            return n;
        }
        return fib(n-1)+fib(n-2);
    }
    public static int fibmemo(int n,int f[]) {
        if (n==0||n==1) {
            return n;

        }
        if (f[n]!=0) {
            return f[n];
        }
        f[n]=fibmemo(n-1, f)+fibmemo(n-2, f);
        // System.out.print(f[n]+" ");
        return f[n];
    }    
    public static int fibtable(int n){
        int dp[]=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for (int i = 2; i <= n; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static int climbingstairs(int n){
        if (n==0) {
            return 1;
        }
        if (n<0) {
            return 0;
        }
        return climbingstairs(n-1)+climbingstairs(n-2);
    }
    public static int climbingstairsmemo(int n){
        int cs[]=new int[n+1];
        Arrays.fill(cs, -1);
        if (n==0) {
            return 1;
        }
        if (n<0) {
            return 0;
        }
        if (cs[n]!=-1) {
            return cs[n];
        }
        cs[n]=climbingstairs(n-1)+climbingstairs(n-2);
        return cs[n];
    }
    public static int climbingstairstable(int n){
        int cs[]=new int[n+1];
        Arrays.fill(cs, -1);
        cs[0]=1;
        cs[1]=1;
        for (int i = 2; i <= n; i++) {
            cs[i]=cs[i-1]+cs[i-2];
        }
        return cs[n];
    }
    public static int climbingstairsVarMemo(int n){
        int cs[]=new int[n+1];
        Arrays.fill(cs, -1);
        if (n==0 || n==1) {
            return 1;
        }
        if (n<0) {
            return 0;
        }
        if (cs[n]!=-1) {
            return cs[n];
        }
        cs[n]=climbingstairsVarMemo(n-1)+climbingstairsVarMemo(n-2)+climbingstairs(n-3);
        return cs[n];
    }
    public static int climbingstairsVamTable(int n){
        int cs[]=new int[n+1];
        Arrays.fill(cs, -1);
        cs[0]=1;
        cs[1]=1;
        cs[2]=2;
        for (int i = 3; i <= n; i++) {
            cs[i]=cs[i-1]+cs[i-2]+cs[i-3];
        }
        return cs[n];
    }
    public static void main(String[] args) {
        int n=5;
        int f[]=new int[n+1];
        System.out.println(fibmemo(n,f));
        System.out.println(fibtable(n));
        System.out.println(climbingstairs(5));
        System.out.println(climbingstairsmemo(1));
        System.out.println(climbingstairstable(5));
        System.out.println(climbingstairsVarMemo(5));
        System.out.println(climbingstairsVamTable(5));
    }
}
