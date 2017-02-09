
object Poly {
  // The monomorphic version
  def findFirstMono(ss: Array[String], key: String): Int = {
    def loop(n: Int): Int =
      if (n >= ss.length) -1
      else if (ss(n) == key) n
      else loop(n + 1)

    loop(0)
  }

  // The polymorphic version
  // This function is polymorphic in A. A is a type parameter. You
  // can use any name to define a type parameter. Typically, they
  // are A, B, C, ... by convention.
  def findFirstPoly[A](as: Array[A], p: A => Boolean): Int = {
    def loop(n: Int): Int =
      if (n >= as.length) -1
      else if (p(as(n))) n
      else loop(n + 1)

    loop(0)
  }

  def main(args: Array[String]): Unit = {
    println(findFirstPoly(Array("X", "Y", "Z"), (x: String) => x == "Y"))
    println(findFirstPoly(Array(1, 2, 3), (x: Int) => x == 3))
  }
}