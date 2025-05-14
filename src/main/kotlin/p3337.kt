package p3337

// TODO time exceed (529 / 536)
// p3335 업그레이드 버전이라 비슷하게 접근하여 O(t*26*26)으로 풀고 시간초과나서 O(t*52)로 풀었는데 여전히 시간 초과
class Solution {
    fun lengthAfterTransformations(s: String, t: Int, nums: List<Int>): Int {
        val mod = 1_000_000_007
        var cnt = IntArray(26)
        for (c in s) {
            cnt[c - 'a']++
        }
        for (i in 1..t) {
            val addPoint = IntArray(52)
            val subPoint = IntArray(52)
            for (j in 0..25) {
                addPoint[j + 1] += cnt[j]
                addPoint[j + 1] %= mod
                subPoint[j + nums[j] + 1] += cnt[j]
                subPoint[j + nums[j] + 1] %= mod
            }
            val temp = IntArray(26)
            var add = 0
            for (j in 0..51) {
                add += addPoint[j]
                add %= mod
                add = (add + mod - subPoint[j]) % mod
                temp[j % 26] += add
                temp[j % 26] %= mod
            }
            cnt = temp
        }
        var ans = 0
        for (i in 0..25) {
            ans += cnt[i]
            ans %= mod
        }
        return ans
    }
}