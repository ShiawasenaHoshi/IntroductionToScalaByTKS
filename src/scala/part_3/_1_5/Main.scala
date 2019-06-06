package part_3._1_5

import scala.math.BigDecimal.RoundingMode.HALF_UP

/**
  * Created by vasily on 06.06.19.
  */
object Main extends App {
  def crispsWeight(weight: BigDecimal, potatoWaterRatio: Double, crispsWaterRatio: Double): BigDecimal = {
    var dryMatter = weight - weight * potatoWaterRatio
    var crispWeight = dryMatter/(1 - crispsWaterRatio)
    crispWeight.setScale(5, HALF_UP)
  }
  println(crispsWeight(90.0, 0.9, 0.1)  + " = 10")
  println(crispsWeight(100.0, 0.99, 0.98) + " = 50")
}

