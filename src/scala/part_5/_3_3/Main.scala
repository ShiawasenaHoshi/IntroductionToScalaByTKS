package part_5._3_3

/**
  * Created by vasily on 10.06.19.
  * Thanks to comment with this link https://dzone.com/articles/partial-functions-in-scala
  */

object Main extends App {

  val log: PartialFunction[Double, Double] = {
    case d: Double if d > 0 => Math.log(d)
  }
  println(log.isDefinedAt(1))
  println(log.isDefinedAt(0))
  println(log.isDefinedAt(-1))
}
