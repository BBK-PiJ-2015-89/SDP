package listtwo

sealed trait IntList {
    def length: Int =
        fold(0, (_, restl) => 1 + restl) // arg => body or (arg,arg,...) => body
    
    def product: Int = 
        fold(1, (hd, restl) => hd * restl)

    def sum: Int =
        fold(0, (hd, restl) => hd + restl)

    def fold(end: Int, f: (Int, Int) => Int): Int = 
        this match {
            case End => end
            case Pair(hd, tl) => f(hd, tl.fold(end, f))
        }

    def double: IntList = 
        this match {
            case End => End
            case Pair(hd, tl) => Pair(hd * 2, tl.double)
        }
}

final case object End extends IntList
final case class Pair(head: Int, tail: IntList) extends IntList

// val example = Pair(1, Pair(2, Pair(3, End)))