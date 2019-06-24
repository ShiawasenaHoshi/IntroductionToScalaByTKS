package part_5._6_0_examples

/**
  * Created by vasily on 24.06.19.
  */

object Main extends App {
  val numOrStr1: Either[Double, String] = Left(2.12)
  val numOrStr2: Either[Double, String] = Right("scala")

  def info(numOrStr: Either[Double, String]): String = numOrStr match {
    case Left(num) => s"number $num"
    case Right(str) => s"string $str"
  }

  println(info(numOrStr1))
  println(info(numOrStr2))

  def sqrt(x: Double): Either[String, Double] =
    if(x < 0) Left("negative number")
    else Right(Math.sqrt(x))

  println(sqrt(-1))
  println(sqrt(5))

  println(sqrt(7).getOrElse(0))
  println(sqrt(-1).getOrElse(0))

  println(sqrt(3).filterOrElse(_ > 2, "too small"))
  println(sqrt(16).filterOrElse(_ > 2, "too small"))

  println(sqrt(7).map(_.toString))
  println(sqrt(7).flatMap(x => sqrt(x)))
}
