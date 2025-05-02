package boj11003

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,l) = br.readLine().split(" ").map { it.toInt() }
    val arr = br.readLine().split(" ").map { it.toInt() }

    // index, value
    // 오름차순으로 유지한다
    val q = ArrayDeque<Pair<Int, Int>>()
    for (i in 0 until arr.size) {
        val num = arr[i]
        val p = Pair(i, num)

        while (q.isNotEmpty() && q.last().second >= num) {
            q.removeLast()
        }
        q.addLast(p)

        while (q.isNotEmpty() && q.first().first <= i - l) {
            q.removeFirst()
        }
        print("${q.first().second} ")
    }
}