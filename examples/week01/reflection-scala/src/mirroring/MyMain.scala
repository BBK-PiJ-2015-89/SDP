package mirroring

object MyMain {
  def main(args: Array[String]): Unit = {
    val x = Example.getObjectInstance("mirroring.User")
    println(x)

    val y = Example.getClassInstance("mirroring.Another")
    println(y)

    val z = Example.invokeMethod("mirroring.User", "myMethod")
    println(z)

    val ww = Example.invokeMethod("mirroring.User", "myMethod2", "fooo", "barr")
    println(ww)
  }
}
