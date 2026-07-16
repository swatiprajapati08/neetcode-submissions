class Solution {
    public boolean hasDuplicate(int[] nums) {
        // using hashSet

        HashSet<Integer> hs = new HashSet<>();
        for(int i:nums){
            if(hs.contains(i)) return true;
            hs.add(i);
        }
        return false;
    }
}