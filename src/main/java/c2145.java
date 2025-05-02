public class c2145 {

    // editorial 풀이
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int minValue = 0;
        int maxValue = 0;
        int sum = 0;
        for (int d : differences) {
            sum += d;
            minValue = Math.min(minValue, sum);
            maxValue = Math.max(maxValue, sum);
            if (maxValue - minValue > upper - lower) {
                return 0;
            }
        }
        return (upper - lower) - (maxValue - minValue) + 1;
    }

    // 첫 풀이
//    public int numberOfArrays(int[] differences, int lower, int upper) {
//        long minValue = 0;
//        long maxValue = 0;
//        long sum = 0;
//        for (int i = 0; i < differences.length; i++) {
//            sum += differences[i];
//            minValue = Math.min(minValue, sum);
//            maxValue = Math.max(maxValue, sum);
//        }
//        if (maxValue < lower) {
//            long diff = lower - minValue;
//            minValue += diff;
//            maxValue += diff;
//        } else if (maxValue > lower) {
//            long diff = minValue - lower;
//            minValue -= diff;
//            maxValue -= diff;
//        }
//        if (maxValue <= upper) {
//            return (int) (upper - maxValue + 1);
//        }
//        return 0;
//    }
}
