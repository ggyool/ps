package p2125

class Solution {
    fun numberOfBeams(bank: Array<String>): Int {
        var ret = 0
        var befCount = 0
        for (row in bank) {
            val oneCount = row.count { it == '1' }
            if (oneCount > 0) {
                ret += (oneCount * befCount)
                befCount = oneCount
            }
        }
        return ret
    }
}