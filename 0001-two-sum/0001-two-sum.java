class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> mpp = new HashMap<>();
        int n = nums.length;

        for(int i =0;i<n;i++){
            int num=nums[i];

            int moreneeded = target - num;
            if(mpp.containsKey(moreneeded)){
                return new int[]{mpp.get(moreneeded),i};
            }
            mpp.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}