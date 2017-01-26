package cs220.ducks.composition

import org.scalatest.FunSuite

class SimpleTestSuite extends FunSuite {
  test("1 + 1 == 2") {
    assert(1 + 1 == 2)
  }

  test("1 + 1 != 3") {
    assert(1 + 1 != 3)
  }

  test("Nil == List()") {
    assert(List() == Nil)
  }
}