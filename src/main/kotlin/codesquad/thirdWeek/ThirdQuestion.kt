package codesquad.thirdWeek

fun main() {
    val third = ThirdQuestion()
    println(third.solution(
        6,
        intArrayOf(7, 10)
    ))

}

class ThirdQuestion {
    fun solution(n: Int, times: IntArray): Long {
        var start = 1L
        var end: Long = times.maxOf { it.toLong() } * n
        var answer = 0L

        while (start <= end) {
            val mid = (end + start) / 2
            var passedPassenger = 0L
            times.forEach {
                passedPassenger += (mid / it)
            }

            if (passedPassenger >= n) {
                end = mid -1
                answer = mid
            } else {
                start = mid + 1
            }

            /*if (passedPassenger == n.toLong()) {
                answer = mid
                times.forEach {
                    passedPassenger += (mid - 1) / it
                }
                if (passedPassenger == n.toLong()) answer = mid - 1
                break
            } else if (passedPassenger > n) {
                end = mid - 1
            } else {
                start = mid + 1
            }*/
        }

        return answer
    }
}