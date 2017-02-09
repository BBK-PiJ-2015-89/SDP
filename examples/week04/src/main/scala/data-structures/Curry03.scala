object Curry {

  def curry[A,B,C](f: (A,B) => C): A => (B => C) =
    (a: A) => (b: B) => f(a,b)

  def main(args: Array[String]) = {
    // first, create the initial function:
    val g = (x: Int, y: Int) => x + y
    // now, we curry it:
    val h = curry(g)
    // now, if we invoke it with one argument we get a function back:
    val i = h(4)
    // lastly, if we invoke that with a value it returns the value:
    println(i(5))
  }
}