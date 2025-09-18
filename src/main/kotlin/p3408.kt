package p3408

import java.util.TreeSet

class TaskManager(tasks: List<List<Int>>) {

    val taskMap = HashMap<Int, Task>()
    val taskTree = TreeSet<Task>()

    init {
        for ((userId, taskId, priority) in tasks) {
            val task = Task(taskId, userId, priority)
            taskMap[taskId] = task
            taskTree.add(task)
        }
    }

    fun add(userId: Int, taskId: Int, priority: Int) {
        val task = Task(taskId, userId, priority)
        taskTree.add(task)
        taskMap[taskId] = task
    }

    fun edit(taskId: Int, newPriority: Int) {
        val beforeTask = taskMap[taskId]!!
        val newTask = Task(taskId, beforeTask.userId, newPriority)

        taskMap[taskId] = newTask
        taskTree.remove(beforeTask)
        taskTree.add(newTask)
    }

    fun rmv(taskId: Int) {
        val task = taskMap[taskId]!!
        taskMap.remove(taskId)
        taskTree.remove(task)
    }

    fun execTop(): Int {
        val task = taskTree.firstOrNull()
        if (task != null) {
            rmv(task.taskId)
            return task.userId
        }
        return -1
    }
}

data class Task(val taskId: Int, val userId: Int, val priority: Int) : Comparable<Task> {
    override fun compareTo(other: Task): Int {
        if (priority == other.priority) {
            return other.taskId - taskId
        }
        return other.priority - priority
    }
}