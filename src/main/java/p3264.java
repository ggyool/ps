import java.util.PriorityQueue;

public class p3264 {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.add(new Info(nums[i], i));
        }

        for (int i = 0; i < k; i++) {
            Info cur = pq.poll();
            pq.add(new Info(cur.value * multiplier, cur.index));
            nums[cur.index] = nums[cur.index] * multiplier;
        }
        return nums;
    }

    static class Info implements Comparable<Info> {

        public int value;
        public int index;

        public Info(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Info o) {
            if (value == o.value) {
                return index - o.index;
            }
            return value - o.value;
        }
    }
}
