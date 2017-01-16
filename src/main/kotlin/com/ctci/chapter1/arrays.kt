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