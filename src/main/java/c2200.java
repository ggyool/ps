import java.util.ArrayList;
import java.util.List;

public class c2200 {

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> ret = new ArrayList<>();
        int r = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                int l = Math.max(0, Math.max(i - k, r + 1));
                r = Math.min(i + k, nums.length - 1);
                for (int j = l; j <= r; j++) {
                    ret.add(j);
                }
            }
        }
        return ret;
    }

//    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
//        LinkedHashSet<Integer> set = new LinkedHashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            int num = nums[i];
//            if (num == key) {
//                for (int j = i - k; j <= i + k; j++) {
//                    if (j < 0 || j >= nums.length) {
//                        continue;
//                    }
//                    set.add(j);
//                }
//            }
//        }
//        return new ArrayList<>(set);
//    }
}
