package p2779


// 첫 pass 풀이 nlogn
//class Solution {
//    fun maximumBeauty(nums: IntArray, k: Int): Int {
//        // start와 end를 저장해서 정렬
//        // 겹치는 누적이 몇이 max인지 학인
//        var minValue = nums[0]
//        var maxValue = nums[0]
//        val starts = mutableListOf<Int>()
//        val ends = mutableListOf<Int>()
//        for (num in nums) {
//            starts.add(num - k)
//            ends.add(num + k)
//            minValue = minOf(num, minValue)
//            maxValue = maxOf(num, maxValue)
//        }
//        starts.sort()
//        ends.sort()
//
//        var i = 0
//        var j = 0
//        var cnt = 0
//        var ans = 0
//        while (i < starts.size) {
//            val start = starts[i]
//            val end = ends[j]
//            if (start <= end) {
//                cnt++
//                ans = maxOf(ans, cnt)
//                i++
//            } else {
//                cnt--
//                j++
//            }
//        }
//        return ans
//    }
//}

fun main() {
    println(Solution().maximumBeauty(intArrayOf(1), 0))
}

// 가장 많은 득표르 받은 풀이
// 정렬할 필요 없이 숫자가 10**5 이므로 배열 만들어서 누적합 처리 가능 O(N)
// 숫자 범위가크면 불가할듯?
class Solution {
    fun maximumBeauty(nums: IntArray, k: Int): Int {
        val maxNum = nums.max()
        val cntArr = IntArray(maxNum + 2)
        for (num in nums) {
            ++cntArr[maxOf(num - k, 0)]
            --cntArr[minOf(num + k + 1, maxNum + 1)]
        }
        var dup = 0
        var ans = 0
        for (i in 0..maxNum + 1) {
            dup += cntArr[i]
            ans = maxOf(ans, dup)
        }
        return ans
    }
}
