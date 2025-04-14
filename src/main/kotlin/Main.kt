package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
   val lruCache = LRUCache(4)
    lruCache.put(1, 1)
    lruCache.put(2, 2)
    lruCache.put(3, 3)
    lruCache.put(4, 4)

    println(lruCache.get(2))

    lruCache.put(5,5)

    println(lruCache.get(1))

    println(lruCache.get(5))

}