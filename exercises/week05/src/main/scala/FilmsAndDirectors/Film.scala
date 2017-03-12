package FilmsAndDirectors

/**
  * Created by gwilki01 on 12/03/2017.
  */
case class Film (name: String, yearofRelease: Int, imdbRating: Double, director: Director) {

  def directorsAge : Int = {
    val age = yearofRelease - director.yearOfBirth
    age
  }

  def isDirectedBy (directed: Director) : Boolean = director==directed

  def copy (name: String = name, yearofRelease: Int = yearofRelease, imdbRating: Double = imdbRating, director: Director = director): Film = {
    val copyOfFilm = Film(name, yearofRelease, imdbRating, director)
    copyOfFilm
  }

}