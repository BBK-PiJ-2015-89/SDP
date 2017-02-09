// A simple object defining some methods.
object Higher {
  // Returns the absolute value.
  def abs(n: Int): Int = if (n < 0) -n else n

  // Returns the factorial of n.
  def factorial(n: Int): Int = {
    // An inner function can be defined to perform
    def go(n: Int, acc: Int): Int =
      if (n <= 0) acc
      else go(n-1, n*acc)

    go(n, 1)
  }

  // ADDITION
  // This is a higher-order function. A function that takes another
  // function as its argument.
  def format(name: String, n: Int, f: Int => Int) = {
    val msg = "The %s of %d is %d"
    msg.format(name, n, f(n))
  }

  // A way to run this from the command line.
  def main(args: Array[String]): Unit = {
    println(format("absolute value", -42, abs))
    println(format("factorial", 7, factorial))
  }
}
