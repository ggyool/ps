package p611

class Solution {

    // two pointer 풀이
    fun triangleNumber(nums: IntArray): Int {
        val list = nums.sorted()
        var ret = 0
        // a + b > c
        for (k in list.size - 1 downTo 2) {
            var i = 0
            var j = k - 1
            while (i < j) {
                val a = list[i]
                val b = list[j]
                val c = list[k]
                if (a + b > c) {
                    ret += (j - i)
                    j--
                } else {
                    i++
                }
            }
        }
        return ret
    }

    // 첫 풀이
//    fun triangleNumber(nums: IntArray): Int {
//        val list = nums.sorted()
//        // 어떤 숫자보다 작은 숫자가 처음으로 나오는 인덱스
//        val index = IntArray(1001) { -1 }
//        for (i in list.indices) {
//            index[list[i]] = i
//        }
//        val minNum = list[0]
//        var smallerIndex = index[minNum]
//        for (num in minNum + 1..1000) {
//            if (index[num] == -1) {
//                index[num] = smallerIndex
//            } else {
//                val temp = index[num]
//                index[num] = smallerIndex
//                smallerIndex = temp
//            }
//        }
//        var ret = 0
//        for (i in 0..<list.size - 1) {
//            for (j in i + 1..<list.size) {
//                if (list[i] == 0 || list[j] == 0) continue
//                val twoSum = list[i] + list[j]
//                val twoSumSmallerIndex = if (twoSum > 1000) {
//                    list.size - 1
//                } else {
//                    index[twoSum]
//                }
//                if (twoSumSmallerIndex - j > 0) {
//                    ret += twoSumSmallerIndex - j
//                }
//            }
//        }
//        return ret
//    }
}

fun main() {
    val a = Solution().triangleNumber(intArrayOf(2, 3, 4, 4))
    println(a)
}