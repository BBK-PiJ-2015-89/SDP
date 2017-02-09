package cs220.ducks.inheritance

/**
 * A representation of all ducks.
 * This class is abstract - it can't be instantiated.
 *
 * @param name the name of the duck
 */
abstract class Duck(val name: String) {
  def quack() = "Quacking Duck!"
  def swim()  = "Swimming Duck!"
  def display(): String
  def fly(): String
  // Other duck-like methods
}

/**
 * A `MallardDuck` is a `Duck`.
 */
class MallardDuck extends Duck("mallard") {
  def display() = "Displaying " + name
  def fly() = name + " is flying!"
}

/**
 * A `ReadheadDuck` is a `Duck`.
 */
class ReadheadDuck extends Duck("readhead") {
  def display() = "Displaying the infamous " + name
  def fly() = name + " is flying like a pig!"
}

/**
 * A `RubberDuck` is a `Duck`.
 */
class RubberDuck extends Duck("rubberduck") {
  def display() = name + " float like a champ!"
  // Rubber ducks can't fly!
  override def fly() = ""
}

/**
 * A `DecoyDuck` is a `Duck`
 */
class DecoyDuck extends Duck("decoyduck") {
  def display() = name + " float like a piece of wood!"
  // DecoyDucks can't quack, swim, or fly!
  override def quack() = ""
  override def swim() = ""
  def fly() = ""
}