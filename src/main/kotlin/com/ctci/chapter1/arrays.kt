package com.ctci.chapter1

// 1.1
// check if a string has all unique characters


// take a fixed boolean array of 256 (for ascii chars)
fun allUnique0(str: String): Boolean {
	val flags = BooleanArray(256) { false }
	for (s in str) {
		if (flags[s.toInt()]) return false else flags[s.toInt()] = true
	}
	return true
}



// 1.2
// check if a string is permutation of another

// O(n lg n) solution
fun isPermutation0(s: String, t: String): Boolean {
	if (s.count() != t.count()) return false
 	return java.util.Arrays.equals(s.toCharArray().sortedArray(), t.toCharArray().sortedArray())
}

// O(n) solution. takes O(n) extra space
fun isPermutation1(s: String, t: String): Boolean {
	if (s.count() != t.count()) return false
	val chars = IntArray(256)
	for (c in s.chars()) {
		chars[c] += 1
	}
	for (c in t.chars()) {
		chars[c] -= 1
		if (chars[c] < 0) return false
	}
	return true
}


// 1.3 URLify

fun urlify(str: CharArray, trueLen: Int): CharArray {
	var spaces = 0
	for (c in 0..trueLen-1) {
		if (str[c] == ' ') spaces += 1
	}

	var offsetIdx = (trueLen + spaces * 2) - 1

	for (c in (trueLen-1) downTo 0) {
		if (str[c] == ' ') {
			str[offsetIdx] = '0'
			str[offsetIdx-1] = '2'
			str[offsetIdx-2] = '%'
			offsetIdx -= 3
		} else {
			str[offsetIdx] = str[c]
			offsetIdx -= 1
		}
	}

	return str
}

fun main(args: Array<String>) {
	val str = charArrayOf('t', 'h', 'a', 't', ' ', 't', 'h', 'e', ' ', 'q', 'u', 'i', 'c', 'k', ' ', ' ', ' ', ' ', ' ', ' ', ' ')
	println(urlify(str, 14))
}


