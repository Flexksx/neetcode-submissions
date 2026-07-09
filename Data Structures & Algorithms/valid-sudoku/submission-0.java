class Solution {
    private static final int BOARD_SIZE = 9;
    private static final char EMPTY_SQUARE = '.';
    private static final char CHAR_TO_INT_INDEX_SUBTRACTOR = '1';

    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowChecks = new boolean[BOARD_SIZE][BOARD_SIZE];
        boolean[][] colChecks = new boolean[BOARD_SIZE][BOARD_SIZE];
        boolean[][] boxChecks = new boolean[BOARD_SIZE][BOARD_SIZE];

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                int currentValue = board[i][j];
                if (currentValue == EMPTY_SQUARE) {
                    continue;
                }

                int numberIndex = currentValue - CHAR_TO_INT_INDEX_SUBTRACTOR;

                if (rowChecks[i][numberIndex]) {
                    return false;
                } else {
                    rowChecks[i][numberIndex] = true;
                }

                if (colChecks[j][numberIndex]) {
                    return false;
                } else {
                    colChecks[j][numberIndex] = true;
                }

                int boxIndex = (j / 3) * 3 + (i / 3);
                if (boxChecks[boxIndex][numberIndex]) {
                    return false;
                } else {
                    boxChecks[boxIndex][numberIndex] = true;
                }
            }
        }

        return true;
    }
}
