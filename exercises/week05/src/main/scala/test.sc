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

val counter = new Counter(1)

println(counter.getClass)
println(counter.toString)

val x = new Counter(10).inc().dec().inc().inc().count()
println(x)