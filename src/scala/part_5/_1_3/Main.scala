package part_5._1_3

/**
  * Created by vasily on 10.06.19.
  */

object Main extends App{
  for {i <-1 to 10; j <- 1 to 10} println(i + j)
  for (i <- 1 to 10; j <- 1 to 10) { println(i + j) }
  for (i <- 1 to 10; j <- 1 to 10) println(i + j)
//  for (i <- 1 to 10, j <- 1 to 10) { println(i + j) }

}
