package factory

import bc.ByteCode
import vm.VirtualMachine

/**
  * @author Nicole Heathward and Graeme Wilkinson
  */

final case class IConst(num: Int) extends ByteCode {

  override val code: Byte = bytecode("iconst")
  /**
    * Returns a new [[VirtualMachine]] after executing this bytecode operation.
    *
    * @param vm the initial virtual machine
    * @return a new virtual machine
    */
  override def execute(vm: VirtualMachine): VirtualMachine = {
    vm.push(num)
  }

  override def toString: String = "IConst " + num
}

final case class IAdd() extends MathsHelper (_+_) {

  override val code: Byte = bytecode("iadd")
  /**
    * @see [[MathsHelper]] execute method
    *
    */
  override def toString: String = "IAdd"

}

final case class ISub() extends MathsHelper (_-_) {

  override val code: Byte = bytecode("isub")
  /**
    * @see [[MathsHelper]] execute method
    */
  override def toString: String = "ISub"
}

final case class IMul() extends MathsHelper (_*_) {

  override val code: Byte = bytecode("imul")
  /**
    * @see [[MathsHelper]] execute method
    */
  override def toString: String = "IMul"
}

final case class IDiv() extends MathsHelper (_/_){

  override val code: Byte = bytecode("idiv")
   /**
     * @see [[MathsHelper]] execute method
     */
   override def toString: String = "IDiv"
}

final case class IRem() extends MathsHelper (_%_){

  override val code: Byte = bytecode("irem")
  /**
    * @see [[MathsHelper]] execute method
    */
  override def toString: String = "IRem"
}

final case class INeg() extends DecIncNegHelper (_*(-1)){

  override val code: Byte = bytecode("ineg")
  /**
    * @see [[DecIncNegHelper]] execute method
    */
  override def toString: String = "INeg"
}

final case class IInc() extends DecIncNegHelper (_+1) {

  override val code: Byte = bytecode("iinc")
  /**
    * @see [[DecIncNegHelper]]execute method
    */
  override def toString: String = "IInc"
}

final case class IDec() extends DecIncNegHelper (_-1) {

  override val code: Byte = bytecode("idec")
  /**
    * @see [[DecIncNegHelper]] excute method
    */
  override def toString: String = "IDec"
}

final case class ISwap() extends ByteCode {

  override val code: Byte = bytecode("iswap")
  /**
    * Returns a new [[VirtualMachine]] after executing this bytecode operation.
    *
    * @param vm the initial virtual machine
    * @return a new virtual machine
    */
  override def execute(vm: VirtualMachine): VirtualMachine = {
    val result1 = vm.pop()
    val result2 = result1._2.pop()
    val result3  = result2._2.push(result1._1)
    result3.push(result2._1)
  }
  override def toString: String = "ISwap"
}

final case class IDup() extends ByteCode {

  override val code: Byte = bytecode("idup")
  /**
    * Returns a new [[VirtualMachine]] after executing this bytecode operation.
    *
    * @param vm the initial virtual machine
    * @return a new virtual machine
    */
  override def execute(vm: VirtualMachine): VirtualMachine = {
    val result1 = vm.pop()
    val result2 = result1._2.push(result1._1)
    result2.push(result1._1)
  }
  override def toString: String = "IDup"
}

final case class Print() extends ByteCode {

  override val code: Byte = bytecode("print")
  /**
    * Returns a new [[VirtualMachine]] after executing this bytecode operation.
    *
    * @param vm the initial virtual machine
    * @return a new virtual machine
    */
  override def execute(vm: VirtualMachine): VirtualMachine = {
    val result1 = vm.pop()
    println(result1._1)
    result1._2
  }
  override def toString: String = "Print"
}

/**
  *
  * @param f operand to be used to manipulate the two popped values.
  */
abstract class MathsHelper(f: (Int, Int) => Int) extends ByteCode{
  /**
    * Returns a new [[VirtualMachine]] after executing this bytecode operation.
    *
    * @param virtualMachine the initial virtual machine
    * @return a new virtual machine
    */
  def execute(virtualMachine: VirtualMachine): VirtualMachine = {
    val result1 = virtualMachine.pop()
    val result2 = result1._2.pop()
    result2._2.push(f(result1._1, result2._1))
  }
}

/**
  *
  * @param f operand to be used to manipulate the popped value.
  */
abstract class DecIncNegHelper(f: (Int) => Int) extends ByteCode{
  /**
    * Returns a new [[VirtualMachine]] after executing this bytecode operation.
    *
    * Takes one Int and an operand (as a function) and performs the operand on the Int to return a new [[VirtualMachine]]
    *
    * @param virtualMachine the initial virtual machine
    * @return a new virtual machine
    */
  def execute(virtualMachine: VirtualMachine): VirtualMachine = {
    val result1 = virtualMachine.pop()
    result1._2.push(f(result1._1))
  }
}