package p164

import kotlin.math.max
import kotlin.math.min

class Solution {
    // 버킷 정렬의 원리 이용
    fun maximumGap(nums: IntArray): Int {
        if (nums.size == 1) {
            return 0
        }
        val minv = nums.min()
        val maxv = nums.max()
        val oneBucketLength = max(1, (maxv - minv) / (nums.size - 1))
        val bucketCnt = (maxv - minv) / oneBucketLength + 1
        // min, max
        val arr = Array<Pair<Int, Int>?>(bucketCnt) {
            null
        }
        for (num in nums) {
            var idx = (num - minv) / oneBucketLength
            if (arr[idx] == null) {
                arr[idx] = Pair(num, num)
            } else {
                arr[idx] = Pair(
                    min(arr[idx]!!.first, num),
                    max(arr[idx]!!.second, num)
                )
            }
        }
        var ret = 0
        var prevMax = -1
        for (p in arr) {
            if (p == null) continue
            if (prevMax != -1) {
                ret = max(ret, p.first - prevMax)
            }
            prevMax = p.second
        }
        return ret
    }
}