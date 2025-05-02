// 432. All O`one Data Structure
fun main() {
    // ["AllOne","inc","inc","inc","inc","inc","inc","dec", "dec","getMinKey","dec","getMaxKey","getMinKey"]
    // [[],["a"],["b"],["b"],["c"],["c"],["c"],["b"],["b"],[],["a"],[],[]]
    val allOne = AllOne()

    allOne.inc("a")
    allOne.inc("b")
    allOne.inc("b")
    allOne.inc("c")
    allOne.inc("c")
    allOne.inc("c")
    allOne.dec("b")
    allOne.dec("b")
    println(allOne.getMinKey()) // a
    allOne.dec("a")
    println(allOne.getMaxKey()) // c
    println(allOne.getMinKey()) // c
}

//class AllOne {
//
//    val counter = HashMap<String, Long>()
//    val numbers = HashMap<Long, HashSet<String>>()
//
//    var maxValue: Long = -1
//    var minValue: Long = -1
//    var secondMinValue: Long = -1
//
//
//    fun inc(key: String) {
//        val newValue = (counter[key] ?: 0) + 1
//        counter[key] = newValue
//
//        if (maxValue == -1L || maxValue < newValue) {
//            maxValue = newValue
//        }
//        if (minValue == -1L || minValue > newValue) {
//            minValue = newValue
//        }
//        if (secondMinValue == -1L || (newValue > minValue && secondMinValue > newValue)) {
//            secondMinValue = newValue
//        }
//
//        if (newValue > 1L) {
//            numbers[newValue - 1]!!.remove(key)
//            if (numbers[newValue - 1]!!.size == 0 && minValue == newValue - 1) {
//                minValue = newValue
//            }
//        }
//        if (numbers[newValue] == null) {
//            numbers[newValue] = hashSetOf(key)
//        } else {
//            numbers[newValue]!!.add(key)
//        }
//    }
//
//    fun dec(key: String) {
//        if (counter[key] == 1L) {
//            counter.remove(key)
//            numbers[1L]!!.remove(key)
//            if (numbers[1L]!!.size == 0) {
//                minValue = -1L
//                if (maxValue == 1L) {
//                    maxValue = -1L
//                }
//            }
//        } else {
//            val newValue = counter[key]!! - 1
//            counter[key] = newValue
//
//            if (maxValue == -1L || maxValue < newValue) {
//                maxValue = newValue
//            }
//            if (minValue == -1L || minValue > newValue) {
//               minValue = newValue
//            }
//            if (secondMinValue == -1L || (newValue > minValue && secondMinValue > newValue)) {
//                secondMinValue = newValue
//            }
//
//            if (newValue > 1L) {
//                numbers[newValue + 1]!!.remove(key)
//                if (numbers[newValue + 1]!!.size == 0 && maxValue == newValue + 1) {
//                    maxValue = newValue
//                }
//            }
//            if (numbers[newValue] == null) {
//                numbers[newValue] = hashSetOf(key)
//            } else {
//                numbers[newValue]!!.add(key)
//            }
//        }
//    }
//
//    fun getMaxKey(): String {
//        return numbers[maxValue]?.first() ?: ""
//    }
//
//    fun getMinKey(): String {
//        return numbers[minValue]?.first() ?: ""
//    }
//}

class AllOne {

    // 각 문자열(key)의 카운트를 저장하는 해시맵
    private val countMap: MutableMap<String, Int> = mutableMapOf()

    // 각 카운트에 해당하는 노드를 저장하는 해시맵
    private val nodeMap: MutableMap<Int, Node> = mutableMapOf()

    // 이중 연결 리스트의 head와 tail (더미 노드로 사용할 수도 있음)
    private var head: Node? = null
    private var tail: Node? = null

    // 현재 최소 카운트 노드를 가리키는 포인터
    private var minNode: Node? = null

    // 현재 최대 카운트 노드를 가리키는 포인터
    private var maxNode: Node? = null

    // Node 클래스는 특정 카운트와 그 카운트에 해당하는 문자열 집합을 저장
    class Node(
        var count: Int,
        val keys: MutableSet<String> = mutableSetOf(),
        var prev: Node? = null,
        var next: Node? = null
    )

    init {
        // 초기 head와 tail은 더미 노드로 설정해 연결 리스트의 시작과 끝을 표시
        head = Node(0)
        tail = Node(0)
        head!!.next = tail
        tail!!.prev = head
    }

    // inc 함수: 문자열의 카운트를 증가시키는 함수
    fun inc(key: String) {
        val count = countMap.getOrDefault(key, 0)
        countMap[key] = count + 1

        // 이전 카운트에서 key를 제거하고, 새로운 카운트 노드로 key를 이동
        if (count > 0) {
            removeKeyFromNode(key, count)
        }
        addKeyToNode(key, count + 1)

        // 최소, 최대 카운트 노드 갱신
        if (minNode == null || minNode!!.count > 1) {
            minNode = nodeMap[1]
        }
        if (maxNode == null || maxNode!!.count < count + 1) {
            maxNode = nodeMap[count + 1]
        }
    }

    // dec 함수: 문자열의 카운트를 감소시키는 함수
    fun dec(key: String) {
        val count = countMap.getOrDefault(key, 0)
        if (count == 0) return

        if (count == 1) {
            countMap.remove(key)
            removeKeyFromNode(key, 1)
        } else {
            countMap[key] = count - 1
            removeKeyFromNode(key, count)
            addKeyToNode(key, count - 1)
        }

        // 최소, 최대 카운트 노드 갱신
        if (minNode != null && minNode!!.keys.isEmpty()) {
            minNode = minNode!!.next
        }
        if (maxNode != null && maxNode!!.keys.isEmpty()) {
            maxNode = maxNode!!.prev
        }
    }

    // getMaxKey 함수: 최대 카운트를 가진 문자열을 반환
    fun getMaxKey(): String {
        return if (maxNode == null || maxNode!!.keys.isEmpty()) "" else maxNode!!.keys.first()
    }

    // getMinKey 함수: 최소 카운트를 가진 문자열을 반환
    fun getMinKey(): String {
        return if (minNode == null || minNode!!.keys.isEmpty()) "" else minNode!!.keys.first()
    }

    // 특정 카운트의 노드에서 key 제거
    private fun removeKeyFromNode(key: String, count: Int) {
        val node = nodeMap[count]
        if (node != null) {
            node.keys.remove(key)
            if (node.keys.isEmpty()) {
                removeNode(node)
                nodeMap.remove(count)
            }
        }
    }

    // 특정 카운트의 노드에 key 추가
    private fun addKeyToNode(key: String, count: Int) {
        var node = nodeMap[count]
        if (node == null) {
            node = Node(count)
            nodeMap[count] = node
            insertNodeAfter(nodeMap[count - 1], node)
        }
        node.keys.add(key)
    }

    // 연결 리스트에서 노드 제거
    private fun removeNode(node: Node) {
        node.prev?.next = node.next
        node.next?.prev = node.prev
    }

    // 연결 리스트에 노드 삽입
    private fun insertNodeAfter(prevNode: Node?, newNode: Node) {
        val nextNode = prevNode?.next
        prevNode?.next = newNode
        newNode.prev = prevNode
        newNode.next = nextNode
        nextNode?.prev = newNode
    }
}
