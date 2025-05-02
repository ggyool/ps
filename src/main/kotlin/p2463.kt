package ㅔ2463

import kotlin.math.abs
import kotlin.math.min

fun main() {
    //    println(listOf(2,6).binarySearch(6))


    val ans = Solution().minimumTotalDistance(
        listOf(9, 11, 99, 101),
        arrayOf(
            intArrayOf(7, 1),
            intArrayOf(10, 1),
            intArrayOf(14, 1),
            intArrayOf(96, 1),
            intArrayOf(100, 1),
            intArrayOf(103, 1),
        )
    )
    println(ans)
}


// GPT
class Solution {
    fun minimumTotalDistance(robot: List<Int>, factory: Array<IntArray>): Long {
        val robots = robot.sorted()
        val factories = factory.map { Pair(it[0], it[1]) }
            .sortedBy { it.first }
        val N = robots.size
        val M = factories.size
        val dp = Array(N + 1) { LongArray(M + 1) { Long.MAX_VALUE / 2 } }
        dp[0][0] = 0L
        for (i in 0..N) {
            for (j in 0 until M) {
                // 공장 j를 사용하지 않는 경우
                dp[i][j + 1] = min(dp[i][j + 1], dp[i][j])
                var cost = 0L
                val limit = factories[j].second
                val position = factories[j].first.toLong()
                for (t in 1..min(limit, i)) {
                    // 로봇 i - t를 공장 j에 배정
                    cost += abs(robots[i - t].toLong() - position)
                    dp[i][j + 1] = min(dp[i][j + 1], dp[i - t][j] + cost)
                }
            }
        }
        return dp[N][M]
    }
}

// limit를 여러개의 factory로 쪼개서 dp
//class Solution {
//    fun minimumTotalDistance(robot: List<Int>, factory: Array<IntArray>): Long {
//        val MAX_VALUE = 10_000_000_000_000L
//        val robots = robot.sorted()
//        val factories = factory.map { Pair(it[0], it[1]) }
//            .sortedBy { it.first }
//        val factoryPoses = mutableListOf<Int>()
//        for (fac in factories) {
//            for (i in 0..<fac.second) {
//                factoryPoses.add(fac.first)
//            }
//        }
//        val dp = Array(robots.size) {
//            LongArray(factoryPoses.size) { MAX_VALUE }
//        }
//        dp[0][0] = abs(robots[0].toLong() - factoryPoses[0])
//        for (j in 1..<factoryPoses.size) {
//            val dist = abs(robots[0].toLong() - factoryPoses[j])
//            dp[0][j] = min(dist, dp[0][j - 1])
//        }
//        // i 로봇이 j 까지의 팩토리를 선택
//        for (i in 1..<robots.size) {
//            for (j in 0..<factoryPoses.size) {
//                // j를 선택하는 경우
//                // dp[i-1][j-1] + dist
//                // j를 선택하지 않는 경우
//                // dp[i][j-1]
//                if (j - 1 < 0) continue
//                val dist = abs(robots[i].toLong() - factoryPoses[j])
//                dp[i][j] = min(dp[i - 1][j - 1] + dist, dp[i][j - 1])
//            }
//        }
//        return dp[robots.size - 1][factoryPoses.size - 1]
//    }
//}


// 처음 접근 그리디 가장 가까운 거리부터 구한다.
// 틀림: 거리가 같은 경우 뭘 선택하며 좋을지 알 수 없다.
//class Solution {
//    fun minimumTotalDistance(robot: List<Int>, factory: Array<IntArray>): Long {
//        val robots = robot.toMutableList()
//        val factories = factory.map { Pair(it[0], it[1]) }
//            .sortedBy { it.first }
//            .toCollection(mutableListOf())
//        var ans = 0L
//        while (robots.size > 0) {
//            val (robotIdx, factoryIdx, distance) = findTarget(robots, factories)
//            ans += distance
//            robots.removeAt(robotIdx)
//            if (factories[factoryIdx].second == 1) {
//                factories.removeAt(factoryIdx)
//            } else {
//                factories[factoryIdx] = Pair(factories[factoryIdx].first, factories[factoryIdx].second - 1)
//            }
//        }
//        return ans
//    }
//
//    // robotIdx, factoryIdx, distance
//    fun findTarget(robots: MutableList<Int>, factories: MutableList<Pair<Int, Int>>): Triple<Int, Int, Int> {
//        val factoryPoses = factories.map { it.first }
//        var minDist = Int.MAX_VALUE
//        var minRobotIdx = 0
//        var minFactoryIdx = 0
//        for (i in robots.indices) {
//            val x = robots[i]
//            val idx = factoryPoses.binarySearch(x)
//            val (targetIdx, distance) = if (idx >= 0) {
//                Pair(idx, abs(x - factoryPoses[idx]))
//            } else {
//                calcMinDistance(-idx - 1, x, factories)
//            }
//            if (distance < minDist) {
//                minFactoryIdx = targetIdx
//                minRobotIdx = i
//                minDist = distance
//            }
//        }
//        return Triple(minRobotIdx, minFactoryIdx, minDist)
//    }
//
//    // idx, distance
//    fun calcMinDistance(idx: Int, robotPos: Int, factories: MutableList<Pair<Int, Int>>): Pair<Int, Int> {
//        val a = if (idx - 1 >= 0) {
//            abs(robotPos - factories[idx - 1].first)
//        } else {
//            Int.MAX_VALUE
//        }
//        val b = if (idx <= factories.size - 1) {
//            abs(robotPos - factories[idx].first)
//        } else {
//            Int.MAX_VALUE
//        }
//        return if (a <= b) {
//            Pair(idx - 1, a)
//        } else {
//            Pair(idx, b)
//        }
//    }
//}