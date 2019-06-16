package part_5._5_5

/**
  * Created by vasily on 11.06.19.
  */

object Main extends App {
  def bar(e: Int): Option[Int] = Some(e)
  for (x <- List(None, Some(10))) {
    println(if (x.isEmpty) None else bar(x.get))
  }
}
