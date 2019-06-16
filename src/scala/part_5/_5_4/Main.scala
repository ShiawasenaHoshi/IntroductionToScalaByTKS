package part_5._5_4

/**
  * Created by vasily on 11.06.19.
  */

object Main extends App {
  def foo(list: List[Int]): Int = list.find(p => p % 3 == 0).getOrElse(0) * 2

  println(foo(List(1, 1, 4, 4, 2)))
}
