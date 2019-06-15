package part_5._1_5

/**
  * Created by vasily on 10.06.19.
  */

object Main extends App {
  var i1: Int = scala.io.StdIn.readInt()

  def gcd_pair(in: Int): Unit = {
    //    for (i <- 1 until in) {
    //      for (j <- 1 until in) {
    //        if(BigInt(i).gcd(BigInt(j)) == 1){
    //          println(i + " " + j)
    //        }
    //      }
    //    }
    for {
      i <- 1 until in
      j <- 1 until in
    } if (BigInt(i).gcd(BigInt(j)) == 1)
      println(i + " " + j)
  }

  gcd_pair(i1)
}
