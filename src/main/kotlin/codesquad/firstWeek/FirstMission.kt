package codesquad.firstWeek

import java.util.LinkedList
import java.util.Queue

fun main() {

    val first = FirstMission()
//    println(first.solution(intArrayOf(2, 1, 3, 2), 2))
    println(first.solution(intArrayOf(1, 1, 9, 1, 1, 1), 0))

}

class FirstMission {

    /*fun solution(priorities: IntArray, location: Int): Int {
        val que = priorities.toMutableList()
        var answer = 0
        var locationIndex = location
        val result = mutableListOf<Int>()
        var highestNum = que.maxOrNull() ?: 0

        while (result.size != priorities.size) {
            if (que[0] >= highestNum) {
                result.add(que[0])
                que.removeAt(0)
                highestNum = que.maxOrNull() ?: 0
                if (locationIndex == 0) {
                    return result.size
                } else {
                    locationIndex--
                }
            } else {
                que.add(que[0])
                que.removeAt(0)
                if (locationIndex > 0) {
                    locationIndex--
                } else {
                    locationIndex = que.size - 1
                }
            }
        }

        return answer
    }*/

    fun solution(priorities: IntArray, location: Int): Int {
        val que: Queue<Int> = LinkedList<Int>()
        que.addAll(priorities.toList())
        var answer = 0
        var locationIndex = location
        val result: Queue<Int> = LinkedList<Int>()
        var highestNum = que.maxOrNull() ?: 0


        while (result.size != priorities.size) {
            if (que.peek() >= highestNum) {
                result.add(que.poll())
                highestNum = que.maxOrNull() ?: 0
                if (locationIndex == 0) {
                    return result.size
                } else {
                    locationIndex--
                }
            } else {
                que.add(que.poll())
                if (locationIndex > 0) {
                    locationIndex--
                } else {
                    locationIndex = que.size - 1
                }
            }
        }

        return answer
    }

}