package algorithms;

/**
 * Implements the Boyer-Moore Majority Vote Algorithm.
 * Finds the element that appears more than n/2 times in an array (if any).
 */
public class BoyerMoore {

    /**
     * Finds the majority element in the array.
     * @param nums input integer array
     * @return the majority element, or -1 if none exists
     */
    public static int findMajority(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1; // handle invalid input
        }

        int candidate = 0, count = 0;

        // Step 1: Find candidate
        for (int num : nums) {
            if (count == 0) candidate = num;
            count += (num == candidate) ? 1 : -1;
        }

        // Step 2: Verify candidate
        count = 0;
        for (int num : nums) if (num == candidate) count++;
        return (count > nums.length / 2) ? candidate : -1;
    }
}
