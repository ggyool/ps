package p2516

fun main() {
    val ans = Solution().takeCharacters("aabaaaacaabc", 2)
    println(ans)
}

class Solution {
    fun takeCharacters(s: String, k: Int): Int {
        val n = s.length
        var j = 0
        var ans = n
        var window = 0
        val count = mutableMapOf('a' to 0, 'b' to 0, 'c' to 0)

        // 각 문자의 총 개수를 계산
        for (c in s) {
            count[c] = count.getOrDefault(c, 0) + 1
        }

        // 조건 확인: k보다 적은 문자가 있으면 -1 반환
        if (count['a']!! < k || count['b']!! < k || count['c']!! < k) {
            return -1
        }

        // aabaaaacaabc
        // 슬라이딩 윈도우 진행
        for (i in s.indices) {
            count[s[i]] = count[s[i]]!! - 1
            window++

            // 조건을 만족하지 못하면 윈도우를 줄임
            while (count[s[i]]!! < k) {
                count[s[j]] = count[s[j]]!! + 1
                j++
                window--
            }

            // 최소 시간 갱신
            ans = minOf(ans, n - window)
        }

        return ans
    }
}

//class Solution {
//    fun takeCharacters(s: String, k: Int): Int {
//        if (k == 0) return 0
//        var left = 0
//        var right = s.length - 1
//        var ans = Int.MAX_VALUE
//        var a = 0
//        var b = 0
//        var c = 0
//
//        while (left < s.length) {
//            val ch = s[left]
//            if (ch == 'a') ++a
//            if (ch == 'b') ++b
//            if (ch == 'c') ++c
//
//            // 왼쪽에서만 간 케이스
//            if (isEnough(a, b, c, k)) {
//                ans = minOf(ans, left + 1)
//                break
//            }
//            ++left
//        }
//        if (ans == Integer.MAX_VALUE) return -1
//
//        while (left <= right && left >= 0) {
//            val rightC = s[right]
//            if (rightC == 'a') ++a
//            if (rightC == 'b') ++b
//            if (rightC == 'c') ++c
//            --right
//
//            while (left >= 0) {
//                var flag = false
//                if (s[left] == 'a' && a > k) {
//                    --a
//                    flag = true
//                }
//                if (s[left] == 'b' && b > k) {
//                    --b
//                    flag = true
//                }
//                if (s[left] == 'c' && c > k) {
//                    --c
//                    flag = true
//                }
//                if (!flag) {
//                    break
//                }
//                --left
//            }
//            ans = minOf(ans, left + 1 + s.length - right - 1)
//        }
//        return ans
//    }
//
//    private fun isEnough(a: Int, b: Int, c: Int, k: Int): Boolean {
//        return a >= k && b >= k && c >= k
//    }
//}