package p1574

fun main() {
    val ans = Solution().findLengthOfShortestSubarray(intArrayOf(1,2,3,10,4,2,3,5))
    println(ans)
}

class Solution {
    // 왼쪽에서 떼어내는 케이스
    // 중간에서 떼어내는 케이스
    // 오른쪽에서 떼어내는 케이스
    fun findLengthOfShortestSubarray(arr: IntArray): Int {
        var leftStartLen = 0
        var rightStartLen = 0
        for (i in arr.indices) {
            if  (leftStartLen == 0 || arr[i-1] <= arr[i]) {
                leftStartLen++
            } else {
                break
            }
        }
        for (i in arr.size -1 downTo 0) {
            if  (rightStartLen == 0 || arr[i] <= arr[i + 1]) {
                rightStartLen++
            } else {
                break
            }
        }
        // 전체 오름차순인 경우
        if (arr.size == leftStartLen) {
            return 0
        }
        // 오른쪽을 떼어내거나 왼쪽을 뗴어내는 케이스
        var ans = minOf(arr.size - leftStartLen, arr.size - rightStartLen)
        var j = - 1
        for (i in arr.size - rightStartLen until arr.size) {
            if (arr[0] <= arr[i]) {
                j = i
                break
            }
        }
        // 가장 처음 값보다 오른쪽 모든 값이 작은 경우는 중간을 떼어내는게 불가능
        if (j == -1) {
            return ans
        }
        for (i in 0 until leftStartLen) {
            if (arr[i] <= arr[j]) {
                val pickLen = i + 1 + arr.size - j
                ans = minOf(ans, arr.size - pickLen)
            }
            while (j < arr.size && arr[i] > arr[j]) {
                j++
            }
            if (j == arr.size) break
        }
        return ans
    }
}
