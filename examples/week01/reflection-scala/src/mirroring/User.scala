package mirroring

object User {
  override def toString(): String = "Here we go..."

  def myMethod(): String = "this is the result of invoking myMethod on User"

  def myMethod2(args: Seq[String]): String = {
    args(0) + " " + args(1)
  }
}
