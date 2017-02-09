package catspm

//import cats.{Food, Antelope, TigerFood, Licorice, Mice}
import cats._

// define a method dinner() 
// Lion eat Antelope
// Tiger eat Tiger Food
// Panthers eat Licorice
// Cats eat Mice

// pattern matching

sealed trait Feline {
    def dinner = this match {
        case Lion() => Antelope()
        case Tiger() => TigerFood()
        case Panther() => Licorice()
        case Cat() => Mice()
    }
}

final case class Lion() extends Feline
final case class Tiger() extends Feline
final case class Panther() extends Feline
final case class Cat() extends Feline
