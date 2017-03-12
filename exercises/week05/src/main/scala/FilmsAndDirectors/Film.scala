package FilmsAndDirectors

/**
  * Created by gwilki01 on 12/03/2017.
  */
case class Film (name: String, yearofRelease: Int, imdbRating: Double, director: Director) {

  def directorsAge : Int = {
    val age = yearofRelease - directorsAge
    age
  }

  def isDirectedBy (directed: Director) : Boolean = director==directed


}
