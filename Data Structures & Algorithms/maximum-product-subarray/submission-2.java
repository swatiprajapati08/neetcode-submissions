class Solution {
    public int maxProduct(int[] nums) {
        int currMax = 1, currMin = 1, res = nums[0];

        for(int n:nums){
            int temp = n * currMax;
            currMax = Math.max(n,(Math.max(n*currMax,n*currMin)));
            currMin = Math.min(n, Math.min(temp,n*currMin));
            // why temp bcz n * currMax it will give me wrong ans as currMax is already modified at line 9

            res = Math.max(res,currMax);

        }
        return res;
    }
}
