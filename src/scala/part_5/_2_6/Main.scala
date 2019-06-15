package part_5._2_6

/**
  * Created by vasily on 10.06.19.
  */

object Main extends App {

  val input1: List[String] = List("oleg","oleg@email.com","7bdaf0a1be3","a8af118b1a2","28d74b7a3fe")
  val input2: List[String] = List("oleg oleg@email.com", "7bdaf0a1be3", "a8af118b1a2", "28d74b7a3fe")
  val name = "^([a-zA-Z]+)$".r
  val domain = "^\\w+@(\\w+\\.\\w+)$".r
  val all = "^([a-zA-Z]+)\\s\\w+@(\\w+\\.\\w+)$".r
  for (input <- List(input1, input2)){
    val result = input match {
      case List(all(match1,match2), _*) => s"$match1 $match2"
      case List(name(match1), domain(match2), _*) => s"$match1 $match2"
      case _ => "invalid"
    }
    println(result)
  }


}
