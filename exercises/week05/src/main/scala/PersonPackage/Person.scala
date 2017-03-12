package PersonPackage

/**
  * Created by gwilki01 on 12/03/2017.
  */
class Person (var firstName: String, var lastName: String){

}
object Person {

  def apply(name: String): Person = {
    val namesSplit = name.split(" ")
    val newBorn = new Person(namesSplit(0),namesSplit(1))
    newBorn
  }
}

object Test extends App {
  val person1 = Person("Graeme Wilkinson")
  println(person1.firstName + ", " + person1.lastName)
}
