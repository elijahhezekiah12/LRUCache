package org.example

class LRUCache(private val capacity:Int) {

    private data class Node(var key:Int, var value:Int){

        var prev:Node? = null
        var next:Node? = null
    }

    private val cache = HashMap<Int, Node>()
    private val head  = Node(0,0)
    private val tail  = Node(0,0)

    init {
        head.next = tail
        tail.prev = head
    }

    private fun remove(node: Node) {
        node.prev?.next = node.next
        node.next?.prev = node.prev
    }

    private fun moveToFrontOfNode(node: Node){
        node.next = head.next
        node.prev = head
        head.next?.prev = node
        head.next = node

    }

    fun get(key: Int):Int{
        val node = cache[key] ?: return -1
        remove(node)
        moveToFrontOfNode(node)
        return node.value
    }

    fun put(key:Int, value: Int){
        if (cache.containsKey(key)){
            remove(cache[key]!!)
        }
        val newNode = Node(key, value)
        moveToFrontOfNode(newNode)
        cache[key] = newNode

        if (cache.size > capacity){
             val lru = tail.prev!!
            remove((lru))
            cache.remove(lru.key)
        }
    }

}