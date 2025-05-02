public class p2342 {
    // 하나만 기억하면 되더라
    public int maximumSum(int[] nums) {
        // 10**9 까지므로 최대 81까지
        int[] maxDigitSum = new int[82];
        int ans = -1;
        for (int num : nums) {
            int sum = 0;
            int tmp = num;
            while (tmp > 0) {
                sum += tmp % 10;
                tmp /= 10;
            }
            if (maxDigitSum[sum] != 0) {
                ans = Math.max(ans, maxDigitSum[sum] + num);
            }
            maxDigitSum[sum] = Math.max(maxDigitSum[sum], num);
        }
        return ans;
    }


    // 첫 풀이
//    public int maximumSum(int[] nums) {
//        Map<Integer, Info> mp = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            int sum = digitSum(nums[i]);
//            Info info = mp.get(sum);
//            if (info == null) {
//                info = new Info();
//                mp.put(sum, info);
//            }
//            info.fill(nums[i]);
//        }
//        int ans = -1;
//        for (Info info : mp.values()) {
//            if (info.a != -1 && info.b != -1) {
//                ans = Math.max(ans, info.a + info.b);
//            }
//        }
//        return ans;
//    }
//
//    private int digitSum(int num) {
//        int ret = 0;
//        while (num > 0) {
//            ret += num % 10;
//            num /= 10;
//        }
//        return ret;
//    }
//
//    class Info {
//        int a = -1;
//        int b = -1;
//
//        void fill(int num) {
//            if (a == -1) {
//                a = num;
//            } else if (b == -1) {
//                if (a >= num) {
//                    b = num;
//                } else {
//                    b = a;
//                    a = num;
//                }
//            } else if (num >= a) {
//                b = a;
//                a = num;
//            } else if (num >= b) {
//                b = num;
//            }
//        }
//    }
}
