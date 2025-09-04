package p3238

class Solution {
    fun winningPlayerCount(n: Int, pick: Array<IntArray>): Int {
        val arr = Array<MutableMap<Int, Int>>(n) {
            mutableMapOf()
        }
        for ((user, color) in pick) {
            arr[user][color] = (arr[user][color] ?: 0) + 1
        }
        var ret = 0
        for (user in arr.indices) {
            if (arr[user].any { (color,cnt) ->  cnt > user}) {
                ret++
            }
        }
        return ret
    }
}