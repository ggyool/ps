public class p689 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 6, 7, 5, 1};
        int[] res = new p689().maxSumOfThreeSubarrays(nums, 2);
        System.out.println(res);
    }

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int len = nums.length;
        int[] sum = new int[len];
        int[] leftMax = new int[len];
        int[] leftMaxIdx = new int[len];
        int[] rightMax = new int[len];
        int[] rightMaxIdx = new int[len];
        for (int i = 0; i < k; i++) {
            sum[0] += nums[i];
        }
        for (int i = 1; i <= len - k; i++) {
            sum[i] = sum[i - 1] - nums[i - 1] + nums[i + k - 1];
        }
        leftMax[0] = sum[0];
        leftMaxIdx[0] = 0;
        for (int i = 1; i <= len - k; i++) {
            if (sum[i] > leftMax[i - 1]) {
                leftMax[i] = sum[i];
                leftMaxIdx[i] = i;
            } else {
                leftMax[i] = leftMax[i - 1];
                leftMaxIdx[i] = leftMaxIdx[i - 1];
            }
        }
        rightMax[len - k] = sum[len - k];
        rightMaxIdx[len - k] = len - k;
        for (int i = len - k - 1; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], sum[i]);
            if (sum[i] >= rightMax[i + 1]) {
                rightMax[i] = sum[i];
                rightMaxIdx[i] = i;
            } else {
                rightMax[i] = rightMax[i + 1];
                rightMaxIdx[i] = rightMaxIdx[i + 1];
            }
        }

        int ans = 0;
        int a = 0, b = 0, c = 0;
        for (int i = k; i < len - k; i++) {
            if (ans < leftMax[i - k] + sum[i] + rightMax[i + k]) {
                ans = leftMax[i - k] + sum[i] + rightMax[i + k];
                a = leftMaxIdx[i - k];
                b = i;
                c = rightMaxIdx[i + k];
            }
        }
        return new int[]{
                a, b, c
        };
    }
}

//public class p689 {
//
//    // 첫 풀이 - 시간 초과
//    public static void main(String[] args) {
//        int[] nums = {1, 2, 1, 2, 6, 7, 5, 1};
//        new p689().maxSumOfThreeSubarrays(nums, 2);
//    }
//
//    int ksum[];
//    int dp[][];
//    Map<Key, List<Integer>> indices = new HashMap<>();
//
//    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
//        // 조각수, 인덱스로 탑다운
//        ksum = new int[nums.length];
//        dp = new int[3][nums.length];
//        for (int i = 0; i < k; i++) {
//            ksum[0] += nums[i];
//        }
//        for (int i = k; i < nums.length; i++) {
//            ksum[i - k + 1] = ksum[i - k] - nums[i - k] + nums[i];
//        }
//        dfs(0, 0, nums.length, k);
//        List<Integer> ret = indices.get(new Key(0, 0));
//        Collections.sort(ret);
//
//        int[] ans = new int[ret.size()];
//        for (int i = 0; i < ret.size(); i++) {
//            ans[i] = ret.get(i);
//        }
//        return ans;
//    }
//
//    int dfs(int piece, int idx, int len, int k) {
//        if (piece >= 3 || idx >= len) {
//            return 0;
//        }
//        if (dp[piece][idx] != 0) {
//            return dp[piece][idx];
//        }
//
//        // idx 를 선택하는 경우
//        int a = ksum[idx] + dfs(piece + 1, idx + k, len, k);
//        // idx 를 선택하지 않는 경우
//        int b = dfs(piece, idx + 1, len, k);
//
//        if (a < b) {
//            dp[piece][idx] = b;
//            List<Integer> tmp = getIndices(piece, idx + 1, len);
//            indices.put(new Key(piece, idx), tmp);
//        } else {
//            dp[piece][idx] = a;
//            List<Integer> tmp = new ArrayList<>(getIndices(piece + 1, idx + k, len));
//            tmp.add(idx);
//            indices.put(new Key(piece, idx), tmp);
//        }
//        return dp[piece][idx];
//    }
//
//    private List<Integer> getIndices(int piece, int idx, int len) {
//        if (piece >= 3 || idx >= len) {
//            return new ArrayList<>();
//        }
//        return indices.get(new Key(piece, idx));
//    }
//
//    private record Key(int piece, int idx) {
//    }
//}
