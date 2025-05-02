public class p2381 {
    public String shiftingLetters(String s, int[][] shifts) {
        int slen = s.length();
        // idx 에서 증가해야하거나 줄여야하는 인덱스 기록
        int[] command = new int[slen + 1];
        for (int i = 0; i < shifts.length; i++) {
            int start = shifts[i][0];
            int end = shifts[i][1];
            int dir = shifts[i][2];
            if (dir == 1) {
                command[start]++;
                command[end + 1]--;
            } else {
                command[start]--;
                command[end + 1]++;
            }
        }
        StringBuilder sb = new StringBuilder();
        int cur = 0;
        for (int i = 0; i < slen; i++) {
            cur += command[i];
            char c = s.charAt(i);
            int converted = (c - 'a' + cur) % 26;
            // -40 % 26 하면 -14가 나와서 한 번 더하고 모듈러 실행
            // 신기하게 파이썬은 12가 나옴
            converted = (converted + 26) % 26;
            sb.append((char) ('a' + converted));
        }
        return sb.toString();
    }
}