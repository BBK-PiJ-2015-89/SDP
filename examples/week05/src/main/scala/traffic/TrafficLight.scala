// write a sealed trait/case objects to represent TrafficLights 
// Red, Green, Amber 

// sealed trait TrafficLight 
// final case object Red extends TrafficLight
// final case object Green extends TrafficLight
// final case object Amber extends TrafficLight

// Write a method next() which takes the colour from Red -> Green -> Amber -> Red

// Polymorphism

// sealed trait TrafficLight {
//     def next: TrafficLight    
// }

// final case object Red extends TrafficLight {
//     def next = Green
// }

// final case object Green extends TrafficLight {
//     def next = Amber
// }

// final case object Amber extends TrafficLight {
//     def next = Red
// }

// Write a method next() which takes the colour from Red -> Green -> Amber -> Red

// Pattern Matching

sealed trait TrafficLight {
    def next: TrafficLight = 
        this match {
            case Red => Green
            case Green => Amber
            case Amber => Red
        }
}

final case object Red extends TrafficLight
final case object Green extends TrafficLight
final case object Amber extends TrafficLight
