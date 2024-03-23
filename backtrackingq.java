public class backtrackingq {
    public static void printgrid(int n[][]) {
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n.length; j++) {
                System.out.print(n[i][j]);
            }
            System.out.println();
        }
    }
    public static boolean gridpath(int n[][],int s,int e) {
        return true;
    }
    public static void main(String[] args) {
        int n[][]={{1,0,0,0},{1,1,0,1},{0,1,0,0},{1,1,1,1}};
        if (gridpath(n,1,0)) {
            System.out.println("sol");
            printgrid(n);
        }
        else{
            System.out.println("sol doesnt exists");
        }
    }
}
