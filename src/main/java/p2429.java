import java.util.ArrayList;
import java.util.List;

public class p2429 {
    public int minimizeXor(int num1, int num2) {
        // num2에서 1의 개수를 센다
        // 가장 작은 XOR이므로 1인 곳에 다 1을 채워서 0이 나오게 만들고
        // 1이 남으면 가장 아래 비트부터 채운다.
        // 1이부족하면 큰 비트부터 채운다.
        int oneCnt = 0;
        while (num2 > 0) {
            if (num2 % 2 == 1) oneCnt++;
            num2 /= 2;
        }
        int oneCntSave = oneCnt;
        List<Boolean> binLst = new ArrayList<>();
        while (num1 > 0) {
            if (num1 % 2 == 1) binLst.add(true);
            else binLst.add(false);
            num1 /= 2;
        }
        // 1인 큰 비트부터 1을 채운다.
        int len = binLst.size();
        int retLen = Math.max(len, oneCntSave);
        int[] retArr = new int[retLen];
        for (int i = len - 1; i >= 0; i--) {
            if (oneCnt <= 0) break;
            if (binLst.get(i)) {
                retArr[i] = 1;
                oneCnt--;
            }
        }
        // 1이 남으면 작은 비트부터 1을 채운다.
        for (int i = 0; i < retLen; i++) {
            if (oneCnt <= 0) break;
            if (retArr[i] == 0) {
                retArr[i] = 1;
                oneCnt--;
            }
        }
        int ans = 0;
        for (int i = 0; i < retLen; i++) {
            ans *= 2;
            ans += retArr[retLen - i - 1];
        }
        return ans;
    }
}
