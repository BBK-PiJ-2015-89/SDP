package PersonPackage

/**
  * Created by gwilki01 on 12/03/2017.
  */
class Person (var firstName: String, var lastName: String){


}
object Person{

  def apply (name: String): Person ={
    val namessplit = name.split(" ")
    val newBorn = new Person (firstName = "", lastName = "")
    newBorn.firstName = namessplit(0)
    newBorn.lastName = namessplit(1)
    newBorn
  }


}
