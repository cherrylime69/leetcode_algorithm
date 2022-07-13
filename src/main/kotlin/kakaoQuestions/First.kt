package kakaoQuestions
fun main() {
    val first = First()
//    println(first.solution(arrayOf(intArrayOf(0,0,1,0,0), intArrayOf(0,1,1,0,1), intArrayOf(0,0,1,0,1), intArrayOf(1,1,1,0,1))))

    val second = First()
    println(second.solution(arrayOf(intArrayOf(1,0,1,1), intArrayOf(0,0,1,1), intArrayOf(1,1,0,1), intArrayOf(1,1,0,0))))

}


class First {

    fun solution(maps: Array<IntArray>): Int {
        var answer = 0

        for (i in maps.indices) {
            for (j in maps[i].indices) {
                answer += dfs(maps, i, j)
            }
        }

        return answer
    }

    fun dfs(maps: Array<IntArray>, x: Int, y: Int): Int {
        var result = 0
        val n = maps.size
        val m = maps[0].size

        if (x <= -1 || x >= n || y <= -1 || y >= m) {
            return result
        }

        if (maps[x][y] == 1) {
            if (x - 1 <= -1 || x + 1 >= n || y - 1 <= -1 || y + 1 >= m) {
                if (x - 1 <= -1) {
                    result += 1
                }
                if (x + 1 >= n) {
                    result += 1
                }
                if (y - 1 <= -1) {
                    result += 1
                }
                if (y + 1 >= m) {
                    result += 1
                }
            }

            if (x - 1 >= 0) {
                if (maps[x - 1][y] == 0) {
                    result += 1
                }
            }

            if (x + 1 < n) {
                if (maps[x + 1][y] == 0) {
                    result += 1
                }
            }

            if (y - 1 >= 0) {
                if (maps[x][y - 1] == 0) {
                    result += 1
                }
            }

            if (y + 1 < m) {
                if (maps[x][y + 1] == 0) {
                    result += 1
                }
            }

            /*if (x - 1 <= -1 || x + 1 >= n || y - 1 <= -1 || y + 1 >= m) {
                if (x - 1 <= -1) {
                    println("결과1: X: $x , Y: $y")
                    result += 1
                }
                if (x + 1 >= n) {
                    println("결과2: X: $x , Y: $y")
                    result += 1
                }
                if (y - 1 <= -1) {
                    println("결과3: X: $x , Y: $y")
                    result += 1
                }
                if (y + 1 >= m) {
                    println("결과4: X: $x , Y: $y")
                    result += 1
                }
            } else {
                if (maps[x - 1][y] == 0) {
                    println("결과5: X: $x , Y: $y")
                    result += 1
                }
                if (maps[x + 1][y] == 0) {
                    println("결과6: X: $x , Y: $y")
                    result += 1
                }
                if (maps[x][y - 1] == 0) {
                    println("결과7: X: $x , Y: $y")
                    result += 1
                }
                if (maps[x][y + 1] == 0) {
                    println("결과8: X: $x , Y: $y")
                    result += 1
                }
            }*/
            maps[x][y] = 2

            result += dfs(maps, x - 1, y)
            result += dfs(maps, x + 1, y)
            result += dfs(maps, x, y - 1)
            result += dfs(maps, x, y + 1)
        }
    return result
    }
}