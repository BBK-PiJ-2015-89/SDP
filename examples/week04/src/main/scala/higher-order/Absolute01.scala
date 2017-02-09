// A simple object defining some methods.
object Absolute {
  // Returns the absolute value.
  def abs(n: Int): Int = if (n < 0) -n else n

  // Returns a string formatted result of absolute value.
  private def formatAbs(x: Int) = {
    val msg = "The absolute value of %d is %d"
    msg.format(x, abs(x))
  }

  // A way to run this from the command line.
  def main(args: Array[String]): Unit = {
    println(formatAbs(-42))
  }
}

// There are many different ways of running the code above. We could
// put this in an activator project - this is fine, and we have seen
// how to do this. But, there are other ways:
//
// (1) scala Absolute - this will run main
// (2) scala
//     scala> :load Absolute.scala
//     scala> import Absolute._
//     scala> abs(-42)