/**
  * Created by graemewilkinson on 05/03/2017.
  */
class Counter (var number : Int) {

  def inc (): Counter = {
    new Counter(number + 1)
  }

  def dec (): Counter = {
    new Counter(number -1)
  }

  def count () : Int = {
    number
  }
}

object Test extends App {
  val x = new Counter(10).inc().inc().count()

  println(x)
}