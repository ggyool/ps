package p3335

// editorial 아이디어
class Solution {
    fun lengthAfterTransformations(s: String, t: Int): Int {
        val mod = 1_000_000_007
        val cnt = IntArray(26)
        for (c in s) {
            cnt[c - 'a']++
        }
        for (i in 1..t) {
            val zCnt = cnt[25]
            for (j in 25 downTo 1) {
                cnt[j] = cnt[j - 1]
            }
            cnt[0] = zCnt
            cnt[1] += zCnt
            cnt[1] %= mod
        }
        var ans = 0
        for (i in 0..25) {
            ans += cnt[i]
            ans %= mod
        }
        return ans
    }
}

// 첫 풀이: 너무 복잡하게 생각하고 풀음
//class Solution {
//    fun lengthAfterTransformations(s: String, t: Int): Int {
//        val mod = 1_000_000_007
//        val schedule = mutableMapOf<Int, Int>()
//        for (c in s) {
//            val nextTime = 'z' - c + 1
//            schedule.put(nextTime, schedule.getOrDefault(nextTime, 0) + 1)
//        }
//        var ans = s.length
//        for (i in 1..t) {
//            val cnt = schedule.get(i)
//            if (cnt != null) {
//                val nextTime1 = i + ('z' - 'a') + 1
//                schedule.put(nextTime1, (schedule.getOrDefault(nextTime1, 0) + cnt) % mod)
//                val nextTime2 = i + ('z' - 'b') + 1
//                schedule.put(nextTime2, (schedule.getOrDefault(nextTime2, 0) + cnt) % mod)
//                ans += cnt
//                ans %= mod
//            }
//        }
//        return ans
//    }
//}