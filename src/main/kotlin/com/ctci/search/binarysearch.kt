package com.ctci.search

import com.ctci.prettyPrint

fun IntArray.binarySearch(key: Int): Int {
	var low = 0
	var high = this.count() - 1
	var mid = 0

	while (high >= low) {
		mid = (high + low) ushr 1
		if (key == this[mid]) { return mid }
		else if (key < this[mid]) { high = mid - 1 }
		else if (key > this[mid]) { low = mid + 1 }
	}
	return -(low + 1)
}

fun main(args: Array<String>) {
	val array = IntArray(1000) { (0..1000).elementAt(it) }
	println(array.binarySearch(9999))
}