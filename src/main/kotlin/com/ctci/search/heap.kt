package com.ctci.search

class MinHeap {
	val elements = ArrayList<Int>()

	//i is root, 2i is left, 2i + 1 is right
	fun extractMin(): Int? {
		elements.firstOrNull()?.let { first ->
			elements.remove(0)
			elements.lastOrNull()?.let { last ->
				sinkDown(last)
			}
			return first
		}
		return null
	}

	fun put(n: Int) {
		elements.add(n)
		swimUp()
	}

	fun sinkDown(n: Int) {

	}

	fun swimUp() {

	}
}
