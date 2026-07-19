// class Solution {
//     private int LargestSum(int[] nums,int ssum){
//         int n = nums.length;
//         int ssum = 1;
//         int arrayCnt = 0;

//         for (int i = 0; i < n; i++) {
//             if (arrayCnt + nums[i] <= ssum) {
//                 // Add pages to current student
//                 arrayCnt += nums[i];
//             } else {
//                 // Add pages to next student
//                 ssum++;
//                 arrayCnt = nums[i];
//             }
//         }
//         return ssum;
//     }
//     public int splitArray(int[] nums, int k) {
//         int n = nums.length;
//         if(k>n) return -1;
//         int low = Integer.MIN_VALUE;
//         int high = 0;
//         for(int i=0;i<n;i++){
//             low = Math.max(low,nums[i]);
//             high = high+nums[i];
//         }
//         while(low<=high){
//             int mid=(low+high)/2;
//             int array=LargestSum(nums,mid);
//             if(array > k){
//                 low = mid+1;
//             }
//             else{
//                 high = mid-1;
//             }
//         }
//         return low;
//     }
// }
class Solution {

    private int LargestSum(int[] nums, int maxSum) {
        int n = nums.length;

        int subarrayCount = 1;
        int currentSum = 0;

        for (int i = 0; i < n; i++) {

            if (currentSum + nums[i] <= maxSum) {
                currentSum += nums[i];
            } else {
                subarrayCount++;
                currentSum = nums[i];
            }
        }

        return subarrayCount;
    }

    public int splitArray(int[] nums, int k) {
        int n = nums.length;

        if (k > n) {
            return -1;
        }

        int low = Integer.MIN_VALUE;
        int high = 0;

        for (int i = 0; i < n; i++) {
            low = Math.max(low, nums[i]);
            high = high + nums[i];
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int array = LargestSum(nums, mid);

            if (array > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}