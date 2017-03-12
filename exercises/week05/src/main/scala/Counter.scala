

/**
  * Created by graemewilkinson on 05/03/2017.
  */
class Counter (var number : Int){


  def inc (inc: Int = 1): Counter = {
    new Counter(number + inc)
  }

  def dec (dec: Int = 1): Counter = {
    new Counter(number -dec)
  }

  def count () : Int = {
    number
  }
}


object Test extends App {
  val x = new Counter(10).inc().inc().count()
  println(x)
}

