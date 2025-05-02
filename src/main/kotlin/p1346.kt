package p1346

class Solution {
    fun checkIfExist(arr: IntArray): Boolean {
        val st = hashSetOf<Int>()
        for (num in arr) {
            if (st.contains(num * 2)) {
                return true
            }
            if (num % 2 == 0 && st.contains(num / 2 )) {
                return true
            }
            st.add(num)
        }
        return false
    }
}