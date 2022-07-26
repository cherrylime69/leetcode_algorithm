package codesquad.secondWeek

import java.util.*

fun main() {
    val first = FirstQuestion()
    println(first.solution(5,
    arrayOf(
        intArrayOf(1,2,1),
        intArrayOf(2,3,3),
        intArrayOf(5,2,2),
        intArrayOf(1,4,2),
        intArrayOf(5,3,1),
        intArrayOf(5,4,2),
    ),3))
}

class FirstQuestion {
    data class Node(
        val value: Int,
        val index: Int
    ) : Comparable<Node> {
        override fun compareTo(other: Node): Int = value
    }

    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
        val graph = road.toGraph(N)
        val que = PriorityQueue<Node>()
        val distance = MutableList<Int>(N + 1) { 5000001 }
        distance[1] = 0
        que.add(Node(distance[1], 1))

        while (que.isNotEmpty()) {
            val (dist, now) = que.poll()
            if (distance[now] < dist) continue

            for (i in graph[now]) {
                val totalDist = i[1] + dist
                if (totalDist < distance[i[0]] && totalDist <= k) {
                    distance[i[0]] = totalDist
                    que.add(Node(totalDist, i[0]))
                }
            }


        }

        return distance.count { it <= k }
    }

    private fun Array<IntArray>.toGraph(size: Int): List<MutableList<List<Int>>> {

        this.sortBy { it[0] }
        val valueList = List<MutableList<List<Int>>>(size + 1) { mutableListOf() }

        this.forEach {
            valueList[it[0]].add(listOf(it[1], it[2]))
            valueList[it[1]].add(listOf(it[0], it[2]))
        }

        return valueList
    }

    /*fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
       val dist = MutableList<Int>(N + 1) { 5000001 }
       val visited = MutableList(N + 1) { false }
       val graph = road.toSeparate(N)
       dist[1] = 0
       visited[1] = true

       for (a in graph[1]) {
           dist[a[0]] = a[1]
       }

       for (i in 0 until dist.size) {
           val currentNodeIndex = getSmallestNodeIndex(dist, visited)
           visited[currentNodeIndex] = true
           println("$currentNodeIndex : ${graph[currentNodeIndex]}")
           for (j in graph[currentNodeIndex]) {
               val totalDistance = dist[currentNodeIndex] + j[1]
               if (totalDistance < dist[j[0]]) {
                   dist[j[0]] = totalDistance
               }

           }
       }
       println(dist)
       return dist.count { it <= k }
   }

    private fun getSmallestNodeIndex(dist: List<Int>, visited: MutableList<Boolean>): Int {
       var currentNodeIndex = 1
       var min = 500001
       for (i in 2 until visited.size) {
           if (dist[i] < min && !visited[i]) {
               min = dist[i]
               println("min ${min}")
               currentNodeIndex = i
           }
       }
       return currentNodeIndex
   }*/


}
