public class c2594 {
    public long repairCars(int[] ranks, int cars) {
        long minR = Long.MAX_VALUE;
        for (int i = 0; i < ranks.length; i++) {
            minR = Math.min(minR, ranks[i]);
        }
        long left = 1;
        long right = minR * cars * cars;
        while (left < right) {
            long mid = (left + right) / 2;
            if (isAble(mid, ranks, cars)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private boolean isAble(long minute, int[] ranks, int cars) {
        long rapairCar = 0;
        for (int i = 0; i < ranks.length; i++) {
            rapairCar += minRepairedCar(minute, ranks[i]);
        }
        return rapairCar >= cars;
    }

    // minute 이하의 시간으로 몇 대의 차를 수리할 수 있는지
    private long minRepairedCar(long minute, int r) {
        return (long) Math.floor(Math.sqrt(
                ((double) minute) / r
        ));
    }
}
