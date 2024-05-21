import java.util.ArrayList;
import java.util.List;

public class Quene {

    public static List<List<Integer>> solveNQueens(int n) {
        List<List<Integer>> result = new ArrayList<>();
        int[][] board = new int[n][n];
        solveNQueensUtil(board, 0, result);
        return result;
    }

    private static void solveNQueensUtil(int[][] board, int col, List<List<Integer>> result) {
        if (col == board.length) {
            result.add(construct(board));
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                solveNQueensUtil(board, col + 1, result);
                board[i][col] = 0;
            }
        }
    }

    private static boolean isSafe(int[][] board, int row, int col) {
        int i, j;
        // Check this row on left side
        for (i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }
        // Check upper diagonal on left side
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        // Check lower diagonal on left side
        for (i = row, j = col; j >= 0 && i < board.length; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> construct(int[][] board) {
        List<Integer> res = new ArrayList<>();
        for (int[] row : board) {
            for (int cell : row) {
                res.add(cell);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> solutions = solveNQueens(n);
        for (List<Integer> solution : solutions) {
            System.out.println(solution);
        }
    }
}
