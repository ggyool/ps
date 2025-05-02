package comb


fun main() {
    val nums = intArrayOf(1, 2, 3, 4)
    val r = 2
    val combination = mutableListOf<Int>()

    generateCombinations(nums, r, 0, combination)
}

fun generateCombinations(nums: IntArray, r: Int, start: Int, combination: MutableList<Int>) {
    // 조합이 완성되었을 때 출력
    if (combination.size == r) {
        println(combination)
        return
    }

    // 조합 생성
    for (i in start until nums.size) {
        combination.add(nums[i])  // 현재 요소 추가
        generateCombinations(nums, r, i + 1, combination)  // 다음 단계로 재귀 호출
        combination.removeAt(combination.size - 1)  // 재귀가 끝나면 다시 요소 제거 (백트래킹)
    }
}