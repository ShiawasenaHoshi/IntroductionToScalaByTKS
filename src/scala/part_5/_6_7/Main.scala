package part_5._6_7

/**
  * Created by vasily on 24.06.19.
  */

object Main extends App {
  def makeSimple(division: (Int, Int)): Either[String, (Int, Int)] = division match {
    case z if z._2 == 0 => Left("Zero divisor")
    case a if Math.abs(a._1) < Math.abs(a._2) =>
      var gcd: Int = BigInt(a._1).gcd(BigInt(a._2)).toInt
      Right(a._1 / gcd, a._2 / gcd)
    case _ => Left("Improper result")
  }

  def divide(p: (Int, Int))(q: (Int, Int)): Either[String, (Int, Int)] = (q, p) match {
    case i if makeSimple(i._1).getOrElse(-1) == -1 || makeSimple(i._2).getOrElse(-1) == -1 => Left("Invalid input")
    case _ =>
      var simple_p: (Int, Int) = makeSimple(p).getOrElse((-1,-1))
      var simple_q: (Int, Int) = makeSimple(q).getOrElse((-1,-1))
      makeSimple((simple_p._1 * simple_q._2, simple_p._2 * simple_q._1))
  }
}
