package programmers;

public class 택배상자꺼내기 {
    public int solution(int n, int w, int num) {
        // 층수
        int floor = (num - 1) / w;
        int maxFloor = (n - 1) / w;
        // 가로 좌표
        int x = (num - 1) % w;
        int maxX = (n - 1) % w;
        int answer = maxFloor - floor;
        if (floor % 2 == maxFloor % 2) {
            if (x <= maxX) answer++;
        } else {
            if (x + maxX >= w - 1) answer++;
        }
        return answer;
    }
}
