public class c3208 {

    // 배열에 붙이지 않으려고 % 썼는데 헷갈려서 붙여서 푸는게 나을듯
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int ans = 0;
        int cnt = 0;
        int len = colors.length;
        for (int i=0; i<len+k-2; i++) {
            if (colors[i%len] != colors[((i-1)+len)%len]) {
                cnt++;
            } else {
                cnt = 0;
            }
            if (cnt >= k-1) {
                ans++;
            }
        }
        return ans;
    }


    // 첫 풀이: 너무 복잡하게 품
//    public int numberOfAlternatingGroups(int[] colors, int k) {
//        int ans = 0;
//        int len = colors.length;
//        // 앞과 다른 개수 합
//        int[] psum = new int[len];
//        if (colors[0] != colors[len-1]) {
//            psum[0] = 1;
//        }
//        for (int i=1; i<len; i++) {
//            psum[i] = psum[i-1];
//            if (colors[i]!=colors[i-1]) {
//                psum[i]++;
//            }
//        }
//        for (int i=0; i+k-2<len; i++) {
//            if (i>=1) {
//                if (psum[i+k-2] - psum[i-1] == k-1) {
//                    ans++;
//                }
//            } else {
//                if (psum[i+k-2] == k-1) {
//                    ans++;
//                }
//            }
//        }
//        for (int i=len-k+2; i<len; i++) {
//            if (psum[len-1] - psum[i-1] + psum[(i+k-2)%len] == k-1) {
//                ans++;
//            }
//        }
//        return ans;
//    }
}
