public class c2226 {

    public int maximumCandies(int[] candies, long k) {
        int left = 0;
        int right = 10_000_000;
        while (left < right) {
            // +1을 하면 left도 바로 return 할 수 있음
            int mid = (right - left + 1) / 2 + left;
            if (isAble(candies, k, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    // 첫 풀이
//    public int maximumCandies(int[] candies, long k) {
//        int left = 1;
//        int right = 10_000_000;
//        int ans = 0;
//        while (left <= right) {
//            int mid = (right - left) / 2 + left;
//            if (isAble(candies, k, mid)) {
//                ans = mid;
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//        }
//        return ans;
//    }

    // mid개로 k개 이상의 캔디를 만드는게 가능한지
    private boolean isAble(int[] candies, long k, int mid) {
        long cnt = 0;
        for (int i = 0; i < candies.length; i++) {
            cnt += (candies[i] / mid);
        }
        return cnt >= k;
    }
}
