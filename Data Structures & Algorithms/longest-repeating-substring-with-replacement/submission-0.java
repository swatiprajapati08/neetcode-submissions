class Solution {
    public int characterReplacement(String s, int k) {
        // valid string maxLen
        HashMap<Character, Integer> hm = new HashMap<>();
        int i = 0, j = 0, maxLen = 0, maxCharFreq = 0;

        while (j < s.length()) {
            char ch = s.charAt(j);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);

            maxCharFreq = Math.max(maxCharFreq, hm.get(ch));
            /*
            len = (j - i + 1)
            currMax = maxCharFreq
            i can replace k, if more than k then invalid
            */
            while ((j - i + 1) - maxCharFreq > k) {
                ch = s.charAt(i);
                hm.put(ch, hm.getOrDefault(ch, 0) - 1);
                i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }
        return maxLen;
    }
}
