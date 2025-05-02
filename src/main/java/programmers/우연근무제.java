package programmers;

public class 우연근무제 {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        for (int i = 0; i < schedules.length; i++) {
            int[] timelog = timelogs[i];
            int day = startday;
            boolean isAble = true;
            for (int j = 0; j < timelog.length; j++) {
                if (day < 6) {
                    if (toMinute(schedules[i]) + 10 < toMinute(timelog[j])) {
                        isAble = false;
                        break;
                    }
                }
                day++;
                if (day == 8) day = 1;
            }
            if (isAble) answer++;
        }
        return answer;
    }

    private int toMinute(int time) {
        return time / 100 * 60 + time % 100;
    }
}
