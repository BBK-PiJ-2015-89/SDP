package list

sealed trait IntList {
    def length: Int = fold(0, ( ,tl) => 1 + tl)
        //this match {
         //   case End => 0
        //    case Pair(hd, tl) => 1 + tl.length //+(1,tl.length)
       // }

 
    def product: Int = fold(1, (hd,tl) => hd * tl)
       // this match {
        //    case End => 1
       //     case Pair(hd, tl) => hd * tl.product // *(hd, tl.product)
       // }

    def sum: Int = fold(0, (hd,tl) => hd * tl)
       // this match {
       //     case End => 0
       //     case Pair(hd, tl) => hd + tl.sum //*(hd,tl.sum)
       // }

	def  fold(end: Int, f: (Int, Int) => Int) :Int = 
	this match{
		case End => end
		case Pair (hd, tl) => f(hd, tl.fold(end, f))
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