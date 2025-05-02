package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 금고털이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] oneLine = br.readLine().split(" ");
        int w = Integer.parseInt(oneLine[0]);
        int n = Integer.parseInt(oneLine[1]);
        int[][] arr = new int[n][2];
        for (int i=0; i<n; i++) {
            String[] line = br.readLine().split(" ");
            int m = Integer.parseInt(line[0]);
            int p = Integer.parseInt(line[1]);
            arr[i][0] = m;
            arr[i][1] = p;
        }
        Arrays.sort(arr, (a,b) -> Integer.compare(b[1], a[1]));
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int m = arr[i][0];
            int p = arr[i][1];
            if (w > 0) {
                int value = Math.min(w, m);
                w -= value;
                ans += (value * p);
            } else {
                break;
            }
        }
        System.out.println(ans);
    }
}
