package part_6._1_0_examples

import scala.collection.mutable.Buffer


/**
  * Created by vasily on 24.06.19.
  */

object Main extends App {
  val ints = Array(1, 2, 3, 5)
  println(ints(2))
  ints(2) = 6
  println(ints(2))
  try
    ints(4) = 6
  catch {
    case e: Throwable => println(e)
  }
  //STRINGS
  val language = "Scala"
  val platform = "Stepik"
  val course = language + " " + platform
  println(course)
  val course1 = s"$language $platform"
  println(course1)
  val char: Char = course(3)
  println(char)

  //MUTABLE COLLECTIONS
  val strings = Buffer[String]()
  strings += "scala"
  strings += "+"
  strings += "stepik"
  strings += "="
  strings += "love"

  println(strings.mkString(" "))

  //IMMUTABLE COLLECTIONS
  val initial = Vector[String]("stepik")

  val mid = "scala" +: "+" +: initial
  val s2 = mid :+ "=" :+ "love"

  s2.mkString(" ")
  println(s2)
}
