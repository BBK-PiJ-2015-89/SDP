object Singleton{
	//val instance: Singleton = new Singleton()
	var args = 0
	lazy val x = args
	
	def apply(arg: Int) = {
		args = arg
		println("the value of x is " + x)
	}
	
}

case class Singleton private()

object Main extends App {
	val x = Singleton
	x.apply(3)
	println(x.x)

}