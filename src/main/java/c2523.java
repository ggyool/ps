import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class c2523 {
    public int[] closestPrimes(int left, int right) {
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        for (int i = 2; i * i <= right; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= right; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        List<Integer> lst = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isPrime[i]) {
                lst.add(i);
            }
        }
        int minSub = Integer.MAX_VALUE;
        int[] ans = new int[]{0, 0};
        for (int i = 1; i < lst.size(); i++) {
            int a = lst.get(i - 1);
            int b = lst.get(i);
            if (b - a < minSub) {
                minSub = b - a;
                ans[0] = a;
                ans[1] = b;
            }
        }
        if (lst.size() <= 1) {
            return new int[]{-1, -1};
        }
        return ans;
    }
}
