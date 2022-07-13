package codesquad.firstWeek

fun main() {
    val second = SecondMission()
    println(second.solution("ULURRDLLU"))
    println(second.solution("LULLLLLLU"))
    println(second.solution("RDLURRDLLU"))
}

class SecondMission {

    fun solution(dirs: String): Int {
        var answer = 0
        val end = 5
        val start = -5
        val top = 5
        val bottom = -5
        var previousPos: MutableList<Int>
        val currentPos = mutableListOf(0, 0)
        val resultSet = HashSet<List<List<Int>>>()

        dirs.forEach {
            when (it) {
                'U' -> {
                    if (currentPos[1] < top) {
                        previousPos = currentPos.toMutableList()
                        currentPos[1] += 1
                        resultSet.add(listOf(previousPos, currentPos))
                    }
                }
                'D' -> {
                    if (currentPos[1] > bottom) {
                        previousPos = currentPos.toMutableList()
                        currentPos[1] -= 1
                        resultSet.add(listOf(previousPos, currentPos))
                    }
                }
                'R' -> {
                    if (currentPos[0] < end) {
                        previousPos = currentPos.toMutableList()
                        currentPos[0] += 1
                        resultSet.add(listOf(previousPos, currentPos))
                    }
                }
                'L' -> {
                    if (currentPos[0] > start) {
                        previousPos = currentPos.toMutableList()
                        currentPos[0] -= 1
                        resultSet.add(listOf(previousPos, currentPos))
                    }
                }
            }
        }
        answer = resultSet.size
        return answer
    }

}