public class c2843 {
    public int countSymmetricIntegers(int low, int high) {
        int ans = 0;
        for (int i = low; i <= high; i++) {
            if (isSymmetric(i)) {
                ans++;
            }
        }
        return ans;
    }

    // n 이 작아서 이렇게 안하고 / 랑 % 이용해서 4자리수일때 값들 떼어내어도 됨
    private boolean isSymmetric(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        if (len % 2 == 1) {
            return false;
        }
        int harfLen = len / 2;
        int a = 0;
        int b = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            int n = (int) (c - '0');
            if (i < harfLen) {
                a += n;
            } else {
                b += n;
            }
        }
        return a == b;
    }
}
