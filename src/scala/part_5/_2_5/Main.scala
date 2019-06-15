package part_5._2_5

/**
  * Created by vasily on 10.06.19.
  */

object Main extends App {

  case class Pet(name: String, says: String)

  var pets: Array[Pet] = Array(
    Pet("wew", "meow"),
    Pet("wew", "nya"),
    Pet("Rex", "bark"),
    Pet("wew", "0"),
    Pet("wew", "1"),
    Pet("wew", "01")
  )
  val r_cat = "(meow|nya)".r
  val r_dog = "(Rex)".r
  val r_bot = ".*(0|1).*".r
  for (pet <- pets) {
    val kind = pet match {
      case Pet(_ , r_bot(says)) => "robot"
      case Pet(_, r_cat(says)) => "cat"
      case Pet(r_dog(name), _) => "dog"
      case _ => "unknown"
    }
    println(kind)
  }
}
