import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<Integer>> allPermutations = new ArrayList<>(); // Stores all permutations
    private int[] numbers;                                           // Stores the input array

    public List<List<Integer>> permute(int[] nums) {
        numbers = nums;                                              // Initialize the input array
        permute(0);                                                  // Start generating permutations from index 0
        return allPermutations;                                      // Return all permutations
    }

    private void permute(int permuteIndex) {
        if (permuteIndex == numbers.length) {                        // If we've considered all elements
            List<Integer> permutation = new ArrayList<>();          // Create a new permutation
            for (int number : numbers) {
                permutation.add(number);                             // Add each number to the permutation
            }
            allPermutations.add(permutation);                        // Add the permutation to allPermutations
        } else {
            for (int i = permuteIndex; i < numbers.length; i++) {    // Iterate over the array
                swap(permuteIndex, i);                               // Swap elements to generate permutations
                permute(permuteIndex + 1);                           // Recursively generate permutations
                swap(permuteIndex, i);                               // Backtrack: swap back to original state
            }
        }
    }

    private void swap(int i, int j) {                                // Helper method to swap elements
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}