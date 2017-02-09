
object ListFunctions {

  def main(args: Array[String]): Unit = {
    val xs = List(7, 12, 1, 19, 4, 22, 4, -5, 16)
    val ss = "Hello, World!"

    // (1) Returns a list of the first 4 elements of the list:
    println(xs take 4)

    // (2) Returns a list of the longest valid prefix of the elements
    //     that pass the predicate function:
    println(xs takeWhile (_ > 0))

    // (3) Returns true iff all elements pass the predicate function:
    println(xs forall (_ > 0))
    println(ss forall (_.isUpper))

    // (4) Returns true if any element passes the predicate function:
    println(xs exists (_ > 0))
    println(ss exists (_.isUpper))

    // (5) Returns a resulting value from the list given a combining
    //     function:
    println(xs.foldLeft(0)(_ + _))
    // What does this do?
    println(ss.foldLeft("")((x,y) => y + x))

    // (6) Returns a resulting value from the list given a combining
    //     function:
    println(xs.foldRight(0)(_ + _))
    // What does this do?
    println(ss.foldRight("")((x,y) => y + x))

    // (7) Filters a list:
    println(xs filter (_ < 0))
    println(ss filter (_.isLower))

    // (8) Maps a collection to another collection:
    println(xs map (_ * 2))
    println(ss map (_.toUpper))

    // (9) You can combine these functional methods to do cool stuff!
    // Here is an example of a caesar cipher!
    def caesarEnc(shift: Int)(s: String): String = {
      val input  = ' ' to '~'
      val output = input.takeRight(shift) ++ input.dropRight(shift)
      val encode = input.zip(output).toMap
      s.map(encode(_))
    }

    def caesarDec(shift: Int)(s: String): String = {
      val output = ' ' to '~'
      val input  = output.takeRight(shift) ++ output.dropRight(shift)
      val decode = input.zip(output).toMap
      s.map(decode(_))
    }

    val c4 = caesarEnc(4)_
    val d4 = caesarDec(4)_

    val s = "Did you ever know..., that Scala could be so much fun!"
    println("c4: " + c4(s))
    println("d4: " + d4(c4(s)))
  }

}