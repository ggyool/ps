import java.util.Comparator;
import java.util.PriorityQueue;

public class p2558 {
    public long pickGifts(int[] gifts, int k) {
        var pq = new PriorityQueue<Long>(Comparator.comparing(Long::longValue).reversed());
        for (int gift : gifts) {
            pq.add((long) gift);
        }

        for (int i = 0; i < k; i++) {
            pq.add((long) Math.floor(Math.sqrt(pq.poll())));
        }
        long ans = 0;
        while (!pq.isEmpty()) {
            ans += pq.poll();
        }
        return ans;
    }
}