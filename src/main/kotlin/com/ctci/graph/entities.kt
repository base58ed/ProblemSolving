package com.ctci.graph

import com.koloboke.collect.map.hash.HashIntObjMaps
import com.koloboke.collect.set.hash.HashIntSet
import com.koloboke.collect.set.hash.HashIntSets.newMutableSet


typealias Vertex = Int


class Graph {
	var adjacencies = HashIntObjMaps.newMutableMap<HashIntSet>()
	fun V(): Int = adjacencies.keys.count()
	fun E(): Int {
		var totalSum = 0
		for (v in adjacencies.values) {
			totalSum += v.count()
		}
		return totalSum / 2
	}

	fun adjacentTo(v: Vertex): HashIntSet? {
		return adjacencies[v]
	}
}

fun Graph.addEdge(v: Vertex, w: Vertex) {
	if (this.adjacencies[v] != null) {
		this.adjacencies[v]?.plusElement(w)
	} else {
		this.adjacencies.put(v, newMutableSet(w))
	}

	if (this.adjacencies[w] != null) {
		this.adjacencies[w]?.plusElement(v)
	} else {
		this.adjacencies.put(w, newMutableSet(v))
	}
}

fun Graph.degree(v: Vertex): Int = this.adjacentTo(v)?.count() ?: 0

fun Graph.maxDegree(): Int {
	//(0..this.V()-1).map { vertex -> degree(vertex) }.max() ?: 0
	var max = 0
	for (v in 0..this.V()-1) {
		val degree = degree(v)
		if (degree > max) { max = degree }
	}
	return max
}

fun Graph.avgDegree(): Int = 2 * this.E() / this.V()

fun Graph.numberOfSelfLoops(): Int {
	var selfLoopCount = 0

	for (v in 0..this.V()-1) {
		val adj = this.adjacentTo(v)
		if (adj != null) {
			if (adj.contains(v)) selfLoopCount += 1
		}
	}
	return selfLoopCount / 2
}

fun Graph.prettyPrint() {
	for (vertex in 0..this.V() - 1) {
		println("$vertex : ${adjacencies[vertex]}")
	}
}

fun Graph.dfs(v: Vertex) {
	val marked = BooleanArray(this.V())

}

fun Graph.bfs(v: Vertex) {
	val marked = BooleanArray(this.V())
}

fun main(args: Array<String>) {
	val g = Graph()
	g.addEdge(0, 1)
	g.addEdge(0, 2)
	g.addEdge(1, 2)
	g.prettyPrint()

	g.dfs(0)

	val asc = Array(5, { i -> (i * i).toString() })
	for (oldIter in 0..10) { println(oldIter) }
	println("bounday")
	(0..10).forEach { println(it) }
	println("sequence boundary")
	(0..10).asSequence().forEach { println(it) }
}