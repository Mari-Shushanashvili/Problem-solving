import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<Integer>> allSubsets = new ArrayList<>(); // Stores all subsets
    private List<Integer> currentSubset = new ArrayList<>();   // Stores the current subset being constructed
    private int[] numbers;                                     // Stores the input array

    public List<List<Integer>> subsets(int[] nums) {
        numbers = nums;                                        // Initialize the input array
        generateAllSubsets(0);                                 // Start generating subsets from index 0
        return allSubsets;                                     // Return all subsets
    }

    private void generateAllSubsets(int index) {
        if (index == numbers.length) {                         // If we've considered all elements
            allSubsets.add(new ArrayList<>(currentSubset));    // Add the current subset to allSubsets
        } else {
            generateAllSubsets(index + 1);                    // Exclude the current element and move to the next
            currentSubset.add(numbers[index]);                 // Include the current element
            generateAllSubsets(index + 1);                    // Move to the next element
            currentSubset.remove(currentSubset.size() - 1);    // Backtrack: remove the last element
        }
    }
}