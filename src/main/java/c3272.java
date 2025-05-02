import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class c3272 {
    // 첫 풀이: 경우의 수 구하는거 gpt 도움 받음
    public long countGoodIntegers(int n, int k) {
        Set<String> st = isGoodNumber(n, k);
        return answer(st);
    }

    // 정렬해서 Set에 저장
    private Set<String> isGoodNumber(int n, int k) {
        Set<String> st = new HashSet<>();
        long multiple = (long) Math.pow(10, n / 2);
        long prefixStart = (long) Math.pow(10, n / 2 - 1);
        long prefixEnd = (long) Math.pow(10, n / 2) - 1;
        long number = 0;
        long reverse = 0;
        if (n % 2 == 1) {
            for (int i = 0; i <= 9; i++) {
                for (long j = prefixStart; j <= prefixEnd; j++) {
                    number = j;
                    reverse = Integer.parseInt(new StringBuilder(String.valueOf(j)).reverse().toString());
                    number = number * 10 + i;
                    number = number * multiple;
                    number += reverse;
                    if (number % k == 0) {
                        char[] chars = String.valueOf(number).toCharArray();
                        Arrays.sort(chars);
                        st.add(new String(chars));
                    }
                }
            }
        } else {
            for (long j = prefixStart; j <= prefixEnd; j++) {
                number = j;
                reverse = Integer.parseInt(new StringBuilder(String.valueOf(j)).reverse().toString());
                number = number * multiple;
                number += reverse;
                if (number % k == 0) {
                    char[] chars = String.valueOf(number).toCharArray();
                    Arrays.sort(chars);
                    st.add(new String(chars));
                }
            }
        }
        return st;
    }

    private long answer(Set<String> st) {
        int[] factorial = new int[11];
        factorial[0] = 1;
        factorial[1] = 1;
        for (int i = 2; i <= 10; i++) {
            factorial[i] = i * factorial[i - 1];
        }
        long ret = 0L;
        for (String s : st) {
            int[] cnt = digitCount(s);
            int len = s.length();
            long tmp = factorial[len];
            for (int i = 0; i <= 9; i++) {
                tmp /= factorial[cnt[i]];
            }
            ret += tmp;
            if (cnt[0] > 0) {
                long tmp0 = factorial[len - 1];
                cnt[0]--;
                for (int j = 0; j <= 9; j++) {
                    tmp0 /= factorial[cnt[j]];
                }
                ret -= tmp0;
            }
        }
        return ret;
    }

    private int[] digitCount(String s) {
        int[] ret = new int[10];
        for (int i = 0; i < s.length(); i++) {
            ret[s.charAt(i) - '0']++;
        }
        return ret;
    }
}
