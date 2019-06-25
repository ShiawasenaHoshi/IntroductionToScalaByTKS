package part_6._2_7

import scala.io.StdIn

/**
  * Created by vasily on 26.06.19.
  */

object Main {
  def main(args: Array[String]) {
    //    var list: List[String] = List("28","40","9","61","END","23","12","34")
    //    println(list.takeWhile(s => s != "END").drop(1).sliding(1, 2).flatten.toList.map(_.toInt * 2).sum)

    var listBuf = new scala.collection.mutable.ListBuffer[String]()
    do {
      listBuf += scala.io.StdIn.readLine()
    } while (!listBuf.contains("END"))
    println(listBuf.toList.dropRight(1).drop(1).sliding(1, 2).flatten.toList.map(_.toInt * 2).sum)

    //most beautiful solution from comments
    println(Stream.continually(StdIn.readLine)
      .takeWhile(_ != "END")
      .zipWithIndex
      .collect { case (x, i) if (i + 1) % 2 == 0 => x.toInt * 2 }.sum)
  }
}
