/**
  * Created by gwilki01 on 12/03/2017.
  */

case class CounterCase(number : Int = 0){


  def inc (inc: Int = 1): CounterCase = {
    this.copy(number + inc)
  }

  def dec (dec: Int = 1): CounterCase = {
    this.copy(number - dec)
  }

  def count () : Int = {
    number
  }

  def adjust(add: Adder): CounterCase = {
      this.copy(number = add.add(number))
  }
}

object CaseTest extends App {
  val x = CounterCase(10).inc().inc().count()
  println(x)//should be 12
  val adder = new Adder(7)
  val y = CounterCase().adjust(adder).count()
  println(y) // should be 7

}