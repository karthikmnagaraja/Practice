package com.dsalgo.leetcode;

/**
 * @author rowarthirowMNagaraja.
 */
public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        if(board==null||board.length==0) return;

        solve(board);
    }

    public boolean solve(char[][]board){

        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[0].length ; j++) {
                if(board[i][j]=='.'){
                    for (char k = '1'; k <='9' ; k++) {
                        if(isValid(board,i,j,k)){
                            board[i][j]=k;
                            if (solve(board))
                                return true;
                           else board[i][j]='.';
                        }

                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValid(char[][]board, int i ,int j,char ch){

        for (int k = 0; k <9 ; k++) {
            if(board[i][k]==ch||board[k][j]==ch) return false;
        }
        for (int row = i/3*3; row <i/3*3 +3 ; row++) {

            for (int col = j/3*3; col <j/3*3+3 ; col++) {
                if(board[row][col]==ch) return false;

            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board={{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','.'},
                {'.','.','.','.','8','.','.','7','9'}

        };
        SudokuSolver s= new SudokuSolver();
        s.solveSudoku(board);
        for (int i = 0; i < board.length; i++) {
            System.out.print("{");
            for (int j = 0; j <board[i].length ; j++) {
                System.out.print(board[i][j]+",");
            }
            System.out.println("}");
        }
    }

}
