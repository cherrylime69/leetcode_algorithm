package codesquad.firstWeek

fun main() {
    val second = SecondMission()
    println(second.solution("ULURRDLLU"))
    println(second.solution("LULLLLLLU"))
    println(second.solution("RDLURRDLLU"))
    println(second.solution("UDU"))
}

class SecondMission {

    /*fun solution(dirs: String): Int {
        var answer = 0
        val end = 5
        val start = -5
        val top = 5
        val bottom = -5
        var previousPos: MutableList<Int>
        val currentPos = mutableListOf(0, 0)
        val resultSet = HashSet<String>()

        dirs.forEach {
            when (it) {
                'U' -> {
                    if (currentPos[1] < top) {
                        previousPos = currentPos.toMutableList()
                        currentPos[1] += 1
                        resultSet.add(previousPos.toString() + currentPos.toString())
                        resultSet.add(currentPos.toString() + previousPos.toString())
                    }
                }
                'D' -> {
                    if (currentPos[1] > bottom) {
                        previousPos = currentPos.toMutableList()
                        currentPos[1] -= 1
                        resultSet.add(previousPos.toString() + currentPos.toString())
                        resultSet.add(currentPos.toString() + previousPos.toString())
                    }
                }
                'R' -> {
                    if (currentPos[0] < end) {
                        previousPos = currentPos.toMutableList()
                        currentPos[0] += 1
                        resultSet.add(previousPos.toString() + currentPos.toString())
                        resultSet.add(currentPos.toString() + previousPos.toString())
                    }
                }
                'L' -> {
                    if (currentPos[0] > start) {
                        previousPos = currentPos.toMutableList()
                        currentPos[0] -= 1
                        resultSet.add(previousPos.toString() + currentPos.toString())
                        resultSet.add(currentPos.toString() + previousPos.toString())
                    }
                }
            }
        }
        answer = resultSet.size / 2
        return answer
    }*/

    companion object {
        const val TOP = 5
        const val BOTTOM = -5
        const val LEFT = -5
        const val RIGHT = 5
    }

    fun solution(dirs: String): Int {
        val currentPos = mutableListOf(0, 0)
        val command = mapOf(
            'U' to Pair(0, 1),
            'D' to Pair(0, -1),
            'R' to Pair(1, 0),
            'L' to Pair(-1, 0)
        )
        val answerSet = mutableSetOf<String>()

        dirs.forEach {
            val x = currentPos[0]
            val y = currentPos[1]
            val (nx, ny) = command[it]!!

            if (x + nx <= RIGHT && x + nx >= LEFT && y + ny >= BOTTOM && y + ny <= TOP) {
                currentPos[0] += nx
                currentPos[1] += ny
                answerSet.add("${currentPos[0]}${currentPos[1]}$x$y")
                answerSet.add("$x$y${currentPos[0]}${currentPos[1]}")
            }
        }

        return answerSet.size / 2
    }


}