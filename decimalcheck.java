public class decimalcheck {
    public static void main(String[] args) {
        int n=14;
        int m =5;
        int temp=0;
        for (int i = 0; i < m; i++) {
            temp = n%2;
            n=n/2;
            System.out.println(temp);
        }
        // System.out.println(temp);
    }
    
}
