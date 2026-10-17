class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> hm = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();
        for (char c : s1.toCharArray())
         hm.put(c, hm.getOrDefault(c, 0) + 1);

        int i = 0, j = 0;

        while (j < s2.length()) {
            char ch = s2.charAt(j);
            hm2.put(ch, hm2.getOrDefault(ch, 0) + 1);
            if (j - i + 1 > s1.length()) {
                ch = s2.charAt(i);
                hm2.put(ch, hm2.getOrDefault(ch, 0) - 1);
                if (hm2.get(ch) == 0)
                    hm2.remove(ch);
                i++;
            }

            if (j - i + 1 == s1.length() && hm2.equals(hm))
                return true;
            j++;
        }
        return false;
    }
}
