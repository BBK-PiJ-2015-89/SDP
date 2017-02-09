package s.factory

trait Shape {
  def draw: Unit
}

class Rectangle extends Shape {
  override def draw: Unit = println("drawing Rectangle!")
}

class Square extends Shape {
  override def draw: Unit = println("drawing Square")
}

class Circle extends Shape {
  override def draw: Unit = println("drawing Circle")
}

object ShapeFactory {
  def apply(shapeType: String): Option[Shape] =
    if (shapeType.toLowerCase == "rectangle") Some(new Rectangle)
    else if (shapeType.toLowerCase == "square") Some(new Square)
    else if (shapeType.toLowerCase == "circle") Some(new Circle)
    else None
}
