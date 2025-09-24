package p166

import kotlin.math.abs

class Solution {
    fun fractionToDecimal(numerator: Int, denominator: Int): String {
        val isMinus = (numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)
        val absNumero = abs(numerator.toLong())
        val absDenom = abs(denominator.toLong()).toLong()
        val map = HashMap<Long, Int>()
        val value = absNumero / absDenom
        var remainder = absNumero - (value * absDenom)
        val sb = StringBuilder()
        var i = 0
        var startIdx = -1
        while (remainder > 0) {
            remainder *= 10
            if (map.contains(remainder)) {
                startIdx = map[remainder]!!
                break
            } else {
                map[remainder] = i
            }
            sb.append(remainder / absDenom)
            remainder = remainder % absDenom
            i++
        }
        val res = if (sb.isEmpty()) {
            "$value"
        } else if (startIdx == -1) {
            "$value.$sb"
        } else {
            "$value.${sb.slice(0..<startIdx)}(${sb.slice(startIdx..<sb.length)})"
        }
        if (isMinus) {
            return "-$res"
        }
        return res
    }
}
