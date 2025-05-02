import java.util.ArrayList;
import java.util.List;

public class p916 {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        // 1. 각 words1 마다 알파벳 개수를 센다
        // 2. 각 words2 합산 max를 구한다.
        // 3. words1을 순회하며 판단한다.
        int len1 = words1.length;
        int len2 = words2.length;
        int[][] count = new int[len1][26];
        for (int i = 0; i < len1; i++) {
            count[i] = caclCount(words1[i]);
        }

        int[] maxCount = new int[26];
        for (int i = 0; i < len2; i++) {
            int[] tempCount = caclCount(words2[i]);
            for (int j = 0; j < 26; j++) {
                maxCount[j] = Math.max(maxCount[j], tempCount[j]);
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < len1; i++) {
            boolean flag = true;
            for (int j = 0; j < 26; j++) {
                if (count[i][j] < maxCount[j]) {
                    flag = false;
                }
            }
            if (flag) {
                ans.add(words1[i]);
            }
        }
        // label 사용
//        point: for (int i=0; i<len1; i++) {
//            for (int j=0; j<26; j++) {
//                if (count[i][j] < maxCount[j]) {
//                    continue point;
//                }
//            }
//            ans.add(words1[i]);
//        }
        return ans;
    }

    private int[] caclCount(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        return count;
    }
}
