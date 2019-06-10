package part_4._3_3

/**
  * Created by vasily on 10.06.19.
  */
import scala.annotation.tailrec

object Main extends App{
  @tailrec
  private def fibs(n: Int, currentNumber: Int = 1, f1: BigInt = 0, f2: BigInt = 1): BigInt = {
    if (n == currentNumber)
      f2
    else {
      fibs(n - 1, f1 = f2, f2 = f1 + f2)
    }
  }
  println(fibs(100) + " == 354224848179261915075")
}
