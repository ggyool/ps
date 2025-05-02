public class p1769 {
    public int[] minOperations(String boxes) {
        // 오른쪽에서 오는거랑 왼쪽에서 오는거 따로 새야할듯 ?
        int blen = boxes.length();
        int[] ans = new int[blen];
        int leftZero = 0;
        int leftDist = 0;
        int rightZero = 0;
        int rightDist = 0;


        for (int i = 0; i < blen; i++) {
            char left = boxes.charAt(i);
            ans[i] += leftDist;
            leftZero += (int) (left - '0');
            leftDist += leftZero;

            char right = boxes.charAt(blen - i - 1);
            ans[blen - i - 1] += rightDist;
            rightZero += (int) (right - '0');
            rightDist += rightZero;
        }
        return ans;
    }
}
