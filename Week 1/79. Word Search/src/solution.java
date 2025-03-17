class Solution {
    private char[][] board;                                        // Stores the 2D board of characters
    private String word;                                           // Stores the word to search for
    private boolean[][] visited;                                   // Keeps track of visited cells
    private int[][] directions = { {-1, 0}, {0, -1}, {1, 0}, {0, 1} }; // Possible directions to move in the board

    public boolean exist(char[][] board, String word) {
        this.board = board;                                        // Initialize the board
        this.word = word;                                          // Initialize the word
        visited = new boolean[board.length][board[0].length];     // Initialize the visited array

        for (int i = 0; i < board.length; i++) {                  // Iterate over each cell in the board
            for (int j = 0; j < board[0].length; j++) {
                if (exist(i, j, 0)) {                             // Start searching from the current cell
                    return true;                                   // If the word is found, return true
                }
            }
        }
        return false;                                              // If the word is not found, return false
    }

    private boolean exist(int i, int j, int matchIndex) {
        if (matchIndex == word.length()) {                         // If the entire word is matched
            return true;
        } else if (i < 0 || i == board.length || j < 0 || j == board[0].length || visited[i][j] || board[i][j] != word.charAt(matchIndex)) {
            return false;                                         // If the current cell is invalid or doesn't match the word
        } else {
            visited[i][j] = true;                                 // Mark the current cell as visited
            for (int[] direction : directions) {                  // Iterate over all possible directions
                if (exist(i + direction[0], j + direction[1], matchIndex + 1)) {
                    return true;                                 // Recursively search in the next direction
                }
            }
            visited[i][j] = false;                               // Backtrack: unmark the current cell
            return false;                                         // If no path is found, return false
        }
    }
}