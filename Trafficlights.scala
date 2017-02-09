//sealed trait either red yellow or green
//sealed stops trait being extended and final is case cannot be extended.


// write a method next () which takes Red -> Green -> Orange -> Red

//sealed trait TrafficLight{
//	def next: TrafficLight
//	}
	
//	final case object Red extends TrafficLight{
//	def next = Green
//	}
//	final case object Orange extends TrafficLight{
//	def next = Orange
//	}
//	final case object Green extends TrafficLight{
//	def next = Red
//	} */
	
	sealed trait TrafficLight{
		def next: TrafficLight = 
		this match{
			case Red => Green
			case Green => Orange
			case Orange => Red
			}
		}
	final case object Red extends TrafficLight
	final case object Orange extends TrafficLight
	final case object Green extends TrafficLight

	
	



