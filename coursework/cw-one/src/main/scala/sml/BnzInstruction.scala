package sml

/**
  * Created by gwilki01 on 20/04/2017.
  */

case class BnzInstruction(label: String, opcode: String, reg: Int, target: String) extends Instruction(label, opcode){

  override def execute(m: Machine): Unit =
    if (m.regs(reg) != 0) {
      m.pc = m.prog.indexWhere(_.getLabel == target)
    }

}
object BnzInstruction {
  def apply(label: String, register: Int, target: String) : BnzInstruction =
  new BnzInstruction(label, "bnz", register, target)

}
