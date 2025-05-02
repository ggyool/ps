import java.util.PriorityQueue;

public class p2683 {
    public boolean doesValidArrayExist(int[] derived) {
        // 1이면 다음과 달라야한다. 0이면 같아야한다.
        // 첫번째 값이 1이라고 가정
        // int cur = 1;
        // for (int i=0; i<derived.length; i++) {
        //     if (derived[i] == 1) {
        //         cur = 1 - cur;
        //     }
        // }
        // return cur==1;

        // 위 처럼 풀었지만 생각하보면
        // 0^1 1^2 2^3 3^0 이므로
        // 모든 값을 xor 하면 0이 나와야한다.
        int ret = 0;
        for (int i=0; i<derived.length; i++) {
            ret ^= derived[i];
        }
        return ret==0;
    }
}
