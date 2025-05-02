package p207

class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val q = ArrayDeque<Int>()
        val indegrees = IntArray(numCourses)
        val edges = HashMap<Int, MutableList<Int>>().apply {
            for (i in 0 until numCourses) {
                this[i] = mutableListOf()
            }
        }
        for (arr in prerequisites) {
            val from = arr[0]
            val to = arr[1]
            edges[from]!!.add(to)
            indegrees[to]++
        }

        for (i in 0 until numCourses) {
            if (indegrees[i] == 0) {
                q.add(i)
            }
        }
        var cnt = q.size
        while (!q.isEmpty()) {
            val cur = q.removeFirst()
            for (next in edges[cur]!!) {
                indegrees[next]--
                if (indegrees[next] == 0) {
                    cnt++
                    q.add(next)
                }
            }
        }
        return cnt == numCourses
    }
}
