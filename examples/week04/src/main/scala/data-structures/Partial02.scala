object Partial {
  def partial1[A,B,C](a: A, f: (A,B) => C): B => C =
    (b: B) => f(a,b)

  def main(args: Array[String]) = {
    // first, create a function for adding an x and y:
    val g = (x: Int, y: Int) => x + y
    // now, create a partially applied function:
    val h = partial1(4, g)
    // invoke it!
    println(h(5))  // this evaluates to 9
  }
}