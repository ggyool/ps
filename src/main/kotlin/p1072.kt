package p1072

fun main() {
    Solution().maxEqualRowsAfterFlips(arrayOf(
        intArrayOf(0,1),
        intArrayOf(1,1)
    ))
}

class Solution {
    fun maxEqualRowsAfterFlips(matrix: Array<IntArray>): Int {
        val mp = HashMap<String, Int>()
        for (arr in matrix) {
            val s = arr.joinToString(separator = "")
            val sb = StringBuilder()
            for (c in s) {
                if (c == '1') sb.append('0')
                else sb.append('1')
            }
            val flipS = sb.toString()
            mp[s] = (mp[s] ?: 0) + 1
            mp[flipS] = (mp[flipS] ?: 0) + 1
        }
        return mp.values.max()
    }
}

//
//class Solution {
//    fun maxEqualRowsAfterFlips(matrix: Array<IntArray>): Int {
//        val r = matrix.size
//        val c = matrix[0].size
//        var ans = 1
//        for (i in 0 until r) {
//            var sum = 1
//            for (ii in 0 until r) {
//                if (i == ii) continue
//                val isSame = matrix[i][0] == matrix[ii][0]
//                var flag = true
//                for (j in 0 until c) {
//                    if (isSame && matrix[i][j] != matrix[ii][j]) {
//                        flag = false
//                        break
//                    }
//                    if (!isSame && matrix[i][j] == matrix[ii][j]) {
//                        flag = false
//                        break
//                    }
//                }
//                if (flag) sum++
//            }
//            ans = maxOf(ans, sum)
//        }
//        return ans
//    }
//}
