package dataStructure

import linkedList.`Reverse Linked List`
import java.util.*
import kotlin.collections.LinkedHashMap

fun main() {

    Graph().runAdjacencyMatrix()
    Graph().runAdjacencyList()

}

class Graph {

    // 인접 행렬
    fun runAdjacencyMatrix() {
        val graph = arrayOf(
            arrayOf(0, 1, 0, 1, 0),
            arrayOf(1, 0, 1, 0, 0),
            arrayOf(0, 1, 0, 0, 0),
            arrayOf(1, 0, 0, 1, 1),
            arrayOf(0, 1, 0, 1, 0)
        )

        for ((index1, values) in graph.withIndex()) {
            val node = when (index1) {
                0 -> 'A'
                1 -> 'B'
                2 -> 'C'
                3 -> 'D'
                else -> 'E'
            }
            print("$node : ")
            for ((index2, value) in values.withIndex()) {
                if (value == 1) {
                    val connectedNode = when (index2) {
                        0 -> 'A'
                        1 -> 'B'
                        2 -> 'C'
                        3 -> 'D'
                        else -> 'E'
                    }
                    print("$connectedNode")
                }
            }
            println()
        }

    }

    // 인접 리스트
    fun runAdjacencyList() {
        val graph = LinkedHashMap<Char, LinkedList<Char>>()
        graph.run {
            set('A', LinkedList())
            get('A')?.run {
                add('B')
                add('D')
            }
            set('B', LinkedList())
            get('B')?.run {
                add('A')
                add('C')
            }

            set('C', LinkedList())
            get('C')?.run {
                add('B')
            }
            set('D', LinkedList())
            get('D')?.run {
                add('A')
                add('E')
            }
            set('E', LinkedList())
            get('E')?.run {
                add('B')
                add('D')
            }
        }

        println(graph)
    }
}

