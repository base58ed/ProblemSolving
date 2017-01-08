package introduction

/*

3) What is Kotlin?

 .1) Statically typed programming language for the JVM, Android and the browser. Native (LLVM) & iOS coming up.

 .2) 100% interoperable with Java. You can mix Java & Kotlin in one project

 .3) First class tooling support. Dalvik, JVM, Android Studio, Intellij Idea, Eclipse... wherever Java runs

 .4) Built and maintained by Jetbrains. Apache 2 license. Builds on OpenJDK.

*/





// Mandatory Hello World
fun main(args: Array<String>) {
	println("Hello World!")
}

// Notice:
// No Main class
// Functions are 'fun'... no literally
// No class-per-file
// Functions are top-level & first class type
// no static cling
// no semicolons
// everything is final by default (except var when you need it)
// no `System.out.print...` to do such a common thing








// Everything about commonly used data structures you had dreamed of
// Also notice type-inference
fun dataStructures() {
	val fixedArray = intArrayOf(2, 3, 5, 7, 11)
	fixedArray[0]

	val immutableList = listOf("the", "quick", "brown", "fox", "jumps", "right", "over")
	immutableList[0]

	val immutableSet = setOf("Karachi", "Beirut", "Dubai", "Mumbai", "Cairo", "Petra")
	immutableSet.joinToString()

	val immutableMap = mapOf(1 to "One", 2 to "Two", 3 to "Three")
	val nameForThird = immutableMap[3]

	val twoTuple = Pair("Name", "Nabeel")
	twoTuple.first // "Name"
	twoTuple.second // "Nabeel"

}








// Zero-overhead null safety
fun nullSafety() {
	val doYouRemember: String? = null
	val photograph: String = "there it is" //not possible to initialize with null

	val memory: String = doYouRemember ?: "______"

	val info = mapOf("lang" to "Kotlin")

	val author: String = info["author"] ?: "NA"

	info.map { it.value.toUpperCase() }.forEach(::println)

	fun nullableReceiver(name: String?) {
		val length = name?.count() // not possible to omit null-check
	}
}








