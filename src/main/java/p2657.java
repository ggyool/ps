public class p2657 {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int len = A.length;
        int[] ret = new int[len];
        int same = 0;
        boolean[] check = new boolean[51];
        for (int i = 0; i < len; i++) {
            if (check[A[i]] == false) {
                check[A[i]] = true;
            } else {
                same++;
            }
            if (check[B[i]] == false) {
                check[B[i]] = true;
            } else {
                same++;
            }
            ret[i] = same;
        }
        return ret;
    }
}
