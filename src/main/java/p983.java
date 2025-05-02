import java.util.Arrays;

public class p983 {

    public int mincostTickets(int[] days, int[] costs) {
        int[] cache = new int[days.length + 1];
        Arrays.fill(cache, -1);
        return solve(0, days, costs, cache);
    }

    private int solve(int idx, int[] days, int[] costs, int[] cache) {
        if (idx >= days.length) {
            return 0;
        }
        if (cache[idx] != -1) {
            return cache[idx];
        }
        int a = costs[0] + solve(idx + 1, days, costs, cache);
        int b = costs[1] + solve(findIdx(idx, days, 7), days, costs, cache);
        int c = costs[2] + solve(findIdx(idx, days, 30), days, costs, cache);
        int res = Math.min(Math.min(a, b), c);
        cache[idx] = res;
        return cache[idx];
    }

    private int findIdx(int idx, int[] days, int passDays) {
        int startDay = days[idx];
        int endDay = days[idx] + passDays - 1;
        for (int i = idx + 1; i < days.length; i++) {
            if (days[i] > endDay) {
                return i;
            }
        }
        return days.length + 1;
    }
}
