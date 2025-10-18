import java.util.HashSet;

public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> cols = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                // Check row
                if (board[i][j] != '.') {
                    if (!rows.add(board[i][j])) return false;
                }

                // Check column
                if (board[j][i] != '.') {
                    if (!cols.add(board[j][i])) return false;
                }

                // Check 3x3 cube
                int rowIndex = 3 * (i / 3);
                int colIndex = 3 * (i % 3);
                char c = board[rowIndex + j / 3][colIndex + j % 3];
                if (c != '.') {
                    if (!cube.add(c)) return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(isValidSudoku(board)); // Output: true
    }
}
