package part_5._3_0_examples

/**
  * Created by vasily on 24.06.19.
  */

object Main extends App {
  val divide10: PartialFunction[Int, Int] = {
    case 1 => 10
    case 2 => 5
    case 5 => 2
    case 10 => 1
  }

  println(divide10.isDefinedAt(2))
  println(divide10.isDefinedAt(3))
  println(divide10(2))
  try divide10(3) catch {
    case e: Throwable => println(e.getMessage)
  }
  println(List.range(1, 11))
  println(List.range(1, 11).collect(divide10))
}
