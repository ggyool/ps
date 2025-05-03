package p1007

class Solution {
    fun minDominoRotations(tops: IntArray, bottoms: IntArray): Int {
        // 가능한 주사위 눈 찾기
        val cnt = IntArray(7)
        for (i in tops.indices) {
            if (tops[i] != bottoms[i]) {
                cnt[tops[i]]++
                cnt[bottoms[i]]++
            } else {
                cnt[tops[i]]++
            }
        }
        val lst = mutableListOf<Int>()
        for (i in 1..6) {
            if (cnt[i] == tops.size) {
                lst.add(i)
            }
        }
        // 가능한 숫자가 없는 경우
        if (lst.size == 0) return -1
        // 가능한 경우 하나씩 세보기
        var ans = Int.MAX_VALUE
        for (n in lst) {
            var topCnt = 0
            for (top in tops) {
                if (top != n) topCnt++
            }
            var bottomCnt = 0
            for (bottom in bottoms) {
                if (bottom != n) bottomCnt++
            }
            ans = Math.min(ans, Math.min(topCnt, bottomCnt))
        }
        return ans
    }
}