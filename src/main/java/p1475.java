public class p1475 {
    public int[] finalPrices(int[] prices) {
        int l = prices.length;
        int[] arr = new int[l];
        arr[l - 1] = prices[l - 1];
        for (int i = 0; i < l - 1; i++) {
            arr[i] = prices[i];
            for (int j = i + 1; j < l; j++) {
                if (prices[i] >= prices[j]) {
                    arr[i] -= prices[j];
                    break;
                }
            }
        }
        return arr;
    }
}
