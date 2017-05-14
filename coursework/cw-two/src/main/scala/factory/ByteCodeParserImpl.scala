package factory

import bc.{ByteCode, ByteCodeParser, InvalidBytecodeException}
import vendor.InvalidInstructionFormatException

/**
  * @author Nicole Heathward and Graeme Wilkinson
  */
class ByteCodeParserImpl extends ByteCodeParser {
  /**
    * Parses a vector of `Byte` into a vector of `ByteCode`.
    *
    * You should use [[bc.ByteCodeValues.bytecode]] to help translate
    * the individual `Byte`s into a corresponding [[ByteCode]].
    *
    * @param bc a vector of bytes representing byteCodes
    * @return a vector of `ByteCode` objects
    */
  override def parse(bc: Vector[Byte]): Vector[ByteCode] = {
    val byteCodeArray = bc.toArray
    val factory = new ByteCodeFactoryImpl
    val collector = scala.collection.mutable.ArrayBuffer.empty[ByteCode]
    var skip = false
    for (a <- byteCodeArray.indices) {
      if (skip) {
        //skip next iteration and change status back to false.
        skip = false
      } else {
        if (byteCodeArray(a) == bytecode("iconst")) {
          try collector += factory.make(byteCodeArray(a), byteCodeArray(a + 1))
          catch {
            case ex: IndexOutOfBoundsException => throw new InvalidBytecodeException("iconst requires an argument")
          }
          skip = true
        } else {
          collector += factory.make(byteCodeArray(a))
        }
      }
    }
    collector.toVector
  }
}

