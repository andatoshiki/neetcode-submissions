class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> set = new HashSet<>();

        // horizontal traversal dup check
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ((Character.isDigit(board[i][j]) && set.contains(board[i][j]))) {
                    return false;
                }
                else {
                    set.add(board[i][j]);
                }
            }
            set.clear();     
        }

        // vertical traversal dup check
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ((Character.isDigit(board[j][i]) && set.contains(board[j][i]))) {
                    return false;
                }
                else {
                    set.add(board[j][i]);
                }
            }
            set.clear();   
        }

        // square check
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (i % 3 == 0 && j % 3 == 0) {
                    for (int k = i; k < i + 3; k++) {
                        for (int l = j; l < j + 3; l++) {
                            if ((Character.isDigit(board[k][l]) && set.contains(board[k][l]))) {
                                return false;
                            }
                            else {
                                set.add(board[k][l]);
                            }
                        }
                    }
                    set.clear();
                }
                else {
                    continue;
                }
            }
        }

        return true;
    }
}
