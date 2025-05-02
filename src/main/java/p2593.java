import java.util.Comparator;
import java.util.PriorityQueue;

public class p2593 {
    public long findScore(int[] nums) {
        // 숫자, 인덱스 순으로 정렬해서 하나씩 빼버리기
        PriorityQueue<Info> pq = new PriorityQueue<>(
                Comparator.comparing(Info::num).thenComparing(Info::index)
        );
        boolean[] isMarked = new boolean[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            pq.add(new Info(nums[i], i));
        }
        long ans = 0;
        while (!pq.isEmpty()) {
            Info cur = pq.poll();
            if (isMarked[cur.index]) continue;
            ans += cur.num;
            isMarked[cur.index] = true;
            if (cur.index + 1 != nums.length) {
                isMarked[cur.index + 1] = true;
            }
            if (cur.index - 1 != -1) {
                isMarked[cur.index - 1] = true;
            }
        }
        return ans;
    }

    record Info(int num, int index) {
    }
}
