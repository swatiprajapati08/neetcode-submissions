class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i : nums) hm.put(i, hm.getOrDefault(i, 0) + 1);

        ArrayList<Integer> arr = new ArrayList<Integer>();

// sort the PQ with least freq
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> hm.get(a) - hm.get(b));
        int[] kFreq = new int[k];
        int idx = 0;

        for (int i : hm.keySet()) {
            pq.add(i);
            if (pq.size() > k)
                pq.poll();
        }
        while (!pq.isEmpty()) kFreq[idx++] = pq.poll();

        return kFreq;
    }
}
