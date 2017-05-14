package vm

import bc.{ByteCode, ByteCodeParser}
import vendor.{Instruction, InvalidInstructionFormatException, ProgramParser}

/** Started with assistance from Laurent Mignot. */

/**
  * @author Nicole Heathward and Graeme Wilkinson
  */
case class VirtualMachineParserImpl(pp: ProgramParser, bp: ByteCodeParser) extends VirtualMachineParser {
  /**
    * Returns a vector of [[bc.ByteCode]].
    *
    * This method parses a file into a vector of bytecode objects.
    * Note, this method should throw a [[bc.InvalidBytecodeException]]
    * if it fails to parse a program file correctly.
    *
    * @param file the file containing a program
    * @return a vector of bytecodes
    */
  override def parse(file: String): Vector[ByteCode] = {
    var instructionList = Vector[Instruction]()
    try {
      instructionList = pp.parse(file)
    }
    catch {
      case ex: InvalidInstructionFormatException => throw new bc.InvalidBytecodeException(ex.getMessage)
    }
    byteCodeConverter(instructionList)
  }

  /**
    * Returns a vector of [[bc.ByteCode]].
    *
    * This method parses a string into a vector of bytecode objects.
    * Note, this method should throw a [[bc.InvalidBytecodeException]]
    * if it fails to parse a program string correctly.
    *
    * @param str a string containing a program
    * @return a vector of bytecodes
    */
  override def parseString(str: String): Vector[ByteCode] = {
    var instructionList = Vector[Instruction]()
    try {
      instructionList = pp.parseString(str)
    }
    catch {
      case ex: InvalidInstructionFormatException => throw new bc.InvalidBytecodeException(ex.getMessage)
    }
    byteCodeConverter(instructionList)
  }

  private def byteCodeConverter(instructionList : Vector[Instruction]) : Vector[ByteCode] = {
    val collector = scala.collection.mutable.ArrayBuffer.empty[Byte]
    if (instructionList.nonEmpty) {
      for (a <- instructionList) {
        collector += bp.bytecode(a.name)
        if (a.name == "iconst") {
          collector ++= a.args.map(_.toByte)
        }
      }
    }
    bp.parse(collector.toVector)
  }
}
