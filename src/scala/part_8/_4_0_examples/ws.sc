def concatAll(list: List[String]): String = list.foldLeft("")((x, y) => x + y)
def sumAll(list: List[Int]): Int = list.foldLeft(0)((x, y) => x + y)
def forAll(list: List[Boolean]): Boolean = list.foldLeft(true)((x, y) => x && y)

sumAll(List(1, 2, 3))
concatAll(List("1 ", "s", "assa"))

///////////but there is better way
trait ExplicitMonoid[A] {
  def empty: A

  def combine(x: A, y: A): A
}

def combineAllExplicit[A](list: List[A])(monoid: ExplicitMonoid[A]): A = list.foldLeft(monoid.empty)(monoid.combine)

object IntExplicitMonoid extends ExplicitMonoid[Int] {
  override def empty = 0

  override def combine(x: Int, y: Int) = x + y
}

object StringExplicitMonoid extends ExplicitMonoid[String] {
  override def empty = ""

  override def combine(x: String, y: String) = x + y
}

object BooleanExplicitMonoid extends ExplicitMonoid[Boolean] {
  override def empty = true

  override def combine(x: Boolean, y: Boolean) = x && y
}

combineAllExplicit(List(1, 2, 3))(IntExplicitMonoid)

//////////it's better, but not so beautiful as implicit
trait Monoid[A] {
  //monoid-trait same as before
  def empty: A

  def combine(x: A, y: A): A
}

object Monoid {

  implicit object IntMonoid extends Monoid[Int] {
    override def empty = 0

    override def combine(x: Int, y: Int) = x + y
  }

  implicit object StringMonoid extends ExplicitMonoid[String] {
    override def empty = ""

    override def combine(x: String, y: String) = x + y
  }

  implicit object BooleanMonoid extends ExplicitMonoid[Boolean] {
    override def empty = true

    override def combine(x: Boolean, y: Boolean) = x && y
  }

}

def combineAll[A](list: List[A])(implicit monoid: Monoid[A]): A = list.foldLeft(monoid.empty)(monoid.combine)

combineAll(List(1, 2, 3)) //perfect

//to see what implicit conversions happened use ctrl+shift+q

//---------------PRACTICE
import Ordering.Implicits._
import language.implicitConversions

final case class Ratio private[Ratio](num: BigInt, den: BigInt)

object Ratio {
  def make(num: BigInt, den: BigInt): Ratio = {
    val gcd = num.gcd(den)
    Ratio(num / gcd, den / gcd)
  }

  implicit val ordering: Ordering[Ratio] = new Ordering[Ratio] {
    override def compare(x: Ratio, y: Ratio): Int =
      Ordering[BigInt].compare(x.num * y.den, x.den * y.num)
  }
}

implicit class RatioOps[T](val num: T) {
  def \\(den: BigInt)(implicit f: T => BigInt): Ratio = Ratio.make(num, den)
}

(2 \\ 4) < (3 \\ 5)
List(2 \\ 4, 3 \\ 5).min
