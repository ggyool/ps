public class p2425 {
    public int xorAllNums(int[] nums1, int[] nums2) {
        // [a,b]
        // [c,d,e]
        // a^c ^ a^d ^ a^e ^ b^c ^ b^d ^ b^e
        // 같은수 xor 하면 0이됨, 0이랑 xor하면 그대로
        // 상대 배열수가 짝수면 자기껀 날아감
        int ans = 0;
        if (nums2.length % 2 == 1) {
            for (int i = 0; i < nums1.length; i++) {
                ans ^= nums1[i];
            }
        }
        if (nums1.length % 2 == 1) {
            for (int i = 0; i < nums2.length; i++) {
                ans ^= nums2[i];
            }
        }
        return ans;
    }
}
