package introduction


// Declared with 'fun'
// First class type
// Higher-order. Can take and return fun
// Extensions are possible through fun


// classic util fun
fun multiply(n: Int, times: Int): Int = n * times

fun main50(args: Array<String>) {
	println( multiply(3, 4) )
}



// Higher order fun
fun performMultiplication(n: Int, times: Int, op: (Int, Int) -> Int) = println(op(n, times))

fun main51(args: Array<String>) {
	val multiplier1 = {a: Int, b: Int -> a * b}

	val multiplier2: (Int, Int) -> Int = { a, b -> a * b }

	val multiplier3 = ::multiply

	performMultiplication(3, 4, multiplier1)
}

