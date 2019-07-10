//https://habr.com/ru/post/209850/

//---------------------IMPLICIT CONVERSION--------------------
case class Vasiliy(auto: Renault){
  println("Vasiliiy owns " + auto)
}

case class Renault(isRussian: Boolean = false)

case class VAZ(isRussian: Boolean = true)

object VAZ {
  implicit def vaz2renault(vaz: VAZ): Renault = Renault(vaz.isRussian)
}

object Family {
  def present = {
    Vasiliy(VAZ())
  }
}

Family.present

//---------------------IMPLICIT CLASS------------------------

object MySimpleHelper{
  implicit class StringExtended(str: String) {
    def sayIt = println(str)
    def sayItLouderBitch = println(str.toUpperCase + "!!!!")
  }
}

//implicit def String2StringExtended(str: String): StringExtended = new StringExtended(str)
import MySimpleHelper._
"oh gosh" sayIt

"oh gosh" sayItLouderBitch

//-----------------------IMPLICIT PARAMETER---------------------
implicit val myValue: Int = 5

object Jules {
  def doesHeLookLikeABitch(answer: String)(implicit times: Int) = {
    for (x <- 1 to times) println(answer)
  }
}

Jules.doesHeLookLikeABitch("WHAT?")

//----------------------VIEW BOUNDS---------------------

class Car {
  def exat() = println("POEXALI")
}

class VAZ2
object VAZ2 {
  implicit def vaz2tocar(v: VAZ2): Car = new Car()
}
def go[A <% Car](a: A) = a.exat()
go(new VAZ2)