package introduction


// Extensions are available in the form of Functions
// Statically dispatched
// Should be stateless
// Can write extension for any final/non-final class


// Extension fun
fun Int.times(factor: Int): Int = this * factor

fun main52(args: Array<String>) {
	println( 3.times(4) )
}





// DSL with Extension fun
infix fun Int.into(factor: Int): Int = this * factor


fun main53(args: Array<String>) {
	println( 3 into 4 )
}

// `inline` extensions provide very useful and performant abstractions
inline fun SharedPreferences.edit(func: SharedPreferences.Editor.() -> Unit) {
	val editor = edit()
	editor.func()
	editor.apply()
}

fun caller() {
	preferences.edit {
		putString("foo", "bar")
		putString("fizz", "buzz")
		remove("username")
	}
}

// example of android settings