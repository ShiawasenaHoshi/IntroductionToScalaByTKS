package part_6._2_8

import scala.io.StdIn

/**
  * Created by vasily on 26.06.19.
  */

object Main {
  def main(args: Array[String]) {
    val points: List[Int] = Lesson.points
    val chr1: List[Char] = Lesson.chr1
    val chr2: List[Char] = Lesson.chr2

    val toSwap = points
      .grouped(2)
      .toList
      .flatMap(pair => Range(pair.head, if (pair.length == 2) pair(1) else chr1.length).toList)
    List(List(chr2, chr1), List(chr1, chr2))
      .map(
        pair => pair.head.indices.toList.map(i => if (toSwap.contains(i)) pair.head(i) else pair(1)(i))
      ).foreach(l => println(l.mkString("")))

    //recursive solution from comments
    def crossover[T](points: List[Int], x: List[T], y: List[T]): (List[T], List[T]) =
      points match {
        case Nil => (x, y)
        case head :: tail =>
          val (a1, a2) = x.splitAt(head)
          val (b1, b2) = y.splitAt(head)
          val (newX, newY) = (a1 ::: b2, b1 ::: a2)
          crossover(tail, newX, newY)
      }


    val (crs1, crs2) = crossover(points, chr1, chr2)

    println(crs1.mkString(""))
    println(crs2.mkString(""))

    //laconic solution from comments
    var sequences = (Lesson.chr1, Lesson.chr2)

    def crossingOver(first: List[Char], second: List[Char], start: Int) =
      first.zip(second).zipWithIndex.map( x => if (x._2 >= start) x._1.swap else x._1).unzip

    points.foreach(i => {  sequences = crossingOver(sequences._1, sequences._2, i) })

    println(sequences._1.mkString(""))
    println(sequences._2.mkString(""))
  }
}

object Lesson {
  val points = List(1, 3)
  val chr1: List[Char] = "xxxxx".toList
  val chr2: List[Char] = "yyyyy".toList
  val res: List[String] = List("xyyxx", "yxxyy")

  val points2 = List(2, 4, 5)
  val chr12: List[Char] = "aaaaaaa".toList
  val chr22: List[Char] = "ddddddd".toList
  val res2: List[String] = List("aaddadd", "ddaadaa")

}
