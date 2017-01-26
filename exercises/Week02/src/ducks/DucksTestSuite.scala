package cs220.ducks.composition

import org.scalatest.FunSuite

class DucksTestSuite extends FunSuite {
  test("mallard ducks can fly") {
    val d = new MallardDuck
    assert(d.fly == "Flying like a duck!")
  }

  test("mallard ducks can quack") {
    val d = new MallardDuck
    assert(d.quack == "Quack!!!")
  }

  test("redhead ducks can fly") {
    val d = new RedHeadDuck
    assert(d.fly == "Flying like a duck!")
  }

  test("redhead ducks can quack") {
    val d = new RedHeadDuck
    assert(d.quack == "Quack!!!")
  }

  test("rubber ducks can't fly") {
    val d = new RubberDuck
    assert(d.fly == "Can't fly!")
  }
}