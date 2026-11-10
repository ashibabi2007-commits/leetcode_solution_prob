class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        
        // Step 1: Try starting the word search from every single cell on the board
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // If we find a valid path starting from (r, c), return true
                if (dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int r, int c, int index) {
        // Base Case 1: If index reaches the word's length, we successfully matched every letter!
        if (index == word.length()) {
            return true;
        }
        
        // Base Case 2: Check if out of bounds or if the current cell character doesn't match the target letter
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != word.charAt(index)) {
            return false;
        }
        
        // Step 2: Mark the current cell as visited by temporarily changing its character
        char temp = board[r][c];
        board[r][c] = '#';
        
        // Step 3: Explore all 4 possible directions (Down, Up, Right, Left) for the next letter
        boolean found = dfs(board, word, r + 1, c, index + 1) || // Down
                        dfs(board, word, r - 1, c, index + 1) || // Up
                        dfs(board, word, r, c + 1, index + 1) || // Right
                        dfs(board, word, r, c - 1, index + 1);   // Left
        
        // Step 4: Backtrack - restore the cell's original character so other paths can use it
        board[r][c] = temp;
        
        return found;
    }
}