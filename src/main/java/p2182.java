import java.util.LinkedList;
import java.util.PriorityQueue;

public class p2182 {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[(int) (s.charAt(i) - 'a')]++;
        }
        var pq = new PriorityQueue<Info>();
        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0) {
                pq.add(new Info((char) ('a' + i), arr[i]));
            }
        }

        Info tmp = null;
        var q = new LinkedList<Info>();
        var sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Info cur = pq.poll();
            if (tmp != null) {
                // cur.c 를 1번 넣는다.
                // 1보다 크면 다시 cnt를 1뺴고 pq에 넣는다.
                // tmp도 다시 넣고 null로 초기화한다.
                sb.append(cur.c);
                if (cur.cnt > 1) {
                    cur.cnt--;
                    pq.add(cur);
                }
                pq.add(tmp);
                tmp = null;
                continue;
            }
            if (cur.cnt > repeatLimit) {
                for (int i = 0; i < repeatLimit; i++) {
                    // cur.c를 repeatLimit 번 넣는다.
                    // cur 에서 repeatLimit 을 뺴고 tmp에 넣는다.
                    sb.append(cur.c);
                }
                cur.cnt -= repeatLimit;
                tmp = cur;
            } else {
                // cur.c를 cur.cnt 번 넣는다.
                for (int i = 0; i < cur.cnt; i++) {
                    sb.append(cur.c);
                }
            }
        }
        return sb.toString();
    }

    static class Info implements Comparable<Info> {
        char c;
        int cnt;

        public Info(char c, int cnt) {
            this.c = c;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Info o) {
            return o.c - c;
        }
    }
}
