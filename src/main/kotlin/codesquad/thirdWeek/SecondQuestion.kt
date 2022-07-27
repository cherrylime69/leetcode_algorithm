package codesquad.thirdWeek

import java.util.*

fun main() {
    val second = SecondQuestion()
    println(
        second.solution(
            arrayOf(
                intArrayOf(1, 0, 1, 1, 1),
                intArrayOf(1, 0, 1, 0, 1),
                intArrayOf(1, 0, 1, 1, 1),
                intArrayOf(1, 1, 1, 0, 1),
                intArrayOf(0, 0, 0, 0, 1),
            )
        )
    )
    val second2 = SecondQuestion()
    println(
        second2.solution(
            arrayOf(
                intArrayOf(1, 0, 1, 1, 1),
                intArrayOf(1, 0, 1, 0, 1),
                intArrayOf(1, 0, 1, 1, 1),
                intArrayOf(1, 1, 1, 0, 0),
                intArrayOf(0, 0, 0, 0, 1),
            )
        )
    )

}

class SecondQuestion {

    fun solution(maps: Array<IntArray>): Int {
        val que: Queue<Array<Int>> = LinkedList<Array<Int>>().apply { offer(arrayOf(0, 0)) }
        val n = maps.size - 1
        val m = maps[0].size - 1

        val dx = listOf(-1, 1, 0, 0)
        val dy = listOf(0, 0, -1, 1)

        while (que.isNotEmpty()) {
            val current = que.poll()
            val x = current[0]
            val y = current[1]
            for (i in dx.indices) {
                val nx = x + dx[i]
                val ny = y + dy[i]
                if (nx < 0 || ny < 0 || nx > n || ny > m || maps[nx][ny] == 0) continue
                if (maps[nx][ny] == 1) {
                    maps[nx][ny] = maps[x][y] + 1
                    que.offer(arrayOf(nx, ny))
                } else if (maps[x][y] + 1 < maps[nx][ny]) {
                    maps[nx][ny] = maps[x][y] + 1
                    que.offer(arrayOf(nx, ny))
                }
            }
        }

        if (maps[n][m] == 1) maps[n][m] = -1
        return maps[n][m]
    }

    /*fun dfs(maps: Array<IntArray>, x: Int, y: Int, previousValue: Int) {
        val n = maps.size - 1
        val m = maps[0].size - 1
        val currentValue = previousValue + 1

        if (x < 0 || x > m || y < 0 || y > n || maps[x][y] == 0) return

        if (maps[x][y] == 1) {
            maps[x][y] = currentValue
            dfs(maps, x + 1, y, currentValue)
            dfs(maps, x, y + 1, currentValue)
            dfs(maps, x - 1, y, currentValue)
            dfs(maps, x, y - 1, currentValue)
        } else if (maps[x][y] < currentValue) {
            dfs(maps, x + 1, y, maps[x][y])
            dfs(maps, x, y + 1, maps[x][y])
            dfs(maps, x - 1, y, maps[x][y])
            dfs(maps, x, y - 1, maps[x][y])
        }
    }*/
}