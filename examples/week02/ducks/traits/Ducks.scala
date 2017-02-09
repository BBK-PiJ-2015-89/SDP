package cs220.ducks.traits

abstract class Duck(val name: String) {
  def swim()  = "Swimming Duck!"
  def display(): String
  // Other duck-like methods
}

trait Flyable {
  def fly(): String
}

trait Quackable {
  def quack(): String
}

class MallardDuck extends Duck("mallard") with Flyable with Quackable {
  def display() = "Displaying " + name
  def fly() = name + " is flying!"
  def quack() = name + " can quack!"
}

class ReadheadDuck extends Duck("readhead") with Flyable with Quackable {
  def display() = "Displaying the infamous " + name
  def fly() = name + " is flying like a pig!"
  def quack() = name + " can quack!"
}

class RubberDuck extends Duck("rubberduck") with Quackable {
  def display() = name + " float like a champ!"
  def quack() = name + " can quack!"
}

class DecoyDuck extends Duck("decoyduck") {
  def display() = name + " float like a piece of wood!"
}
