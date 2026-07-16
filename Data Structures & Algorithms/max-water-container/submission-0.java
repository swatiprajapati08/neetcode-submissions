class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxWater = 0;
        while (left < right) {
            int minH = Math.min(height[right], height[left]);
            int dis = right - left;
            maxWater = Math.max(maxWater, minH * dis);

            // take a decision which pointer to move, based on which are used as part of ans.
            if (minH == height[left])
                left++;
            else
                right--;
        }
        return maxWater;
    }
}
