class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            /*
            if (!hm.containsKey(key)) {
                List<String> keys = new ArrayList<>();
                keys.add(s);
                hm.put(key, keys);
            } else {
                List<String> keys = hm.get(key);
                keys.add(s);
            }*/
            hm.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        for (String key : hm.keySet()) {
            result.add(hm.get(key));
        }
        return result;
    }
}
