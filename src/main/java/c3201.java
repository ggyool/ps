public class c3201 {

    public int maximumLength(int[] nums) {
        int allEven = 0;
        int allOdd = 0;
        int oddFirst = 0;
        int evenFirst = 0;
        boolean oddTurn = true;
        boolean evenTurn = true;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num % 2 == 0) {
                allEven++;
            }
            if (num % 2 == 1) {
                allOdd++;
            }
            if (oddTurn && num % 2 == 1) {
                oddTurn = false;
                oddFirst++;
            } else if (!oddTurn && num % 2 == 0) {
                oddTurn = true;
                oddFirst++;
            }
            if (evenTurn && num % 2 == 0) {
                evenTurn = false;
                evenFirst++;
            } else if (!evenTurn && num % 2 == 1) {
                evenTurn = true;
                evenFirst++;
            }
        }
        return Math.max(
                Math.max(allEven, allOdd),
                Math.max(oddFirst, evenFirst)
        );
    }
}
