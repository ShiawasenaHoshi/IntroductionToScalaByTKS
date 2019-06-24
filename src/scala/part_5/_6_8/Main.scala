package part_5._6_8

/**
  * Created by vasily on 24.06.19.
  */

object Main extends App {
  var l: List[Option[Int]] = List(None, Option(3),  Option(5), None)
  def flatten(options: List[Option[Int]]): List[Int] = options.collect({case i if i.isDefined => i.get})
  def flattenBeautiful(options: List[Option[Int]]): List[Int] = options.flatMap{ x => x }
  def flattenRight(options: List[Option[Int]]): List[Int] = options.flatten
  println(flatten(l))
  println(flattenBeautiful(l))
  println(flattenRight(l))
}
