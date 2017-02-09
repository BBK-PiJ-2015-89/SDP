// ---------- ABSTRACT CLASS ----------
// An abstract class can't be instantiated.
// It is made up of both abstract and non-abstract methods and fields

abstract class Mammal(val name: String) {
  // An abstract field has no initial value
  var moveSpeed: Double

  // An abstract method has no body
  def move: String

}
