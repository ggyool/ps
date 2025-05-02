import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class c2780 {

    // editorial 에 2가지 풀이가 있음
    // 1. 해시맵 2개로 순회하며 왼쪽맵은 1더하고 오른쪽 맵은 1뺴고
    // 2. Boyer-Moore Majority Voting Algorithm 으로 공간 필요 없이 dominant 숫자 구하는 방법

    // 풀고나니, total 구해놓은거 쓰면 psum 필요없음
    // 첫 풀이
    public int minimumIndex(List<Integer> nums) {
        int dm = dominantNum(nums);
        int[] psum = new int[nums.size()];
        if (nums.get(0) == dm) {
            psum[0] = 1;
        }
        for (int i = 1; i < nums.size(); i++) {
            psum[i] = psum[i - 1];
            if (nums.get(i) == dm) {
                psum[i]++;
            }
        }

        for (int i = 0; i < nums.size() - 1; i++) {
            int leftCnt = psum[i];
            int leftLen = i + 1;
            int rightCnt = psum[nums.size() - 1] - psum[i];
            int rightLen = nums.size() - 1 - i;

            if (2 * leftCnt > leftLen && 2 * rightCnt > rightLen) {
                return i;
            }
        }
        return -1;
    }

    private int dominantNum(List<Integer> nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            int n = nums.get(i);
            cnt.put(n, cnt.getOrDefault(n, 0) + 1);
        }
        int maxCnt = 0;
        int dm = 0;
        for (Map.Entry<Integer, Integer> ent : cnt.entrySet()) {
            int k = ent.getKey();
            int v = ent.getValue();
            if (maxCnt < v) {
                maxCnt = v;
                dm = k;
            }
        }
        return dm;
    }
}
