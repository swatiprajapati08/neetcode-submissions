class Solution {
    public int firstMissingPositive(int[] nums) {
        // counting sort

        // idx = arr[idx] + 1; sort it like thaat way

        int i = 0, len = nums.length;
        while (i < len) {
            if (nums[i] <= 0 || nums[i] > len || nums[i] == nums[nums[i] - 1]) {
                i++;
                continue;
            }
            int temp = nums[i];
            nums[i] = nums[nums[i] - 1];
            nums[temp - 1] = temp;
        }

        int res = 1;
        for (i = 0; i < len; i++) {
            if (res == nums[i]) {
                res++;
            }
        }
        return res;
    }
}