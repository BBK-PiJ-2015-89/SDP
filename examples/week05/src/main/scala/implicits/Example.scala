object ImplicitsExample extends App {
    val value = 3

    def multiply(implicit by: Int) = value * by

    implicit val multiplier = 2
    //implicit def f: Int = if (true) 4 else 2

    println(multiply)

    def example1(implicit x: Int) = x                // x is implicit
    def example2(implicit x: Int, y: Int) = x * y    // x and y are implicit
    //def example3(x: Int, implicit y: Int)          // won't compile 
    def example4(x: Int)(implicit y: Int) = x * y    // only y is implicit
    //def example5(implicit x: Int)(y: Int)          // won't compile
    //def example6(implicit x: Int)(implicit y: Int) // won't compile
    println(example1)
    println(example2)
    println(example4(3))
}