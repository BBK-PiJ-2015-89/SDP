package PersonPackage

/**
  * Created by gwilki01 on 12/03/2017.
  */
case class CasePerson (var firstName: String, var lastName: String){

}
object CasePerson {

  def apply(name: String): CasePerson = {
    val namesSplit = name.split(" ")
    val newBorn = new CasePerson(firstName = "", lastName = "")
    newBorn.firstName = namesSplit(0)
    newBorn.lastName = namesSplit(1)
    newBorn
  }
}

object Main extends App {
  val person1 = CasePerson("Graeme Wilkinson")
  val person2 = CasePerson("Elaine", "Wilkinson")
  println(person1.firstName + ", " + person1.lastName)
  println(person2.firstName + ", " + person2.lastName)
}
