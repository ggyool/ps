package p3097

import kotlin.math.min

fun main() {

    println(Solution().minimumSubarrayLength(intArrayOf(1,2,3), 2))
}

// 다른 코드 보고 bit 카운팅하는 아이디어 얻어서 푼거
class Solution {
    fun minimumSubarrayLength(nums: IntArray, k: Int): Int {
        if (k==0) return 1
        var ans = Int.MAX_VALUE
        var bits = IntArray(32) { 0 }
        var left = 0
        var cur = 0
        for (right in 0 until nums.size) {
            cur = cur or nums[right]
            plusBitCount(bits, nums[right])
            while (left <= right && cur >= k) {
                ans = min(ans, right - left + 1)
                minusBitCount(bits, nums[left])
                cur = fromBits(bits)
                left++
            }
        }
        return if (ans == Int.MAX_VALUE) { -1 } else ans
    }

    fun plusBitCount(bits: IntArray, target: Int) {
        var tmp = target
        var i = 0
        while (tmp > 0) {
            if (tmp % 2 == 1) {
                ++bits[i]
            }
            tmp /= 2
            i++
        }
    }

    fun minusBitCount(bits: IntArray, target: Int) {
        var tmp = target
        var i = 0
        while (tmp > 0) {
            if (tmp % 2 == 1) {
                --bits[i]
            }
            tmp /= 2
            i++
        }
    }

    fun fromBits(bits: IntArray): Int {
        var ret = 0
        var tmp = 1
        for (i in bits.indices) {
            if (bits[i] > 0) {
                ret += tmp
            }
            tmp *= 2
        }
        return ret
    }
}

// 첫 풀이
//class Solution {
//    fun minimumSubarrayLength(nums: IntArray, k: Int): Int {
//        if (k ==0) return 1
//        var left = 0
//        var right = -1
//        var sum = 0L
//        var ans = Int.MAX_VALUE
//        while (left < nums.size && right < nums.size) {
//            if (sum < k) {
//                right++
//                if (right != nums.size ) {
//                    sum = sum or nums[right].toLong()
//                }
//            } else {
//                ans = min(ans, right - left + 1)
//                left++
//                sum = 0L
//                for (i in right downTo  left) {
//                    sum = sum or nums[i].toLong()
//                    if (sum >= k) {
//                        ans = min(ans, right - i + 1)
//                        left = i
//                        break
//                    }
//                }
//            }
//        }
//        return if (ans == Int.MAX_VALUE) {
//            -1
//        } else {
//            ans
//        }
//    }
//}
