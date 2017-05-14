package vm

import factory.VirtualMachineFactory
import org.scalatest.FunSuite

class PublicVirtualMachineSuite extends FunSuite {
  val vmp = VirtualMachineFactory.virtualMachineParser
  val bcp = VirtualMachineFactory.byteCodeParser
  val vm  = VirtualMachineFactory.virtualMachine

  test("[1] a virtual machine should execute a program") {
    val bc  = vmp.parse("programs/p05.vm")
    val vm2 = vm.execute(bc)
 }

  test("[2] iconst should work correctly") {
    val bc  = vmp.parseString("iconst 1")
    val (bc2, vm2) = vm.executeOne(bc)
    assert(vm2.state.head == 1)
  }

  test("[3] iadd should work correctly") {
    val bc  = vmp.parseString("iconst 1\niconst 2\niadd")
    var next = vm.executeOne(bc)
    assert(next._2.state.head == 1)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 2)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 3)

  }

  test("[4] isub should work correctly") {
    val bc  = vmp.parseString("iconst 1\niconst 2\nisub")
    var next = vm.executeOne(bc)
    assert(next._2.state.head == 1)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 2)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 1)
  }

  test("[5] iswap should work correctly") {
    val bc  = vmp.parseString("iconst 1\niconst 2\niswap")
    var next = vm.executeOne(bc)
    assert(next._2.state.head == 1)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 2)
    next = next._2.executeOne(next._1)
    assert(next._2.state(0) == 1)
    assert(next._2.state(1) == 2)
  }

  test("[6] idiv should work correctly") {
    val bc  = vmp.parseString("iconst 2\niconst 10\nidiv")
    var next = vm.executeOne(bc)
    assert(next._2.state.head == 2)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 10)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 5)
  }

  test("[7] imul should work correctly"){
    val bc  = vmp.parseString("iconst 2\niconst 10\nimul")
    var next = vm.executeOne(bc)
    assert(next._2.state.head == 2)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 10)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 20)
  }

  test("[8] irem should work correctly"){
    val bc  = vmp.parseString("iconst 3\niconst 10\nirem")
    var next = vm.executeOne(bc)
    assert(next._2.state.head == 3)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 10)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 1)
  }

  test("[9] ineg should work correctly") {
    val bc = vmp.parseString("iconst 3\nineg")
    var next = vm.executeOne(bc)
    assert(next._2.state.head == 3)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == -3)
  }

  test("[10] iinc should work correctly"){
    val bc  = vmp.parseString("iconst 3\niinc")
    var next = vm.executeOne(bc)
    assert(next._2.state.head == 3)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 4)
   }

  test("[11] idec should work correctly"){
    val bc  = vmp.parseString("iconst 3\nidec")
    var next = vm.executeOne(bc)
    assert(next._2.state.head == 3)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 2)
  }

  test("[12] idup should work correctly") {
    val bc  = vmp.parseString("iconst 1\nidup")
    var next = vm.executeOne(bc)
    assert(next._2.state.head == 1)
    next = next._2.executeOne(next._1)
    assert(next._2.state(0) == 1)
    assert(next._2.state(1) == 1)
  }

  test("[13] print should work correctly") {
    val bc  = vmp.parseString("iconst 3\niconst 10\nprint")
    var next = vm.executeOne(bc)
    assert(next._2.state.head == 3)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 10)
    next =next._2.executeOne(next._1)
    assert(next._2.state.head == 3)
  }
}
