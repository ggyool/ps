import java.util.HashMap;
import java.util.Map;

public class p3160 {
    public int[] queryResults(int limit, int[][] queries) {
        int[] ret = new int[queries.length];
        // ball, color
        Map<Integer, Integer> ballMap = new HashMap<>();
        // color, count
        Map<Integer, Integer> colorMap = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];
            if (ballMap.containsKey(ball)) {
                int befColor = ballMap.get(ball);
                int afterCount = colorMap.get(befColor) - 1;
                if (afterCount == 0) {
                    colorMap.remove(befColor);
                } else {
                    colorMap.put(befColor, afterCount);
                }
            }
            ballMap.put(ball, color);
            colorMap.put(color, colorMap.getOrDefault(color, 0) + 1);
            ret[i] = colorMap.size();
        }
        return ret;
    }
}
