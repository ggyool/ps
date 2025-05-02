package p2054

fun main() {
    val ans = Solution().maxTwoEvents(
        arrayOf(
            intArrayOf(1, 3, 2),
            intArrayOf(4, 5, 2),
            intArrayOf(2, 4, 3),
        )
    )
    println(ans)
}

// 내 첫 pass 구현
//class Solution {
//    // 한 조각만 뽑는 경우 최대값 미리 계산
//    // 2조각만 뽑을 수 있는 경우 (왼, 오 한조각씩 선택)
//    // 1. end 기준으로 정렬 및 누적 max 구하기
//    // 2. start 기준으로 정렬 및 누적 max 구하기
//    // 3. 투포인터
//    fun maxTwoEvents(events: Array<IntArray>): Int {
//        var ans = events.maxBy { it[2] }[2]
//        val endSortedList =
//            events.map { Pair(it[1], it[2]) }.sortedWith(compareBy({ it.first }, { it.second })).toMutableList()
//        for (i in endSortedList.indices) {
//            if (i == 0) continue
//            if (endSortedList[i - 1].second > endSortedList[i].second) {
//                endSortedList[i] = Pair(endSortedList[i].first, endSortedList[i - 1].second)
//            }
//        }
//        val startSortedList =
//            events.map { Pair(it[0], it[2]) }.sortedWith(compareBy({ it.first }, { it.second })).toMutableList()
//        for (i in startSortedList.size - 1 downTo 0) {
//            if (i == startSortedList.size - 1) continue
//            if (startSortedList[i + 1].second > startSortedList[i].second) {
//                startSortedList[i] = Pair(startSortedList[i].first, startSortedList[i + 1].second)
//            }
//        }
//
//        var i = 0
//        var j = 0
//        while (i < events.size && j < events.size) {
//            val leftPiece = endSortedList[i]
//            val rightPiece = startSortedList[j]
//            val end = leftPiece.first
//            val start = rightPiece.first
//            if (end >= start) {
//                ++j
//            } else {
//                ans = maxOf(ans, leftPiece.second + rightPiece.second)
//                ++i
//            }
//        }
//        return ans
//    }
//}


// 솔루션 초회수 Top1 풀이
class Solution {
    fun maxTwoEvents(events: Array<IntArray>): Int {
        val n = events.size

        // Step1. start 로 이벤트 정렬
        events.sortWith(compareBy { it[0] })

        // Step2. SuffixMax 배열 만들고 채우기
        val suffixMax = IntArray(n)
        suffixMax[n - 1] = events[n - 1][2]
        for (i in n - 2 downTo  0) {
            suffixMax[i] = maxOf(events[i][2], suffixMax[i + 1])
        }

        // Step3. 안 겹치는 이벤트가 최소 인덱스가 어디에 있는지 이분 탐색으로 찾기
        var maxSum = 0
        for ( i in 0 until  n) {
            var left = i + 1
            var right = n -  1
            var nextEventIndex = -1
            while (left <= right) {
                val mid = left + (right - left) / 2
                val leftEnd = events[i][1]
                val rightStart = events[mid][0]
                if (leftEnd < rightStart) {
                    nextEventIndex = mid
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            }

            // 가능한 오른쪽 이벤트가 있는 경우
            if (nextEventIndex != -1) {
                maxSum = maxOf(maxSum, events[i][2] + suffixMax[nextEventIndex])
            } else {
                maxSum = maxOf(maxSum, events[i][2])
            }
        }
        return maxSum
    }
}