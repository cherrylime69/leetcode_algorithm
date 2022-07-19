package codesquad.firstWeek

import java.util.*

fun main() {
    val subFourth = SubFourthQuestion()
    println(subFourth.solution(intArrayOf(93, 30, 55), intArrayOf(1, 30, 5)).toList())
    println(subFourth.solution(intArrayOf(95, 90, 99, 99, 80, 99), intArrayOf(1, 1, 1, 1, 1, 1)).toList())
}

class SubFourthQuestion {

    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val answer = mutableListOf<Int>()
        val progressList = progresses.toMutableList()
        val speedsList = speeds.toMutableList()
        var count = 0

        while (progressList.isNotEmpty()) {
            for (i in progressList.indices) {
                progressList[i] += speedsList[i]
            }

            while (progressList.isNotEmpty() && progressList.first() >= 100) {
                progressList.removeFirst()
                speedsList.removeFirst()
                count++
            }

            if (count > 0) {
                answer.add(count)
                count = 0
            }
        }

        return answer.toIntArray()
    }

}