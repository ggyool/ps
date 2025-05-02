public class c2401 {
    // editorial 코드
    public int longestNiceSubarray(int[] nums) {
        int len = nums.length;
        int ans = 1;
        int usedBit = 0;
        int i = 0;
        for (int j = 0; j < len; j++) {
            while ((usedBit & nums[j]) != 0) {
                // 나이스한 상태니까 비트가 하나씩 들어가 있으므로 가능한 구현
                // i가 j를 넘어갈 일이 없어서 조건에 안 넣어도 됨
                usedBit ^= nums[i];
                i++;
            }
            usedBit |= nums[j];
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }

    // 첫 풀이
//    public int longestNiceSubarray(int[] nums) {
//        // 모든 자리의 1인 비트의 개수가 한개 이하면 나이스
//        int ans = 1;
//        int j = 0;
//        int[] cnt = new int[31];
//        for (int i = 0; i < nums.length; i++) {
//            while (j < nums.length) {
//                apply(nums[j], cnt, 1);
//                j++;
//                if (isNice(cnt)) {
//                    ans = Math.max(ans, j - i);
//                } else {
//                    break;
//                }
//            }
//            apply(nums[i], cnt, -1);
//        }
//        return ans;
//    }
//
//    private boolean isNice(int[] cnt) {
//        for (int i = 0; i < cnt.length; i++) {
//            if (cnt[i] > 1) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private void apply(int num, int[] cnt, int value) {
//        int i = 0;
//        int tmp = num;
//        while (tmp > 0) {
//            if (tmp % 2 == 1) {
//                cnt[i] += value;
//            }
//            tmp /= 2;
//            i++;
//        }
//    }
}
