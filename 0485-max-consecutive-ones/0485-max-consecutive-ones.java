class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int cnt =0;
        int maxi=0;

        for(int i=0;i<n;i++){
            if(nums[i]==1){
                cnt++;

                maxi = Math.max(maxi,cnt);//update the maximum of both if current cnt is gretaer than maxi than update
            }else{
                cnt =0;
            }
        }
        return maxi;
    }
}