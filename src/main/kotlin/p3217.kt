package p3217

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun modifiedList(nums: IntArray, head: ListNode?): ListNode? {
        val set = nums.toHashSet()
        var tmp: ListNode? = head
        val list = mutableListOf<ListNode>()
        while (tmp != null) {
            if (!set.contains(tmp.`val`)) {
                list.add(tmp)
            }
            tmp = tmp.next
        }

        for (i in 0 until list.size - 1) {
            list[i].next = list[i + 1]
        }
        list[list.size - 1].next = null
        return list[0]
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}