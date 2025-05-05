class NQueens {

    // Print the board
    static void printBoard(int[][] board, int n) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print((cell == 1 ? "Q " : ". "));
            }
            System.out.println();
        }
        System.out.println();
    }

    // Check if placing a queen at board[row][col] is safe
    static boolean isSafe(int[][] board, int row, int col, int n) {
        // Check horizontal (same row)
        for (int j = 0; j < col; j++) {
            if (board[row][j] == 1)
                return false;
        }

        // Check vertical (same column)
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1)
                return false;
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1)
                return false;
        }

        return true;
    }

    // Recursive function to solve the N-Queens problem
    static boolean solveNQueens(int[][] board, int row, int n) {
        if (row == n) {
            printBoard(board, n);
            return true;  // Change to false to find all solutions
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 1;
                if (solveNQueens(board, row + 1, n))
                    return true;  // Return here to stop at first solution
                board[row][col] = 0;  // Backtrack
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int n = 8; // Size of the board (N)
        int[][] board = new int[n][n];

        if (!solveNQueens(board, 0, n)) {
            System.out.println("No solution exists.");
        }
    }
}
