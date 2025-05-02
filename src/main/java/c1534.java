public class c1534 {

    // editorial 풀이
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int ret = 0;
        int len = arr.length;
        int[] cnt = new int[1001];
        for (int j = 0; j < len - 1; j++) {
            for (int k = j + 1; k < len; k++) {
                if (Math.abs(arr[j] - arr[k]) <= b) {
                    int l = Math.max(0, Math.max(arr[j] - a, arr[k] - c));
                    int r = Math.min(1000, Math.min(arr[j] + a, arr[k] + c));
                    if (l <= r) {
                        if (l == 0) {
                            ret += cnt[r];
                        } else {
                            ret += (cnt[r] - cnt[l - 1]);
                        }
                    }
                }
            }
            for (int i = arr[j]; i <= 1000; i++) {
                cnt[i]++;
            }
        }
        return ret;
    }

    // 3중으로 푼 풀이
//    public int countGoodTriplets(int[] arr, int a, int b, int c) {
//        int ret = 0;
//        int len = arr.length;
//        for (int i = 0; i < len - 2; i++) {
//            for (int j = i + 1; j < len - 1; j++) {
//                for (int k = j + 1; k < len; k++) {
//                    if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
//                        ret++;
//                    }
//                }
//            }
//        }
//        return ret;
//    }
}
