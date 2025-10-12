package p1518

class Solution {
    fun numWaterBottles(numBottles: Int, numExchange: Int): Int {
        var ret = numBottles
        var tmp = numBottles
        while (tmp >= numExchange) {
            ret += tmp / numExchange
            tmp = tmp / numExchange + tmp % numExchange
        }
        return ret
    }
}