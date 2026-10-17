class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();

        int i =0, j = 0,maxLen=0;
        while(j < s.length()){
            char ch = s.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);

            while(map.size() > k){
                 ch = s.charAt(i);
                 map.put(ch,map.getOrDefault(ch,0)-1);
                 if(map.get(ch) == 0) map.remove(ch);
                 i++;
            }

            maxLen = Math.max(maxLen,j-i+1);
            j++;
        }
        return maxLen;
    }
}
