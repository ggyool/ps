package p976

class Solution {
    fun largestPerimeter(nums: IntArray): Int {
        val list = nums.sorted()
        // a +  b > c
        for (i in list.size - 1 downTo 2) {
            // c를 선택했을 때 가장 큰 a,b 조합만 보면 된다.
            // 삼각형 조건에 만족한다면 a+b가 가장 큰값이니까 ok
            // 삼각형의 조건에 만족하지 않는다면 다른 조합들도 만족하지 않음
            val a = list[i - 2]
            val b = list[i - 1]
            val c = list[i]
            if (a + b > c) {
                // 처음이 최대값
                return a + b + c
            }
        }
        return 0
    }
}

fun main() {
    Solution().largestPerimeter(intArrayOf(1, 2, 1, 10))
}