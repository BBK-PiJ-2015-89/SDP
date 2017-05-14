package vendor

import scala.io.Source

/**
  * @author Nicole Heathward and Graeme Wilkinson
  */
object ProgramParserImpl extends ProgramParser {
  /**
    * Parses a file representation of a bytecode program
    * into an `InstructionList`.
    *
    * @param file the file to parse
    * @return an instruction list
    */

  /**Please note that Laurent Mignot gave advice on this section in the lab. */

  override def parse(file: String): InstructionList = {
    instructionConverter(Source.fromFile(file).getLines())
  }


  /**
    * Parses a string representation of a bytecode program
    * into an `InstructionList`.
    *
    * @param string the string to parse
    * @return an instruction list
    */
  override def parseString(string: String): InstructionList = {
    instructionConverter(string.split("\n").toIterator)

  }

  private def instructionConverter(string: Iterator[String]): InstructionList = {

    val names = Vector("iconst", "iadd", "isub", "imul", "idiv", "irem",
      "ineg", "iinc", "idec", "idup", "iswap", "print")

    string.map(i => {
      i.split(" ").toList match {
        case hd :: _ if !names.contains(hd) => throw new InvalidInstructionFormatException("Invalid Instruction")
        case hd :: tl if hd == "iconst" && tl.isEmpty => throw new InvalidInstructionFormatException("iconst must have an integer arg")
        case hd :: tl if tl.nonEmpty => new Instruction(hd, tl.map {
          n => {
            try n.toInt
            catch
            {
              case x: java.lang.NumberFormatException => throw new InvalidInstructionFormatException("iconst must have an integer argument")
            }
          }
        }.toVector)
        case hd :: _ => new Instruction(hd, Vector.empty)
        case _ => throw new InvalidInstructionFormatException("No instruction found")
      }
    }).toVector
  }
}
