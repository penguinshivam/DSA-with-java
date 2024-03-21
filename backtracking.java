public class backtracking {
    public static void printarr(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void change(int arr[],int i,int val) {
        if (i==arr.length) {
            printarr(arr);
            return;
        }
        arr[i]=val;
        change(arr, i+1, val+1);
        arr[i]=val-2;
    }

    public static void subSets(String str,String ans,int i){
        // base case
        if (i==str.length()) {
            if (ans.length()==0) {
                System.out.println("NULL");
            }
            System.out.println(ans);
            return;
            
        }
        // recusion
        // yes call
        subSets(str, ans+str.charAt(i), i+1);
        // no call
        subSets(str, ans, i+1);

    }
    // permutation (O (n *n!))
    public static void permutation(String str,String ans){
        // base case
        if (str.length()==0) {
            System.out.println(ans);
            return;
        }
        // recusion 
        for (int i = 0; i < str.length(); i++) {
            char charcurrent =str.charAt(i);
            String NewStr= str.substring(0, i)+str.substring(i+1);
            permutation(NewStr, ans+charcurrent);
        }

    }
    public static void printboard(char board[][]) 
    {
        System.out.println("-------------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        

    }
    public static boolean isSafe(char board[][],int row,int col) {
        for (int i = row-1; i >= 0; i--) {
            if (board[i][col]=='Q') {
                return false;
            }
        }
        for (int i = row-1, j =col-1 ;i>=0&&j>=0; i--,j--) {
            if (board[i][j]=='Q') {
                return false;
            }
            
        }
        for (int i = row-1,j=col+1; i>=0 && j< board.length; i--,j++) {
            if (board[i][j]=='Q') {
                return false;
            }

        }
        return true;
    }

    // n queen 
    public static void nqueen(char board[][],int row){
        
        if (row==board.length) {
            printboard(board);
            return;
        }
        for (int j = 0; j < board.length; j++) {
            if(isSafe(board,row,j)){
                board[row][j]='Q';
                nqueen(board, row+1);
                board[row][j]='.';
            }
        }

    }
    
    
    
    public static void main(String[] args) {
        // int arr[]=new int[5];
        // change(arr,0,1);
        // subSets("abc", "", 0);
        // permutation("abc","");
        int n =4;
        char board [][]=new char [n][n];
        // initial
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j]='.';
            }
        }
        nqueen(board,0);
        // printarr(arr);
    }
}
