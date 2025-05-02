import java.util.PriorityQueue;

public class p1792 {

    public static void main(String[] args) {
        int[][] classes = {
                {2, 4},
                {3, 9},
                {4, 5},
                {2, 10}
        };
        var ans = new p1792().maxAverageRatio(classes, 4);
        System.out.println(ans);
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        for (int[] c : classes) {
            pq.add(new Info(c[0], c[1]));
        }
        for (int i = 0; i < extraStudents; i++) {
            Info cur = pq.poll();
            pq.add(new Info(cur.pass + 1, cur.total + 1));
        }
        double sum = 0.0;
        while (!pq.isEmpty()) {
            Info cur = pq.poll();
            sum += (double) cur.pass / cur.total;
        }
        return sum / classes.length;
    }

    static class Info implements Comparable<Info> {

        public int pass;
        public int total;
        public double score;

        public Info(int pass, int total) {
            this.pass = pass;
            this.total = total;
            this.score = calcScore(pass, total);
        }

        @Override
        public int compareTo(Info o) {
            if (this.score < o.score) {
                return 1;
            }
            return -1;
        }

        private double calcScore(double pass, double total) {
            return ((pass + 1) / (total + 1)) - (pass / total);
        }
    }
}
