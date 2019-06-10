package part_4._3_4

/**
  * Created by vasily on 10.06.19.
  */
object Lection extends App {
  def ifThenElseInt(cond: Boolean)(t: => Int, e: => Int): Int = if (cond) t else e

  println(ifThenElseInt(5 % 2 == 1)(1, 2))

  def ifThenElseT[T](cond: Boolean)(t: => T, e: => T): T = if (cond) t else e

  println(ifThenElseT(5 % 2 == 1)("1", "2"))
}

object Main extends App {


  def middle[T](data: Iterable[T]): T = {
    if (data.nonEmpty) data.splitAt(data.size / 2)._2.head else data.head
  }

  require(middle("Scala") == 'a')
  require(middle(Seq(1, 7, 5, 9)) == 5)
}
