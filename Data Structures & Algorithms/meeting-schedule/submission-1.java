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
    public boolean canAttendMeetings(List<Interval> intervals) {
        // sort based on start time
        Collections.sort(intervals, (Interval a, Interval b) -> a.start - b.start);

        for (int i = 0; i < intervals.size() - 1; i++) {
            // end > start of next meeting, means conflict
            if (intervals.get(i).end > intervals.get(i + 1).start)
                return false;
        }
        return true;
    }
}
