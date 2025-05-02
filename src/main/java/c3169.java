import java.util.*;

public class c3169 {

    // 정렬 방식을 이용한 더 심플한 코드
    public int countDays(int days, int[][] meetings) {
        int ans = 0;
        int lastEnd = 0;
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i=0; i<meetings.length; i++) {
            int start = meetings[i][0];
            int end = meetings[i][1];
            if (lastEnd < start) {
                ans += start - lastEnd - 1;
            }
            lastEnd = Math.max(lastEnd, end);
        }
        ans += days - lastEnd;
        return ans;
    }

    // 첫 풀이, 100ms 정도로 빠르지 않음 (O(n)풀이가 있음)
//    public int countDays(int days, int[][] meetings) {
//        // days 에서 미팅날 구해서 빼자
//        // 1이 되는 날짜부터 0이 되는 날짜 -1 까지 더하면 되지 않을까
//        HashMap<Integer, Integer> mp = new HashMap<>();
//        for (int i=0; i<meetings.length; i++) {
//            int a = meetings[i][0];
//            int b = meetings[i][1];
//            mp.compute(a, (k,v)->{
//                return v == null ? 1 : v+1;
//            });
//            mp.compute(b+1, (k,v)->{
//                return v == null ? -1 : v-1;
//            });
//        }
//        List<Info> lst = new ArrayList<>();
//        for (Map.Entry<Integer, Integer> ent : mp.entrySet()) {
//            lst.add(new Info(ent.getKey(), ent.getValue()));
//        }
//        Collections.sort(lst);
//
//        int meetDays = 0;
//        int cnt = 0;
//        int start = 0;
//        for (int i=0; i<lst.size(); i++) {
//            Info info = lst.get(i);
//            if (cnt == 0 && info.value >= 1) {
//                start = info.day;
//            } else if (cnt + info.value == 0) {
//                meetDays += (info.day - start);
//            }
//            cnt += info.value;
//        }
//        return days - meetDays;
//    }
//
//    record Info(int day, int value) implements Comparable<Info> {
//        @Override
//        public int compareTo(Info o) {
//            // value 내림치순
//            if (day == o.day) {
//                return o.value - value;
//            }
//            // day 오름차순
//            return day - o.day;
//        }
//    }
}
