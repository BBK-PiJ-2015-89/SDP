package j.factory;

public class ShapeFactory {
    public Shape newShape(String shapeType) {
        if (shapeType == null)
            return null;
        if (shapeType.equalsIgnoreCase("rectangle"))
            return new Rectangle();
        else if (shapeType.equalsIgnoreCase("square"))
            return new Square();
        else if (shapeType.equalsIgnoreCase("circle"))
            return new Circle();
        else
            return null;
    }
}
