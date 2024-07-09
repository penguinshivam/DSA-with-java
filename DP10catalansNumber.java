import java.util.Arrays;

public class DP10catalansNumber {
    public static int catalanrec(int n){
        if (n==0||n==1) {
            return 1;
        }
        int ans=0;
        for (int i = 0; i <=n-1; i++) {
            ans+=catalanrec(i)*catalanrec(n-i-1);
        }
        return ans;
    }
    public static int catlantable(int n){
        int [] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
          
        for (int i = 2; i <=n; i++) {
            for (int j = 0; j <= i-1; j++) {
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
    public static int catlanmemo(int n){
        int [] dp=new int[n+1];
        Arrays.fill(dp, -1);
        if (n==0||n==1) {
            return 1;
        }
        if (dp[n]!=-1) {
            return dp[n];
        }
        int ans=0;
        for (int i = 0; i <=n-1; i++) {
            ans+=catlanmemo(i)*catlanmemo(n-i-1);
        }
        return dp[n]=ans;
    }
    public static void main(String[] args) {
        System.out.println(catlanmemo(5));
        System.out.println(catalanrec(5));
        System.out.println(catlantable(10));
    }
}
