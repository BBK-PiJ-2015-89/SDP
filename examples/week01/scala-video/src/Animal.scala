// ---------- CLASSES ----------
// Classes are used as blueprints to create objects
// Objects define the attributes (fields) and capabilities (methods) of an
// object

class Animal(var name: String, var sound: String) {
  this.setName(name)

  // Any code that follows the class name is executed each time an
  // object is created as part of the Primary Constructor

  // This function is defined in the Animal companion object below
  val id = Animal.newIdNum

  // You must initialize all fields
  // protected means the field can only be accessed directly by methods
  // defined in the class or by subclasses
  // private fields can't be accessed by subclasses of Animal
  // public fields can be accessed directly by anything

  // protected var name = "No Name"
  // protected var sound = "No Sound"

  // Getters and setters are used to protect data
  def getName(): String = name

  def getSound(): String = sound

  def setName(name: String) {
    // Check if the String contains numbers and if so don't allow
    if (!(name.matches(".*\\d+.*")))

    // this allows us to refer to any object without knowing its name
      this.name = name
    else
      this.name = "No Name"
  }

  def setSound(sound: String) {
    this.sound = sound
  }

  // Subclasses can't call this constructor unlike with Java
  def this(name: String) {

    // This calls the primary constructor defined on the class line
    this("No Name", "No Sound")
    this.setName(name)
  }

  def this() {
    // This calls the primary constructor defined on the class line
    this("No Name", "No Sound")
  }

  // You can override any other method
  override def toString(): String = {

    // How to format Strings
    return "%s with the id %d says %s".format(this.name, this.id, this.sound)
  }

}

// The companion object for a class is where you'd define static class
// variables and functions in Java
object Animal {
  private var idNumber = 0

  private def newIdNum = {
    idNumber += 1; idNumber
  }
}
