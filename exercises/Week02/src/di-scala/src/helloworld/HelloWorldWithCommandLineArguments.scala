package helloworld

object HelloWorldWithCommandLineArguments extends App{
 // def main(args: Array[String]) {
    if (args.length > 0) {
      println(args(0))
    }
    else {
      println("Hello World!")
    }
  //}
}