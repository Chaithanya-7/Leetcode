class Solution {
    public int minimumSwaps(int[] nums) {
        int nonZeroCount = 0;

        // Count non-zero elements
        for (int num : nums) {
            if (num != 0) {
                nonZeroCount++;
            }
        }

        int swaps = 0;

        // Count zeros in the first nonZeroCount positions
        for (int i = 0; i < nonZeroCount; i++) {
            if (nums[i] == 0) {
                swaps++;
            }
        }

        return swaps;
    }
}