package sml

class OutInstruction(label: String, op: String, val result: Int)
  extends Instruction(label, op) {

  override def execute(m: Machine) = println(m.regs(result))

  override def toString(): String = {
    super.toString + " " + result   }
}

object OutInstruction {
  def apply(label: String, result: Int) =
    new OutInstruction(label, "out", result)
}