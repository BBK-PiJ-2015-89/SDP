trait Top {
    def fun() = println("Top")
}

trait Left extends Top {
    override def fun() = println("Left")
}

trait Right extends Top {
    override def fun() = println("Right")
}

trait Bottom extends Left with Right {
    override def fun() = println("Bottom")
}

case class LeftImpl() extends Left
case class RightImpl() extends Right
case class BottomImpl() extends Bottom

object MultipleInheritance extends App {
    val o = BottomImpl()
    o.fun()
}