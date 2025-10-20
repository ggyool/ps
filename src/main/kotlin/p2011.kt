package p2011

class Solution {
    fun finalValueAfterOperations(operations: Array<String>): Int {
        var ret = 0
        for (op in operations) {
            if (op[1] == '-') {
                ret--
            } else {
                ret++
            }
        }
        return ret
    }
}