class Solution {
    public int findDuplicate(int[] nums) {
        int j = 0;
        while (j < nums.length) {
            if (nums[j] == j + 1) {
                j++;
            } else {
                // wrong position swap
                int curr = nums[j];
                if (nums[j] == nums[curr - 1])
                    return nums[j];
                nums[j] = nums[curr - 1];
                nums[curr - 1] = curr;
            }
        }
        return -1;
    }
}
