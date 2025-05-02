import java.util.ArrayList;
import java.util.List;

public class p1352 {

    class ProductOfNumbers {

        List<Integer> lst;

        public ProductOfNumbers() {
            lst = new ArrayList<>();
        }

        public void add(int num) {
            if (num == 0) {
                lst.clear();
            } else {
                int latestIdx = lst.size() - 1;
                if (latestIdx >= 0) {
                    lst.add(lst.get(latestIdx) * num);
                } else {
                    lst.add(num);
                }
            }
        }

        public int getProduct(int k) {
            if (lst.size() < k) {
                return 0;
            }
            int latestIdx = lst.size() - 1;
            int subIdx = latestIdx - k;
            int ret = lst.get(latestIdx);
            if (subIdx >= 0) {
                ret /= lst.get(subIdx);
            }
            return ret;
        }
    }

}
