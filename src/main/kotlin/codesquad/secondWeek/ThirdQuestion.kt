package codesquad.secondWeek

import java.util.*

fun main() {
    val third = ThirdQuestion()
    println(third.solution(6, arrayOf(
        intArrayOf(3, 6),
        intArrayOf(4, 3),
        intArrayOf(3, 2),
        intArrayOf(1, 3),
        intArrayOf(1, 2),
        intArrayOf(2, 4),
        intArrayOf(5, 2),
    )))
}

class ThirdQuestion {
    private fun Array<IntArray>.toGraph(): List<List<Int>> {
        val graph =MutableList(this.size){mutableListOf<Int>()}
        this.forEach{
            graph[it[0]].add(it[1])
            graph[it[1]].add(it[0])
        }
        return graph
    }

   /* fun solution(n: Int, edge: Array<IntArray>): Int {
        // BFS 로 구현
        val graph = edge.toGraph()
        val que: Queue<Int> = LinkedList<Int>().apply{this.offer(1)}
        val distance =MutableList<Int>(n + 1){Int.MAX_VALUE}.apply{
            this[0] = 0
            this[1] = 0
        }

        while (que.isNotEmpty()) {
            val currentNode = que.poll()
            for (i in graph[currentNode]) {
                val dist = 1 + distance[currentNode]
                if (dist < distance[i]) {
                    distance[i] = dist
                    que.offer(i)
                }
            }
        }

        val max = distance.maxOf{ it }
        return distance.count{ it== max}
    }*/

    fun solution(n: Int, edge: Array<IntArray>): Int {
        // DFS 로 구현
        val distance = IntArray(n + 1) { Int.MAX_VALUE }.apply {
            this[0] = 0
            this[1] = 0 }
        val visited = Array(n + 1) { false }.apply { this[1] = true }
        val graph = edge.toGraph()

        navigateGraph(graph, distance, visited, 1)
        val max = distance.maxOf { it }
        return distance.count { it == max }
    }

    private fun navigateGraph(
        graph: List<List<Int>>,
        distance: IntArray,
        visited: Array<Boolean>,
        currentNode: Int
    ) {
        if (graph[currentNode].isEmpty()) return

        visited[currentNode] = true
        graph[currentNode].forEach {
            val totalDist = 1 + distance[currentNode]
            if (totalDist < distance[it]) {
                distance[it] = totalDist
                navigateGraph(graph, distance, visited, it)
            }
        }
    }

}