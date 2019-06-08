package part_3._4_5

/**
  * Created by vasily on 06.06.19.
  */
object Main {
  def main(args: Array[String]) {
    println("(^[a-z]{2,}$|\\d|^_|_$|__|[A-Z])".r.findFirstMatchIn(scala.io.StdIn.readLine()).isEmpty)
  }
}
