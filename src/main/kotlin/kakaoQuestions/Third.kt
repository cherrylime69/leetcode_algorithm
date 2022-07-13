package kakaoQuestions

fun main() {
    val third = Third()

//    println(third.solution(5))
//    println(third.solution(6))
    println(third.solution(11))
//    println(third.solution(1))
}


class Third {
    fun solution(k: Int): Long {
        val matchstick = arrayOf(6, 2, 5, 5, 4, 5, 6, 3, 7, 6)
        val matchMap = mutableMapOf<Int, MutableList<Int>>()
        val totalMatchStick = IntArray(51)
        var answer: Long = 0

        totalMatchStick[1] = 0
        totalMatchStick[2] = 1
        totalMatchStick[3] = 1
        totalMatchStick[4] = 2

        if (k < 10) {
            totalMatchStick[k] += matchstick.count {
                it == k
            }
        }

        for (num in 1 .. k) {
            for (i in 1 until matchstick.size) {
                val list = mutableListOf<Int>()
                for (j in matchstick.indices) {
                    if (matchstick[i] + matchstick[j] == num) {
                        list.add(j)
                    }
                }
                matchMap[i] = list
            }

            for (map in matchMap) {
                for (value in map.value) {
                    totalMatchStick[k] += totalMatchStick[matchstick[value]]
                }
            }

        }

        answer = totalMatchStick[k].toLong()
        return answer
    }
}