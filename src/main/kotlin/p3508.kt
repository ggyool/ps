package p3508

import java.util.LinkedList

class Router(val memoryLimit: Int) {

    val queue = LinkedList<Packet>()
    val checkPacket = HashSet<Packet>()

    // destination, <Timestamp>
    val listMap = HashMap<Int, MutableList<Int>>()

    fun addPacket(source: Int, destination: Int, timestamp: Int): Boolean {
        val packet = Packet(source, destination, timestamp)
        if (checkPacket.contains(packet)) {
            return false
        }
        if (queue.size == memoryLimit) {
            forwardPacket()
        }
        queue.add(packet)
        checkPacket.add(packet)
        val list = listMap.computeIfAbsent(destination) { ArrayList() }
        list.add(timestamp)
        return true
    }

    fun forwardPacket(): IntArray {
        if (queue.isEmpty()) {
            return intArrayOf()
        }
        val packet = queue.removeFirst()
        checkPacket.remove(packet)
        val list = listMap[packet.destination]!!
        list.removeFirst()
        return intArrayOf(packet.source, packet.destination, packet.timestamp)
    }

    fun getCount(destination: Int, startTime: Int, endTime: Int): Int {
        val list = listMap[destination] ?: return 0
        return list.upperBound(endTime) - list.lowerBound(startTime)
    }

    data class Packet(val source: Int, val destination: Int, val timestamp: Int)
}

fun List<Int>.lowerBound(target: Int, startIdx: Int = 0, endIdx: Int = this.size): Int {
    var left = startIdx
    var right = endIdx
    while (left < right) {
        val mid = left + (right - left) / 2
        if (this[mid] < target) {
            left = mid + 1
        } else {
            right = mid
        }
    }
    return right
}

fun List<Int>.upperBound(target: Int, startIdx: Int = 0, endIdx: Int = this.size): Int {
    var left = startIdx
    var right = endIdx
    while (left < right) {
        val mid = left + (right - left) / 2
        if (this[mid] <= target) {
            left = mid + 1
        } else {
            right = mid
        }
    }
    return right
}
