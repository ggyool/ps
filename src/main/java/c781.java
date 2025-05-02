public class c781 {
    public int numRabbits(int[] answers) {
        int[] cnt = new int[1000];
        for (int i = 0; i < answers.length; i++) {
            cnt[answers[i]]++;
        }
        int ans = 0;
        for (int i = 0; i < 1000; i++) {
            if (cnt[i] > 0) {
                int target = i + 1;
                ans += target * (cnt[i] / target);
                if (cnt[i] % target > 0) {
                    ans += target;
                }
            }
        }
        return ans;
    }
}
