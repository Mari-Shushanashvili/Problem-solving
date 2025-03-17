import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<Integer>> allCombinations = new ArrayList<>(); // Stores all valid combinations
    private List<Integer> currentCombination = new ArrayList<>();   // Stores the current combination being constructed
    private int[] candidates;                                       // Stores the input array

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;                               // Initialize the input array
        findCombinationSums(0, target);                            // Start finding combinations
        return allCombinations;                                    // Return all valid combinations
    }

    private void findCombinationSums(int index, int target) {
        if (index == candidates.length) {                          // If we've considered all elements
            if (target == 0) {                                     // If the target is reached
                allCombinations.add(new ArrayList<>(currentCombination)); // Add the current combination to allCombinations
            }
        } else {
            if (target - candidates[index] >= 0) {                // If the current element can be included without exceeding the target
                currentCombination.add(candidates[index]);         // Include the current element
                findCombinationSums(index, target - candidates[index]); // Recursively find combinations with the updated target
                currentCombination.remove(currentCombination.size() - 1); // Backtrack: remove the last element
            }
            findCombinationSums(index + 1, target);               // Exclude the current element and move to the next
        }
    }
}