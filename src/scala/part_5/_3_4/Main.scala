package part_5._3_4

/**
  * Created by vasily on 10.06.19.
  * [5; 10], и (10; +∞)
  */

object Main extends App {
  case class Jar(name: String, value: Int, price: Double)
  val jars = List(Jar("Морской синий 6л", 6, 3000), Jar("Огненно-красный 12л", 12, 5000), Jar("Зеленый 1л", 1, 500.0))
  def discount: PartialFunction[Jar, String] = {
    case Jar(name, value, price) if value >= 5 && value <= 10 => s"$name " + (price*0.05)
    case Jar(name, value, price) if value > 10 => s"$name " + (price*0.1)
  }
  println(jars.collect(discount))
}
