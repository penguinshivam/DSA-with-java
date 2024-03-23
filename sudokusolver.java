public class sudokusolver {
    public static boolean ifsafe(int sudoku[][],int row,int col,int digit) {
        for (int i = 0; i <= 8; i++) {
            if (sudoku[row][i]==digit) {
                return false;
            }
        }
        for (int i = 0; i <= 8; i++) {
            if (sudoku[i][col]==digit) {
                return false;
            }
        }
        int startrow=(row/3)*3;
        int startcol=(col/3)*3;
        for (int i = startrow; i < startrow+3; i++) {
            for (int j = startcol; j < startcol+3; j++) {
                if (sudoku[i][j]==digit) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean sudokusolver(int sudoku[][],int row,int col) {
        if (row==9) {
            return true;
            
        }
        int nextrow=row, nextcol = col+1;
        if(col+1==9){
            nextrow=row+1;
            nextcol=0;
        }
       
        if (sudoku[row][col]!=0) {
            return sudokusolver(sudoku, nextrow, nextcol);
            
        }
        for (int digit = 0; digit <= 9 ; digit++) {
            if (ifsafe(sudoku,row,col,digit)) {
                sudoku[row][col]=digit;
                if (sudokusolver(sudoku, nextrow, nextcol)) {
                    return true;
                }
                sudoku[row][col]=0;
                
            }
            
        }
        return false;
    }
    public static void printsudoku(int sudoku[][]) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
            
        }
    }
    public static void main(String[] args) {
        int sudoku[][]={ {3, 0, 6, 5, 0, 8, 4, 0, 0},
        {5, 2, 0, 0, 0, 0, 0, 0, 0},
        {0, 8, 7, 0, 0, 0, 0, 3, 1},
        {0, 0, 3, 0, 1, 0, 0, 8, 0},
        {9, 0, 0, 8, 6, 3, 0, 0, 5},
        {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
        {1, 3, 0, 0, 0, 0, 2, 5, 0},
        {0, 0, 0, 0, 0, 0, 0, 7, 4},
        {0, 0, 5, 2, 0, 6, 3, 0, 0} };
        if (sudokusolver(sudoku, 0, 0)) {
            System.out.println("solution");
            printsudoku(sudoku);
        }
        else{
            System.out.println("sol dosent exist");
        }
    }
}
