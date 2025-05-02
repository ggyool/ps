import java.util.ArrayList;
import java.util.List;

public class p2570 {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> lst = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            int id1 = nums1[i][0];
            int val1 = nums1[i][1];
            int id2 = nums2[j][0];
            int val2 = nums2[j][1];
            if (id1 < id2) {
                if (!lst.isEmpty()) {
                    int[] recent = lst.get(lst.size() - 1);
                    if (recent[0] == id1) {
                        recent[1] += val1;
                    } else {
                        lst.add(new int[]{id1, val1});
                    }
                } else {
                    lst.add(new int[]{id1, val1});
                }
                i++;
            } else if (id1 > id2) {
                if (!lst.isEmpty()) {
                    int[] recent = lst.get(lst.size() - 1);
                    if (recent[0] == id2) {
                        recent[1] += val2;
                    } else {
                        lst.add(new int[]{id2, val2});
                    }
                } else {
                    lst.add(new int[]{id2, val2});
                }
                j++;
            } else {
                lst.add(new int[]{id1, val1 + val2});
                i++;
                j++;
            }
        }

        while (i < nums1.length) {
            int id1 = nums1[i][0];
            int val1 = nums1[i][1];
            lst.add(new int[]{id1, val1});
            i++;
        }

        while (j < nums2.length) {
            int id2 = nums2[j][0];
            int val2 = nums2[j][1];
            lst.add(new int[]{id2, val2});
            j++;
        }

        int[][] ans = new int[lst.size()][2];
        for (int t = 0; t < lst.size(); t++) {
            ans[t] = lst.get(t);
        }
        return ans;
    }
}
