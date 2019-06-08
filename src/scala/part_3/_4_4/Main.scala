package part_3._4_4

/**
  * Created by vasily on 06.06.19.
  */
object Main {
  def main(args: Array[String]) {
    val i: Array[String] = scala.io.StdIn.readLine().split(" ")
    val word: String = scala.io.StdIn.readLine()
    println(word.substring(0, i(0).toInt) + word.substring(i(0).toInt, i(1).toInt + 1).reverse + word.substring(i(1).toInt + 1))
  }
}
