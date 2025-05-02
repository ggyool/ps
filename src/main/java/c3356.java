import java.util.HashMap;
import java.util.Map;

public class c3356 {

    // 아래 아이디어로 풀어보
    public int minZeroArray(int[] nums, int[][] queries) {
        int k = 0;
        int[] diff = new int[nums.length + 1];
        int tmp = 0;
        for (int i=0; i<nums.length; i++) {
            while (true) {
                if (nums[i] + tmp + diff[i] <= 0) {
                    break;
                }
                if (k == queries.length) {
                    return -1;
                }
                int from = queries[k][0];
                int to = queries[k][1];
                int val = queries[k][2];
                if (i <= to) {
                    diff[Math.max(from, i)] -= val;
                    diff[to+1] += val;
                }
                k++;
            }
            tmp += diff[i];
        }
        return k;
    }

    public int minZeroArray2(int[] nums, int[][] queries) {
        int n = nums.length, sum = 0, k = 0;
        int[] differenceArray = new int[n + 1];

        // Iterate through nums
        for (int index = 0; index < n; index++) {
            // Iterate through queries while current index of nums cannot equal zero
            while (sum + differenceArray[index] < nums[index]) {
                k++;

                // Zero array isn't formed after all queries are processed
                if (k > queries.length) {
                    return -1;
                }
                int left = queries[k - 1][0], right = queries[k - 1][1], val =
                        queries[k - 1][2];

                // Process start and end of range
                if (right >= index) {
                    differenceArray[Math.max(left, index)] += val;
                    differenceArray[right + 1] -= val;
                }
            }
            // Update prefix sum at current index
            sum += differenceArray[index];
        }
        return k;
    }


    // 첫 풀이: 시간 오래걸리고 pass
    // editorial 보니 이분탐색 풀이랑 라인스윕이 있는데
    // 이분 탐색은 원래 오래걸림 주어진 코드보다 아래 코드가 200ms 정도 빠름
//    public int minZeroArray(int[] nums, int[][] queries) {
//        int left = 0;
//        int right = queries.length;
//        int ans = -1;
//        while (left <= right) {
//            int mid = (right - left) / 2 + left;
//            if (isAble(nums, queries, mid)) {
//                ans = mid;
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return ans;
//    }
//
//    private boolean isAble(int[] nums, int[][] queries, int k) {
//        Map<Integer, Integer> change = new HashMap<>();
//        for (int i = 0; i < k; i++) {
//            int from = queries[i][0];
//            int to = queries[i][1];
//            int val = queries[i][2];
//            change.put(from, change.getOrDefault(from, 0) - val);
//            change.put(to + 1, change.getOrDefault(to + 1, 0) + val);
//        }
//        int tmp = 0;
//        for (int i = 0; i < nums.length; i++) {
//            tmp += change.getOrDefault(i, 0);
//            if (nums[i] + tmp > 0) {
//                return false;
//            }
//        }
//        return true;
//    }
}
