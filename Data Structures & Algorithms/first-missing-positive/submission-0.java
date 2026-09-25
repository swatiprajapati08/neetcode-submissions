class Solution {
    public int firstMissingPositive(int[] nums) {
        // using counting sort

        HashSet<Integer> hs = new HashSet<>();

        for(int i:nums)
        hs.add(i);

        for(int i =1;i<Integer.MAX_VALUE-1;i++){
            if(!hs.contains(i)){
                return i;
            }
        }
return -1;

    }
}