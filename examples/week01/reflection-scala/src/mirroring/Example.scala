package mirroring

import scala.reflect.runtime.universe._

object Example {
  def getObjectInstance(clsName: String) = {
    val mirror = runtimeMirror(getClass.getClassLoader)
    val module = mirror.staticModule(clsName)
    mirror.reflectModule(module).instance
  }

  def getClassInstance(clsName: String) = {
    val mirror = runtimeMirror(getClass.getClassLoader)
    val cls = mirror.classSymbol(Class.forName(clsName))
    val module = cls.companion.asModule
    mirror.reflectModule(module).instance
  }

  def invokeMethod(path: String, meth: String, args: String*) = {
    val mirror = runtimeMirror(getClass.getClassLoader)
    val im = mirror.reflect(getObjectInstance(path))
    val method = im.symbol.typeSignature.member(TermName(meth)).asMethod
    im.reflectMethod(method).apply(args)
  }
}
