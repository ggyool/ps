package p3021

class Solution {
    fun flowerGame(n: Int, m: Int): Long {
        // 홀수개여야 승리
        // n의 홀수개 * m의 짝수개 + n의 짝수개 * m의 홀수개
        return (n / 2L + n % 2L) * (m / 2L) + (n / 2L) * (m / 2L + m % 2L)
    }
}
