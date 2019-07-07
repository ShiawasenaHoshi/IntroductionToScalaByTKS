package part_7._3_4

import scala.io.StdIn

/**
  * Created by vasily on 07.07.19.
  */
object FacedString {
  val regex = "\\*_\\*(.+)\\*_\\*".r

  def apply(input: String) = s"*_*$input*_*"

  def unapply(arg: String): Option[String] = arg match {
    case a if regex.findFirstMatchIn(arg).isDefined => Some(regex.findAllIn(arg).group(1))
    case _ => Some("Could not recognize string")
  }
}

object Main {
  def main(args: Array[String]) {
    println(FacedString.unapply(StdIn.readLine()).get)
  }
}
