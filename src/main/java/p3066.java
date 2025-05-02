import java.util.PriorityQueue;

public class p3066 {

    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.add((long) nums[i]);
        }
        int cnt = 0;
        while (true) {
            if (pq.size() <= 1) break;
            long a = pq.poll();
            long b = pq.poll();
            if (a >= k) break;

            pq.add(2L * Math.min(a, b) + Math.max(a, b));
            cnt++;
        }
        return cnt;
    }
}
