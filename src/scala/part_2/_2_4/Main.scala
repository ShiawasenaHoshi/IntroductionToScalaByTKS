package part_2._2_4

/**
  * Created by vasily on 06.06.19.
  */
object Main extends App{
  def normalDistribution(mu: Double, sigma: Double, x: Double): Double = {
    val a: Double = 1 / (sigma * scala.math.sqrt(2 * scala.math.Pi))
    val power: Double = -1 * (scala.math.pow(x - mu, 2) / (2 * scala.math.pow(sigma, 2)))
    val b: Double = scala.math.pow(scala.math.E, power)
    val result: Double = a * b
    result
  }
}

