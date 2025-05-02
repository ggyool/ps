package p3133

fun main() {
    println(Solution().minEnd(3, 4))
}



// 비트 연산으로 하는 방법
//class Solution {
//    fun minEnd(n: Int, x: Int): Long {
//        var v = (n - 1).toLong()  // n에서 1을 뺀 값을 Long 타입으로 변환하여 v에 저장
//        var result = x.toLong()    // 결과값에 x의 값을 시작값으로 설정
//        var shift = 0              // 비트 이동(shift)의 수를 추적하는 변수
//
//        while (v != 0L) {
//            val test = 1L shl shift   // 현재 shift 위치에서 1을 왼쪽으로 이동한 값
//            if ((result and test) == 0L) {
//                // result의 현재 위치가 0인 경우, v의 해당 비트를 result에 추가
//                result = result or ((v and 1L) shl shift)
//                v = v shr 1          // v를 오른쪽으로 1비트 시프트하여 다음 비트 준비
//            }
//            shift += 1               // 다음 비트 위치로 이동
//        }
//
//        return result
//    }
//}

// 아이디어는 좋은데 n걸리는 풀이
//class Solution {
//    fun minEnd(n: Int, x: Int): Long {
//        var a = x.toLong()
//        val longX = x.toLong()
//        for (i in 0 until n - 1) {
//            a = (a+1) or longX
//        }
//        return a
//    }
//}

// 내 첫 풀이
//class Solution {
//    fun minEnd(n: Int, x: Int): Long {
//        val xBin = x.toString(2)
//        val bin = (n - 1).toString(2)
//        val stk = Stack<Char>()
//        var xBinIdx = 0
//        var binIdx = 0
//        while (xBinIdx < xBin.length && binIdx < bin.length) {
//            if (xBinIdx < xBin.length) {
//                if (xBin[xBin.length - xBinIdx - 1] == '1') {
//                    stk.add('1')
//                } else {
//                    stk.add(bin[bin.length - binIdx - 1])
//                    binIdx++
//                }
//                xBinIdx++
//            }
//        }
//
//        while (xBinIdx < xBin.length) {
//            stk.add(xBin[xBin.length - xBinIdx - 1])
//            xBinIdx++
//        }
//
//        while (binIdx < bin.length) {
//            stk.add(bin[bin.length - binIdx - 1])
//            binIdx++
//        }
//
//        val sb = StringBuilder()
//        while (!stk.isEmpty()) {
//            sb.append(stk.pop())
//        }
//        return sb.toString().toLong(2)
//    }
//}

// 비트연산으로 푸는거 보고 따라푼 풀이
class Solution {
    fun minEnd(n: Int, x: Int): Long {
        var v = (n - 1).toLong()
        var s = 0
        val lx = x.toLong()
        var ret = x.toLong()

        while (v > 0) {
            val test = lx and (1L shl s)
            if (test == 0L) {
                ret = ret or ((v and 1) shl s)
                v = v shr 1
            }
            s++
        }
        return ret
    }
}
