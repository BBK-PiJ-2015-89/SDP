package cats

// model Feline isa Lion, Tiger, Panther, or Cat as a trait/case pattern (Algebraic DataType)

// sealed trait Feline
// final case class Lion() extends Feline
// final case class Tiger() extends Feline
// final case class Panther() extends Feline
// final case class Cat() extends Feline

// define a method dinner() 
// Lion eat Antelope
// Tiger eat Tiger Food
// Panthers eat Licorice
// Cats eat Mice

// polymorphism

sealed trait Feline {
    def dinner: Food
}

final case class Lion() extends Feline {
    def dinner = Antelope()
}

final case class Tiger() extends Feline {
    def dinner = TigerFood()
}

final case class Panther() extends Feline {
    def dinner = Licorice()
}

final case class Cat() extends Feline {
    def dinner = Mice()
}