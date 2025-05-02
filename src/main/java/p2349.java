import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class p2349 {

    // index, number
    Map<Integer, Integer> indexToNumber = new HashMap<>();
    // number, indices
    Map<Integer, TreeSet<Integer>> numberToIndex = new HashMap<>();

    public p2349() {

    }

    public void change(int index, int number) {
        if (indexToNumber.containsKey(index)) {
            Integer oldNumber = indexToNumber.get(index);
            numberToIndex.get(oldNumber).remove(index);
        }
        indexToNumber.put(index, number);

        TreeSet<Integer> st = numberToIndex.get(number);
        if (st == null) {
            st = new TreeSet<>();
            numberToIndex.put(number, st);
        }
        st.add(index);
    }

    public int find(int number) {
        TreeSet<Integer> st = numberToIndex.get(number);
        if (st == null || st.isEmpty()) {
            return -1;
        }
        return st.getFirst();
    }
}
