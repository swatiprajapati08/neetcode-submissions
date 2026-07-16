class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && DFS(board, i, j, word, 0))
                    return true;
            }
        }
        return false;
    }

    boolean DFS(char[][] board, int i, int j, String word, int idx) {
        if (idx == word.length())
            return true;

        if (idx > word.length() || i >= board.length || i < 0 || j >= board[0].length || j < 0
            || board[i][j] != word.charAt(idx))
            return false;

        char visited = board[i][j];
        board[i][j] = '-';
        // explore all the path, if any ans found give that ans
        boolean found = DFS(board, i + 1, j, word, idx + 1) || DFS(board, i - 1, j, word, idx + 1)
            || DFS(board, i, j + 1, word, idx + 1) || DFS(board, i, j - 1, word, idx + 1);

        board[i][j] = visited; // remove from visited so that it can be explored from other path
        return found;
    }
}
