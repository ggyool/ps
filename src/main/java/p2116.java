public class p2116 {
    public boolean canBeValid(String s, String locked) {
        int cnt = 0;
        int len = s.length();
        if (len%2==1) return false;
        for (int i=0; i<len; i++) {
            char c = s.charAt(i);
            char lock = locked.charAt(i);
            if (lock == '0') {
                cnt++;
            } else {
                if (c == ')') {
                    if (cnt <= 0) {
                        return false;
                    }
                    cnt--;
                } else {
                    cnt++;
                }
            }
        }
        cnt = 0;
        for (int i=0; i<len; i++) {
            char c = s.charAt(len-i-1);
            char lock = locked.charAt(len-i-1);
            if (lock == '0') {
                cnt++;
            } else {
                if (c == '(') {
                    if (cnt <= 0) {
                        return false;
                    }
                    cnt--;
                } else {
                    cnt++;
                }
            }
        }
        return true;
    }
}
