class Solution {
    private void revArray(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;

        // Reverse the whole array
        revArray(nums, 0, n - 1);

        // Reverse the first k elements
        revArray(nums, 0, k - 1);

        // Reverse the remaining elements
        revArray(nums, k, n - 1);
    }
}