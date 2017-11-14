class Person(val firstName: String, val lastName: String) {
  def name = firstName + " " + lastName
}

object Person {
  def apply(name: String): Person = {
    val parts = name.split(" ")
    new Person(parts(0), parts(1))
  }
}


class Director(val firstName: String, val lastName: String, val yearOfBirth: Int) {
  def name = firstName + " " + lastName
}

object Director {
  def apply(firstName: String, lastName: String, yearOfBirth: Int): Director = new Director(firstName, lastName, yearOfBirth)
  def older(a: Director, b: Director): Director = if (a.yearOfBirth < b.yearOfBirth) a else b
}

class Film(val name: String, val yearOfRelease: Int, val imdbRating: Double, val director: Director) {
  def directorsAge = director.yearOfBirth - this.yearOfRelease
  def isDirectedBy(director: Director) = this.director == director
}

object Film {
  def apply(name: String, yearOfRelease: Int, imdbRating: Double, director: Director): Film = new Film(name, yearOfRelease, imdbRating, director)
  def highestRating(a: Film, b: Film): Film = if (a.imdbRating > b.imdbRating) a else b
  def oldestDirectorAtTheTime(a: Film, b: Film): Director = if (a.directorsAge > b.directorsAge) a.director else b.director
}

