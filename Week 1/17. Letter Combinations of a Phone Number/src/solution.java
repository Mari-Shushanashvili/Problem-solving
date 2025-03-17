import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Solution {
    private String digits;                                        // Stores the input string of digits
    private Map<Character, String> digitToLetters = Map.of(       // Maps each digit to its corresponding letters
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    private List<String> allCombinations = new ArrayList<>();    // Stores all valid combinations
    private StringBuilder currentCombination = new StringBuilder(); // Builds the current combination

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {                              // If the input string is empty
            return new ArrayList<>();                             // Return an empty list
        }
        this.digits = digits;                                    // Initialize the input string
        letterCombinations(0);                                   // Start generating combinations
        return allCombinations;                                 // Return all valid combinations
    }

    private void letterCombinations(int index) {
        if (index == digits.length()) {                          // If we've considered all digits
            allCombinations.add(currentCombination.toString());  // Add the current combination to allCombinations
        } else {
            String letters = digitToLetters.get(digits.charAt(index)); // Get the letters corresponding to the current digit
            for (int i = 0; i < letters.length(); i++) {        // Iterate over each letter
                currentCombination.append(letters.charAt(i));    // Add the current letter to the combination
                letterCombinations(index + 1);                  // Recursively generate combinations for the next digit
                currentCombination.deleteCharAt(currentCombination.length() - 1); // Backtrack: remove the last letter
            }
        }
    }
}