package c3100

class Solution {
    fun maxBottlesDrunk(numBottles: Int, numExchange: Int): Int {
        var full = numBottles
        var empty = 0
        var exchange = numExchange
        var ret = 0
        while (full > 0) {
            ret += full
            empty += full
            full = 0
            while (empty >= exchange) {
                empty -= exchange
                full++
                exchange++
            }
        }
        return ret
    }
}