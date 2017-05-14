package factory

import bc.{ByteCode, ByteCodeFactory, ByteCodeValues, InvalidBytecodeException}
//Laurent kindly pointed out our magic number problem here.
/**
  * @author Nicole Heathward and Graeme Wilkinson
  */
class ByteCodeFactoryImpl extends ByteCodeFactory with ByteCodeValues{

  //Enables the bytenames to be found by string rather than index
  private val bytenames = bytecode.map(b => b.swap)


  /**
    * Returns a [[ByteCode]].
    *
    * This method creates a new [[ByteCode]] object given the `byte`
    * that corresponds to the bytecode (see [[bc.ByteCodeValues]]. If
    * the bytecode requires arguments then an optional integer
    * argument is provided.
    *
    * This method should throw an [[bc.InvalidBytecodeException]] if the
    * given bytecode value is unknown.
    *
    * @param byte the byte code of a bytecode
    * @param args an optional integer argument (depends on bytecode)
    * @return a new bytecode object
    */
  override def make(byte: Byte, args: Int*): ByteCode = bytenames.get(byte) match {
    //Adding optional sum to avoid elementnotfound exception which was being thrown from the above signature in its previous state. We retrieve using
      // the bytename.get to get an option returned, this way we are not, as we were previously trying to find an element in the map which does not exist
      // and throwing an exception when it doesn't.
    case Some("iconst") if args.isEmpty => throw new InvalidBytecodeException("iconst requires an argument")
    case Some("iconst") if args.length>1 => throw new InvalidBytecodeException("iconst only takes one argument")
    case Some("iconst") => IConst(args.head)
    case Some("iadd") => new IAdd
    case Some("isub") => new ISub
    case Some("imul") => new IMul
    case Some("idiv") => new IDiv
    case Some("irem") => new IRem
    case Some("ineg") => new INeg
    case Some("iinc") => new IInc
    case Some("idec") => new IDec
    case Some("idup") => new IDup
    case Some("iswap") => new ISwap
    case Some("print") => new Print
    //If element was not returned, then instead of null or an exception, the option will throw back a none,
      // which can be caught in the case None statement, to then throw a more appropriate exception as specified below.
    case None => throw new InvalidBytecodeException("ByteCode specified is not valid.")
  }

}
