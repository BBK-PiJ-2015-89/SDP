package sml

import scala.tools.nsc.typechecker.Macros.Failure
import scala.util.{Failure, Success, Try}

/*
 * The translator of a <b>S</b><b>M</b>al<b>L</b> program.
 */
class Translator(fileName: String) {
  private final val ADD = "add"
  private final val LIN = "lin"
  private final val BNZ = "bnz"
  private final val MUL = "mul"
  private final val SUB = "sub"
  private final val OUT = "out"
  private final val DIV = "div"

  /**
    * translate the small program in the file into lab (the labels) and prog (the program)
    */
  def readAndTranslate(m: Machine): Machine = {
    val labels = m.labels
    var program = m.prog
    import scala.io.Source
    val lines = Source.fromFile(fileName).getLines
    for (line <- lines) {
      val fields = line.split(" ")
      if (fields.nonEmpty) {
        // Arguments: need to turn elements in "fields" that are numbers, into Integers (try/catch) x
        // For Program: need to try to get the class (try/catch)
        // then get the constructor
        // obj = then return a new instance of the object, passing the Arguments (try/catch)
        // finally add that to program
        //
        // like this : program :+ obj
        labels.add(fields(0))
        val arguments = fields.map(f => {
          try new Integer(f)
          catch {
            case ex: NumberFormatException => f
          }
        })
        val cls = Try(Class.forName("sml." + fields(1).capitalize + "Instruction"))
        cls match {
          case s: Success => {
            val cons = s.get.getClass.getConstructors.head
            try val obj = cons.newInstance(arguments).asInstanceOf[Instruction]
            program = program :+ obj
          }
          case f: Failure => println("failed")
//        }
//        fields(1) match {
//          case ADD =>
//            program = program :+ AddInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
//          case SUB =>
//            program = program :+ SubInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
//          case DIV =>
//            program = program :+ DivInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
//          case MUL =>
//            program = program :+ MulInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
//          case OUT =>
//            program = program :+ OutInstruction(fields(0), fields(2).toInt)
//          case BNZ =>
//            program = program :+ BnzInstruction(fields(0), fields(2).toInt, fields(3))
//          case LIN =>
//            program = program :+ LinInstruction(fields(0), fields(2).toInt, fields(3).toInt)
//          case x =>
//            println(s"Unknown instruction $x")
//        }
      }
    }
    new Machine(labels, program)
  }
}

object Translator {
  def apply(file: String) = new Translator(file)
}
