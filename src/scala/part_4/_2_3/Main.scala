package part_4._2_3

/**
  * Created by vasily on 06.06.19.
  */
object Main extends App {
  val mul3 = 3*(_: Double)
  val pow2 = (x: Double) => x*x

  println(pow2.compose(mul3)(5))
//  println((mul3 compose[Double] pow2 _)(5))
  println((pow2.andThen[Double] _)(mul3)(5))
  println((mul3 andThen pow2)(5))
}
