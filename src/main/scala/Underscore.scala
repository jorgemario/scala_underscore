package ch2 {
  case class Director(firstName: String, lastName: String, yearOfBirth: Int) {
    def name = firstName + " " + lastName
  }

  object Director {
    def older(a: Director, b: Director): Director = if (a.yearOfBirth < b.yearOfBirth) a else b
  }

  case class Film(name: String, yearOfRelease: Int, imdbRating: Double, director: Director) {
    def directorsAge = director.yearOfBirth - this.yearOfRelease
    def isDirectedBy(director: Director) = this.director == director
  }

  object Film {
    def highestRating(a: Film, b: Film): Film = if (a.imdbRating > b.imdbRating) a else b
    def oldestDirectorAtTheTime(a: Film, b: Film): Director = if (a.directorsAge > b.directorsAge) a.director else b.director
  }
}


package ch3 {
  case class Person(firstName: String, lastName: String)

  object StormTrooper {
    def inspect(person: Person): String =
      person match {
        case Person("Luke", "Skywalker") => "Stop, rebel scum!"
        case Person("Han", "Solo") => "Stop, rebel scum!"
        case Person(first, last) => s"Move along $first"
      }
  }

  case class Cat(name: String, colour: String, food: String)

  object ChipChop {
    def willServe(cat: Cat): Boolean =
      cat match {
        case Cat(_, _, "chips") => true
        case _ => false
      }
  }

  import ch2._

  object Dad {
    def rate(film: Film): Double =
      film.director match {
        case Director("Clint", "Eastwood", _) => 10.0
        case Director("John", "McTiernan", _) => 7.0
        case _ => 3.0
      }
  }

}

package ch4 {
  import java.util.Date

  trait Visitor {
    def id: String
    def createdAt: Date

    def age: Long = new Date().getTime - createdAt.getTime
  }

  case class Anonymous(id: String, createdAt: Date = new Date()) extends Visitor

  case class User(id: String, email: String, createdAt: Date = new Date()) extends Visitor

  trait Feline {
    def colour: String
    def sound: String
  }

  case class Cat(colour: String, sound: String, food:String) extends Feline

  case class Lion(colour: String, sound: String, maneSize: Int) extends Feline
  
}
