package p2566

class Solution {
    fun minMaxDifference(num: Int): Int {
        return replaceBig(num) - replaceSmall(num)
    }

    private fun replaceBig(num: Int): Int {
        var target: Char = '9'
        val s = num.toString()
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

    private fun replaceSmall(num: Int): Int {
        var target: Char = '0'
        val s = num.toString()
        for (c in s) {
            if (c != '0') {
                target = c
                break
            }
        }
        val sb = StringBuilder()
        for (c in s) {
            if (c == target) {
                sb.append('0')
            } else {
                sb.append(c)
            }
        }
        return sb.toString().toInt()
    }
}