package codesquad.thirdWeek

import java.util.*

fun main() {
    val subSecond = SubSecondQuestion()
    subSecond.solution(2).forEach {
        println(it.contentToString())
    }

    subSecond.solution(3).forEach {
        println(it.contentToString())
    }
}

class SubSecondQuestion {

    fun solution(n: Int): Array<IntArray> {
        val answer = mutableListOf<IntArray>()
        runHanoiTower(1, 3, 2, n, answer)
        return answer.toTypedArray()
    }

    private fun runHanoiTower(departure: Int, arrival: Int, passBy: Int, count: Int, answer: MutableList<IntArray>) {
        if (count == 1) answer.add(intArrayOf(departure, arrival))
        else {
            val previousRing = count - 1
            runHanoiTower(departure, passBy, arrival, previousRing, answer)
            answer.add(intArrayOf(departure, arrival))
            runHanoiTower(passBy, arrival, departure, previousRing, answer)
        }
    }
}

/*
class Solution {
    fun solution(n: Int): Array<IntArray> {
        val answer = mutableListOf<IntArray>()
        runHanoiTower(1, 3, n, answer)
        return answer.toTypedArray()
    }

    private fun runHanoiTower(departure: Int, arrival: Int, count: Int, answer: MutableList<IntArray>) {
        if (count == 0) return

        val previousRing = count - 1
        val previousArrival =
            if ((departure == 1 && arrival == 2) || (departure == 2 && arrival == 1)) 3
            else if ((departure == 1 && arrival == 3) || (departure == 3 && arrival == 1)) 2
            else 1

        runHanoiTower(departure, previousArrival, previousRing, answer)
        answer.add(intArrayOf(departure, arrival))

        // newDeparture = 새로운 출발지, arrival = 새로운 도착지
        if (count == 1) return
        val newDeparture =
            if ((departure == 2 && arrival == 3) || (departure == 3 && arrival == 2)) 1
            else if ((departure == 1 && arrival == 2) || (departure == 2 && arrival == 1)) 3
            else 2

        runHanoiTower(newDeparture, arrival, previousRing, answer)
    }
}*/
