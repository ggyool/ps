package p1865

class FindSumPairs(nums1: IntArray, nums2: IntArray) {

    val numList1 = nums1.toMutableList()
    val numList2 = nums2.toMutableList()
    val numCnt1 = mutableMapOf<Int, Int>()
    val numCnt2 = mutableMapOf<Int, Int>()

    init {
        for (num in numList1) {
            numCnt1.put(num, numCnt1.getOrDefault(num, 0) + 1)
        }
        for (num in numList2) {
            numCnt2.put(num, numCnt2.getOrDefault(num, 0) + 1)
        }
    }

    fun add(index: Int, `val`: Int) {
        val before= numList2[index]
        numList2[index] += `val`
        numCnt2.put(before, numCnt2.get(before)!! - 1)
        numCnt2.put(numList2[index], numCnt2.getOrDefault(numList2[index], 0) + 1)
    }

    fun count(tot: Int): Int {
        var ret = 0
        for ((k, v) in numCnt1) {
            if (tot - k <= 0) continue
            val cnt = numCnt2[tot - k] ?: continue
            ret += (v * cnt)
        }
        return ret
    }
}
