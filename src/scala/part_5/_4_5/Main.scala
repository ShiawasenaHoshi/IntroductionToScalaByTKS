package part_5._4_5

/**
  * Created by vasily on 11.06.19.
  */

object Main extends App {
  def swap3(tuple: (Int, Int, Int)): (Int, Int, Int) = (tuple._3, tuple._2, tuple._1)
  println(swap3((1, 2, 3)))
}
