package cs220.ducks.composition

/**
 * A representation of all ducks.
 * This class is abstract - it can't be instantiated.
 *
 * All ducks have the (has-a) ability to fly and quack. Rather than
 * inherit these abilities, each duck is composed of behaviors
 * that make the most sense. We define these in separate classes
 * to reduce code duplication.
 *
 * @param name the name of the duck
 */
abstract class Duck(val name: String) {
  val flybehavior: FlyBehavior
  val quackbehavior: QuackBehavior
  def fly() = flybehavior.perform()
  def quack() = quackbehavior.perform()
  def display(): String
}

//////////////////////////////////////////////////////////////////////
/// The following are behaviors that a duck may have and incorporate
/// them as part of the construction of an individual Duck. The
/// individual duck then delegates the behavior to one of these.
//////////////////////////////////////////////////////////////////////

/**
 * A `FlyBehavior` is a fly-like behavior a duck may have.
 */
trait FlyBehavior {
  /**
   * `perform` returns the result of that behavior. In a real
   * application this would likely display the behavior on the screen.
   *
   * @return the result of that behavior
   */
  def perform(): String
}

/**
 * `FlyWithWings` is a behavior for ducks that can fly with wings.
 */
object FlyWithWings extends FlyBehavior {
  def perform() = "Flying like a duck!"
}

/**
 * `FlyNoWay` is a behavior for ducks that can't fly.
 */
object FlyNoWay extends FlyBehavior {
  def perform() = "Can't fly!"
}

/**
 * A `QuackBehavior` is a quack-like behavior a duck might have.
 */
trait QuackBehavior {
  /**
   * `perform` returns the result of that behavior. In a real
   * application this would likely display the behavior on the screen.
   *
   * @return the result of that behavior
   */
  def perform(): String
}

/**
 * `Quack` is a behavior for ducks that can actually quack.
 */
object Quack extends QuackBehavior {
  def perform() = "Quack!!!"
}

/**
 * `Squeak` is a quack-like behavior for ducks that squeak.
 */
object Squeak extends QuackBehavior {
  def perform() = "Squeak!!!"
}

/**
 * `MuteDuck` is for ducks that make no noise!
 */
object MuteQuack extends QuackBehavior {
  def perform() = "..."
}

//////////////////////////////////////////////////////////////////////
/// The following are ducks that inherit the `Duck` abstract class.
/// This means, that all of these are a `Duck` (is-a relationship).
/// Each one, however, uses composition to define their behavior
/// without duplicating code.
//////////////////////////////////////////////////////////////////////

class MallardDuck extends Duck("mallard") {
  val flybehavior = FlyWithWings
  val quackbehavior = Quack

  def display() = "Displaying the " + name + " duck!"
}

class RedHeadDuck extends Duck("redhead") {
  val flybehavior = FlyWithWings
  val quackbehavior = Quack

  def display() = "Displaying the " + name + " duck! Woohoo!"
}

class RubberDuck extends Duck("rubberduck") {
  val flybehavior = FlyNoWay
  val quackbehavior = Squeak

  def display() = "Displaying the " + name + " duck! I am yellow!"
}

class DecoyDuck extends Duck("decoyduck") {
  val flybehavior = FlyNoWay
  val quackbehavior = MuteQuack

  def display() = "Displaying the " + name + " duck! I am deadwood!"
}