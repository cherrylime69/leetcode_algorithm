package codesquad.secondWeek

import java.util.*

fun main() {
    val second = SecondQuestion()
    println(second.solution(arrayOf(
        "I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"
    )).contentToString())
}

class SecondQuestion {

    fun solution(operations: Array<String>): IntArray {
        val answer = intArrayOf(0, 0)
        val minHeap = PriorityQueue<Int>()
        val maxHeap = PriorityQueue<Int>(compareByDescending { it })

        operations.forEach {
            val command = it.command()
            when (command.first) {
                'I' -> {
                    minHeap.offer(command.second)
                    maxHeap.offer(command.second)
                }
                else -> {
                    if (minHeap.isEmpty())
                    else if (command.second < 0) {
                        maxHeap.remove(minHeap.poll())
                    } else {
                        minHeap.remove(maxHeap.poll())
                    }
                }
            }
        }

        if (minHeap.isNotEmpty()) {
            answer[0] = maxHeap.peek()
            answer[1] = minHeap.peek()
        }

        return answer
    }

    private fun String.command(): Pair<Char, Int> {
        return Pair(this[0], (this.substring(2, this.length)).toInt())
    }
}
