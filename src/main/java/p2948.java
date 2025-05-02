import java.util.*;

public class p2948 {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        // 중간 중간 limit 넘게 비어있지 않으면 어떻게서든 순서를 바꿀 수 있다
        // 그룹지어서 그룹끼리만 정렬하면 될 것 같은데..
        // 그룹 지을 방법은?
        // 정렬하고 그룹을 나눈다.
        // 그룹별로 큐에 넣어놓고 하나씩 뺴온다.
        int n = nums.length;
        int[] sortedNum = nums.clone();
        Arrays.sort(sortedNum);
        Map<Integer, Integer> group = new HashMap<>();
        List<Queue<Integer>> lst = new ArrayList<>();
        lst.add(new ArrayDeque<>());
        lst.get(0).add(sortedNum[0]);
        group.put(sortedNum[0], 0);
        int groupNum = 0;
        for (int i = 1; i < n; i++) {
            if (sortedNum[i] - sortedNum[i - 1] > limit) {
                groupNum++;
                lst.add(new ArrayDeque<>());
            }
            lst.get(groupNum).add(sortedNum[i]);
            group.put(sortedNum[i], groupNum);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int groupN = group.get(nums[i]);
            ans[i] = lst.get(groupN).poll();
        }
        return ans;
    }
}
