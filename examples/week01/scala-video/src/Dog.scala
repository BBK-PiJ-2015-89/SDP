// ---------- INHERITANCE ----------
// A class that inherits from another gains all its fields and methods
// A class declared final can't be extended

class Dog(name: String, sound: String, growl: String) extends Animal(name, sound) {

  def this(name: String, sound: String) {
    this("No Name", sound, "No Growl")
    this.setName(name)
  }

  def this(name: String) {
    this("No Name", "No Sound", "No Growl")
    this.setName(name)
  }

  def this() {
    this("No Name", "No Sound", "No Growl")
  }

  // You can override any other method
  override def toString(): String = {
    return "%s with the id %d says %s or %s".format(
      this.name, this.id, this.sound, this.growl)
  }
}
