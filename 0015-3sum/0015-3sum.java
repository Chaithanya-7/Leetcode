class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for(int i=0;i<n;i++){
            //skip duplicates
            if(i > 0 && nums[i]==nums[i-1]) continue;

            //two pointer approach
            int j = i+1;
            int k = n-1;

            while(j<k){//till j crosses k
                int sum = nums[i]+nums[j]+nums[k];

                if(sum<0){//lesser than zero move j
                    j++;
                }else if(sum > 0){//greater than 0 than move k backward
                    k--;
                }else{
                    //found a triplet
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    ans.add(temp);

                    //skip duplicates
                    j++;
                    k--;

                    while(j<k && nums[j]==nums[j-1]) j++;//till j crosses k or same element if j crosses k then done dont do further

                    while(j<k && nums[k]==nums[k+1]) k--;
                }
            }
        }
        return ans;
        }
}