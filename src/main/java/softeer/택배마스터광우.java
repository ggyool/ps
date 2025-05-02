package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 택배마스터광우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] oneLine = br.readLine().split(" ");
        int n = Integer.parseInt(oneLine[0]);
        int m = Integer.parseInt(oneLine[1]);
        int k = Integer.parseInt(oneLine[2]);
        String[] twoLine = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(twoLine[i]);
        }
        List<Integer> lst = new ArrayList<>();
        boolean[] selected = new boolean[arr.length];
        int[] ans = new int[]{Integer.MAX_VALUE};
        solve(arr, selected, lst, ans, m, k);
        System.out.println(ans[0]);
    }

    private static void solve(int[] arr, boolean[] selected, List<Integer> lst, int[] ans, int m, int k) {
        if (lst.size() == arr.length) {
            ans[0] = Math.min(ans[0], calc(lst, m, k));
            return;
        }
        for (int i=0; i<arr.length; i++) {
            if (!selected[i]) {
                selected[i] = true;
                lst.add(arr[i]);
                solve(arr, selected, lst, ans, m, k);
                selected[i] = false;
                lst.remove(lst.size() - 1);
            }
        }
    }

    private static int calc(List<Integer> lst, int m, int k) {
        int len = lst.size();
        int j = 0;
        int ret = 0;
        for (int i=0; i<k; i++) {
            int tmp = 0;
            while (true) {
                if (tmp + lst.get(j%len) > m) {
                    break;
                }
                tmp += lst.get(j%len);
                j++;
            }
            ret += tmp;
        }
        return ret;
    }
}
