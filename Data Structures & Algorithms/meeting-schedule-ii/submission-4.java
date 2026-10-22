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

        intervals.sort((a, b) -> a.start - b.start);

        // sort based on end so we know which meeting will end soon and can accomdate that room
        // PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.end - b.end);

        // we can use directly in interval
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Interval i : intervals) {
            if (!pq.isEmpty() && pq.peek() <= i.start)
                pq.poll();
            pq.offer(i.end);
        }
        return pq.size();
    }
}
