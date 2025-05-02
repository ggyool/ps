import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class c763 {
    public List<Integer> partitionLabels(String s) {
        // 각 알파벳의 마지막 인덱스를 구해놓는다.
        // 반복하면서 조각을 쪼갠다.
        int[] lastIdx = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            lastIdx[c - 'a'] = i;
        }
        int start = 0;
        int targetIdx = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            targetIdx = Math.max(targetIdx, lastIdx[c - 'a']);
            if (i == targetIdx) {
                ans.add(i - start + 1);
                start = i + 1;
            }
        }
        return ans;
    }
}
