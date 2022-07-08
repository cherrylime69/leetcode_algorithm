package linkedList

// https://leetcode.com/problems/reverse-linked-list/

fun main() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next?.next = ListNode(3)
    head.next?.next?.next = ListNode(4)
    head.next?.next?.next?.next = ListNode(5)
    var checkNode = `Reverse Linked List`().reverseList(head)

    while (checkNode != null) {
        println(checkNode.`val`)
        checkNode = checkNode.next
    }

}


class `Reverse Linked List` {
    /*fun reverseList(head: ListNode?): ListNode? {
        if (head == null) return null
        val nodeList = mutableListOf<ListNode>()
        var node = head

        while (node != null) {
            nodeList.add(ListNode(node.`val`))
            node = node.next
        }

        for (i in nodeList.size - 1 downTo 1) {
            nodeList[i].next = nodeList[i - 1]

        }
        return nodeList.last()
    }*/

    tailrec fun reverseList(head: ListNode?, pre: ListNode? = null): ListNode? {
        return if (head == null) {
            pre
        } else {
            val originNext = head.next
            head.next = pre
            reverseList(originNext, head)
        }
    }

}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}