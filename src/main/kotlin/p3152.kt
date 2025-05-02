package p3152

fun main() {
    val ans = Solution().isArraySpecial(intArrayOf(2, 2), arrayOf(intArrayOf(0, 0)))
    for (an in ans) {
        println(an)
    }
}


// 첫 풀이
//class Solution {
//    fun isArraySpecial(nums: IntArray, queries: Array<IntArray>): BooleanArray {
//        // 연속으로 부호가 같은 지점의 인덱스를 찾는댜;.
//        // 쿼리가 주어질 때 쿼리의 시작점과 끝을 넣는다고 가정하고 인덱스가 같으면 중간 값이 없다는 것
//        // [4,4,3,6,6]
//        // [[0,2],[2,3]]
//        val lst = mutableListOf<Int>()
//        for (i in 0 until nums.size - 1) {
//            if ((nums[i] % 2 == 0) == (nums[i + 1] % 2 == 0)) {
//                lst.add(i)
//            }
//        }
//        val ans = BooleanArray(queries.size)
//        for (i in queries.indices) {
//            val query = queries[i]
//            val start = query[0]
//            val end = query[1]
//            ans[i] = (start == end)
//                    || (lowerBound(lst, start) == lowerBound(lst, end))
//        }
//        return ans
//    }
//
//    fun lowerBound(lst: List<Int>, target: Int): Int {
//        var left = 0
//        var right = lst.size
//        while (left < right) {
//            val mid = left + (right - left) / 2
//            if (lst[mid] < target) {
//                left = mid + 1
//            } else {
//                right = mid
//            }
//        }
//        return right
//    }
//}


// 풀 때 prefix sum 류 인가? 생각했었는데 int 넣을 생각을 못하고 boolean 만 생각해서 못 떠올림;;
class Solution {
    fun isArraySpecial(nums: IntArray, queries: Array<IntArray>): BooleanArray {
        val pSumSameParity = IntArray(nums.size)
        for (i in 1 until nums.size) {
            pSumSameParity[i] = pSumSameParity[i - 1]
            if (nums[i - 1] % 2 == nums[i] % 2) {
                pSumSameParity[i]++
            }
        }
        val ans = BooleanArray(queries.size)
        for (i in queries.indices) {
            val start = queries[i][0]
            val end = queries[i][1]
            ans[i] = pSumSameParity[end] - pSumSameParity[start] == 0
        }
        return ans
    }
}
