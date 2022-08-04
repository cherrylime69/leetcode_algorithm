package codesquad.fourthWeek

import java.util.*

fun main() {
    val secondQuestion = SecondQuestion()
    println(secondQuestion.solution(4))
//    println(secondQuestion.solution(0))
//    println(secondQuestion.solution(1))
//    println(secondQuestion.solution(2))
//    println(secondQuestion.solution(3))
//    println(secondQuestion.solution(5))
}

class SecondQuestion {

    private val dx = listOf(1, -1, 0, 0, 1, -1, 1, -1)
    private val dy = listOf(0, 0, 1, -1, 1, -1, -1, 1)

    fun solution(n: Int): Int {
//        val totalCount = HashSet<String>()
        var totalCount = 0
        var startX = 1
        var startY = 1

        repeat(n * n) {
            val chessBoard = Array(n + 1) { Array(n + 1) { true } }
            val stack = Stack<List<Int>>()
            var count = n
            repeat(8) {
                dfs(chessBoard, stack, it, n, startX, startY)
            }
            count--
//            for (i in startX + 1 until n + 1) {
//                val newChessBoard = chessBoard.toList().toTypedArray()
//                for (j in 1 until n + 1) {
//                    if (startY == j) continue
//                    if (chessBoard[i][j]) {
//                        repeat(8) {
//                            dfs(chessBoard, stack, it, n, i, j)
//                        }
//                        count--
//                    }
//                }
//            }

            var nextX = startX + 1
            var newChessBoard = chessBoard.toList().toTypedArray()

            while (nextX <= n) {
                var nextY = 1
                while (nextY <= n) {
                    if (newChessBoard[nextX][nextY]) {
                        repeat(8) {
                            dfs(newChessBoard, stack, it, n, nextX, nextY)
                        }
                        count--
                    }
                    if (count == 0) break
                    nextY++
                }
                nextX++
                newChessBoard = newChessBoard.toList().toTypedArray()
            }


            if (count == 0) {
                totalCount++
                println(" 찐이다~~ x: $startX y: $startY")
            }
            println("x: $startX y: $startY")
            chessBoard.forEach {
                println(it.contentToString())
            }
            println("---------")
            if (startY == n) {
                startX++
                startY = 1
            } else startY++
        }

        println(totalCount)
        return totalCount
    }

    private fun dfs(
        chessBoard: Array<Array<Boolean>>,
        stack: Stack<List<Int>>,
        direction: Int,
        n: Int,
        x: Int,
        y: Int
    ) {
        stack.push(listOf(y, x))
        while (stack.isNotEmpty()) {
            val node = stack.pop()
            val nx = node[1] + dx[direction]
            val ny = node[0] + dy[direction]

            if (nx > 0 && ny > 0 && nx <= n && ny <= n) {
                if (chessBoard[nx][ny]) {
                    chessBoard[nx][ny] = false
                }
                stack.push(listOf(ny, nx))
            }
        }
    }
}