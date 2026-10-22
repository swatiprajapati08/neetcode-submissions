/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        // sort based on start time

        Collections.sort(intervals, (a, b) -> a.start - b.start);


// sort based on end so we know which meeting will end soon and can accomdate that room
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.end - b.end);
        for (Interval i : intervals) {
            if (pq.isEmpty()) {
                pq.add(i);
                continue;
            }

            Interval top = pq.peek();

            // check if conflict
            if (top.end <= i.start) {
                pq.poll();
            }
            pq.add(i);
        }
        return pq.size();
    }
}
