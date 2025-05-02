public class p1780 {
    public boolean checkPowersOfThree(int n) {
        if (n == 1) {
            return true;
        }
        int i = 0;
        int value = 1;
        while (value <= n) {
            if (value * 3 > n) {
                break;
            }
            value *= 3;
            i++;
        }
        while (i >= 0 && n >= 1) {
            if (value <= n) {
                n -= value;
            }
            value /= 3;
            i--;
        }
        return n == 0;
    }
}
