/*
You can execute commands directly in the terminal
REPL : Read Evaluate Print Loop
Type scala in terminal to start and :q to quit

or alternatively you can use a Scala Worksheet
*/
// Creates a variable of the correct type
10 + 3 * 5 / 2

// You only use semicolons in Scala if you have multiple statements per line

// You can use that variable in the code that follows
//"Your answer " + res0

// Define your own variable
var myName = "Derek"

// Define your own constant variable
val myAge = 40

// You can define the type
val lastName: String = "Banas"

// How to import library functions
import scala.math._

// ---------- DATA TYPES ----------

// All datatypes in Scala are objects and they include
// (Get the max value with MaxValue)
// Byte : -128 to 127
// Boolean : true or false
// Char : unsigned max value 65535
// Short : -32768 to 32767
// Int : -2147483648 to 2147483647
// Long : -9223372036854775808 to 9223372036854775807
// Float : -3.4028235E38 to 3.4028235E38
// Double : -1.7976931348623157E308 to 1.7976931348623157E308

// A Double will only hold precision up to 15 digits
val num13 = 1.999999999999999

// Create a BigInt
val lgPrime = BigInt("622288097498926496141095869268883999563096063592498055290461")
lgPrime + 1

// Create a BigDecimal
val pi50 = BigDecimal("3.14159265358979323846264338327950288419716939937510")
0.00000000000000000000000000000000000000000000000001 + pi50

var randInt = 100000

// See functions available by typing randInt. (Click Tab)
// randInt.asInstanceOf[Double] casts number to a double
// randInt.isInstanceOf[Int] checks if is of type Int

// ---------- MATH ----------
"5 + 4 = " + (5 + 4)
"5 - 4 = " + (5 - 4)
"5 * 4 = " + (5 * 4)
"5 / 4 = " + (5 / 4)
"5 % 4 = " + (5 % 4)

// Shorthand notation (No randInt++, or randInt--)
randInt += 1
"randInt += 1" + randInt

randInt -= 1
"randInt -= 1" + randInt

randInt *= 1
"randInt *= 1" + randInt

randInt /= 1
"randInt /= 1" + randInt

// Import the math library in the terminal import scala.math._

abs(-8)
cbrt(64) // Cube root a^3 = n (Find a)
ceil(5.45)
round(5.45)
floor(5.45)
exp(1) // Euler's number raised to the power
pow(2, 2) // 2^2
sqrt(pow(2,2) + pow(2,2))
hypot(2, 2) // sqrt(X^2 + y^2)
log10(1000) // = 3 (10 × 10 × 10 = 10^3)
log(2.7182818284590455) // Natural logarithm to the base e
min(5, 10)
max(5, 10)
(random * (11 - 1) + 1).toInt // Random number between 1 and 10
toRadians(90)
toDegrees(1.5707963267948966)

// acos, asin, atan, atan2, cos, cosh, sin, sinh, tan, tanh

// ---------- CONDITIONALS ----------
// if statements are like Java except they return a value like the
// ternary operator

// Conditional Operators : ==, !=, >, <, >=, <=
// Logical Operators : &&, ||, !

var age = 18

val canVote = if (age >= 18) "yes" else "no"

// You have to use { } in the REPL, but not otherwise
if ((age >= 5) && (age <= 6)) {
  println("Go to Kindergarten")
} else if ((age > 6) && (age <= 7)) {
  println("Go to Grade 1")
} else {
  println("Go to Grade " + (age - 5))
}

true || false
!(true)
