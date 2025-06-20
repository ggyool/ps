package p3443

import kotlin.math.abs

class Solution {
    fun maxDistance(s: String, k: Int): Int {
        var nCnt = 0
        var sCnt = 0
        var wCnt = 0
        var eCnt = 0
        var ret = 0
        for (i in s.indices) {
            val c = s[i]
            when (c) {
                'N' -> nCnt++
                'S' -> sCnt++
                'W' -> wCnt++
                'E' -> eCnt++
            }
            val wDist = abs(wCnt - eCnt)
            val hDist = abs(nCnt - sCnt)
            var remain = k
            val hAdd = if (nCnt >= sCnt) {
                minOf(remain, sCnt)
            } else {
                minOf(remain, nCnt)
            }
            remain -= hAdd
            val wAdd = if (wCnt >= eCnt) {
                minOf(remain, eCnt)
            } else {
                minOf(remain, wCnt)
            }
            ret = maxOf(ret, wDist + hDist + 2 * hAdd + 2 * wAdd)
        }
        return ret
    }
}