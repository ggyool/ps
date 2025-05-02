package programmers;

import java.util.*;

public class 지게차와크레인 {

    int[] dy = {0,1,0,-1};
    int[] dx = {1,0,-1,0};

    public int solution(String[] storage, String[] requests) {
        int r = storage.length;
        int c = storage[0].length();
        char[][] arr = new char[r][c];
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                arr[i][j] = storage[i].charAt(j);
            }
        }
        for (int t=0; t<requests.length; t++) {
            String request = requests[t];
            char target = request.charAt(0);
            if (request.length() == 1) {
                jige(arr, target);
            } else {
                crane(arr, target);
            }
        }
        int answer = r * c;
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                if (arr[i][j] == '-') answer--;
            }
        }
        return answer;
    }

    void jige(char[][] arr, char target) {
        int r = arr.length;
        int c = arr[0].length;
        List<Pos> poses = new ArrayList<>(findOutsideConnectPoses(arr));
        for (Pos pos: poses) {
            int y = pos.y;
            int x = pos.x;
            if (arr[y][x] == target) {
                arr[y][x] = '-';
            }
        }
    }

    Set<Pos> findOutsideConnectPoses(char[][] arr){
        int r = arr.length;
        int c = arr[0].length;
        boolean[][] visited = new boolean[r][c];
        Set<Pos> st = new HashSet<>();
        Queue<Pos> q = new LinkedList<>();

        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                if (i==0 || j==0 || i==r-1 || j==c-1) {
                    if (arr[i][j] == '-') {
                        q.add(new Pos(i,j));
                    } else {
                        st.add(new Pos(i,j));
                    }
                    visited[i][j] = true;
                }
            }
        }
        while (!q.isEmpty()){
            Pos pos = q.poll();
            int cy = pos.y;
            int cx = pos.x;
            for (int i=0; i<4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if (ny<0 || nx <0 || ny>=r || nx>=c) continue;
                if (visited[ny][nx]) continue;
                if (arr[ny][nx] == '-') {
                    q.add(new Pos(ny,nx));
                } else {
                    st.add(new Pos(ny,nx));
                }
                visited[ny][nx] = true;
            }
        }
        return st;
    }

    void crane(char[][] arr, char target) {
        int r = arr.length;
        int c = arr[0].length;
        for (int y=0; y<r; y++) {
            for (int x=0; x<c; x++) {
                if (arr[y][x] == target) {
                    arr[y][x] = '-';
                }
            }
        }
    }

    private static class Pos{
        int y;
        int x;

        Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Pos pos = (Pos) o;
            return y == pos.y && x == pos.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }
}
