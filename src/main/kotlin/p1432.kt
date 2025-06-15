package p1432

class Solution {
    fun maxDiff(num: Int): Int {
        return genBigNumber(num) - genSmallNumber(num)
    }

    private fun genBigNumber(num: Int): Int {
        val s = num.toString()
        var target = '9'
        for (c in s) {
            if (c != '9') {
                target = c
                break
            }
        }
        val sb = StringBuilder()
        for (c in s) {
            if (c == target) {
                sb.append('9')
            } else {
                sb.append(c)
            }
        }
        return sb.toString().toInt()
    }

    private fun genSmallNumber(num: Int): Int {
        val s = num.toString()
        var target = '-'
        for (c in s) {
            if (c != '1' && c != '0') {
                target = c
                break
            }
        }
        if (target == '-') {
            return num
        }
        val first = s[0]
        val change = if (target == first) '1' else '0'
        val sb = StringBuilder()
        for (c in s) {
            if (c == target) {
                sb.append(change)
            } else {
                sb.append(c)
            }
        }
        return sb.toString().toInt()
    }
}