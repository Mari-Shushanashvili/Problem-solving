import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<String> allParentheses = new ArrayList<>();         // Stores all valid combinations of parentheses
    private StringBuilder currentParentheses = new StringBuilder();  // Builds the current combination of parentheses

    public List<String> generateParenthesis(int n) {
        generateParentheses(0, n);                                  // Start generating combinations
        return allParentheses;                                      // Return all valid combinations
    }

    private void generateParentheses(int open, int toOpen) {
        if (open == 0 && toOpen == 0) {                             // If no more parentheses to open or close
            allParentheses.add(currentParentheses.toString());      // Add the current combination to allParentheses
            return;
        }
        if (open > 0) {                                             // If there are open parentheses to close
            currentParentheses.append(')');                         // Close a parenthesis
            generateParentheses(open - 1, toOpen);                 // Recursively generate combinations
            currentParentheses.deleteCharAt(currentParentheses.length() - 1); // Backtrack: remove the last parenthesis
        }
        if (toOpen > 0) {                                           // If there are parentheses to open
            currentParentheses.append('(');                         // Open a parenthesis
            generateParentheses(open + 1, toOpen - 1);             // Recursively generate combinations
            currentParentheses.deleteCharAt(currentParentheses.length() - 1); // Backtrack: remove the last parenthesis
        }
    }
}
