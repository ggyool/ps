package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 서버증설횟수 {
    public int solution(int[] players, int m, int k) {
        // 종료시간, 개수
        Queue<int[]> q = new LinkedList<>();
        int ans = 0;
        int server = 0;
        for (int i = 0; i < players.length; i++) {
            int cnt = players[i];
            int neededServer = cnt / m;
            if (server < neededServer) {
                q.add(new int[]{i + k - 1, neededServer - server});
                ans += (neededServer - server);
                server = neededServer;
            }
            if (!q.isEmpty()) {
                int[] endCheckServer = q.peek();
                if (i == endCheckServer[0]) {
                    server -= endCheckServer[1];
                    q.poll();
                }
            }
        }
        return ans;
    }
}
