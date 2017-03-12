package FilmsAndDirectors

/**
  * Created by gwilki01 on 12/03/2017.
  */
case class Director (firstName : String, lastName: String, yearOfBirth: Int){

  def name = firstName + " " + lastName

}

object Director {
  def older (directorOne: Director, directorTwo: Director) = if(directorOne.yearOfBirth>directorTwo.yearOfBirth) directorTwo else directorOne
}
