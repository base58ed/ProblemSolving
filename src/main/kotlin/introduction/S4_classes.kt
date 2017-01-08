package introduction

// Classes are final and public by default

class Person(val name: String, val age: Int) : java.io.Serializable




// Multiple constructors
class Employee(val id: Int) {
	var fullName: String? = null

	constructor(id: Int, name: String) : this(id) {
		fullName = name
	}
}







// Data classes to take on all the POJO's
data class Bean(val id: Int, val data: String)












// Sealed classes for Algebraic data types

sealed class MayBe {
	class Value(val t: String): MayBe()
	object None : MayBe()
}


fun patternMatch(arg: MayBe): String {
	// `when` has to be exhaustive
	return when (arg) {
		is MayBe.None -> "None is a singleton object"
		is MayBe.Value -> arg.t
	}
}


fun main(args: Array<String>) {
	patternMatch(MayBe.None)
}