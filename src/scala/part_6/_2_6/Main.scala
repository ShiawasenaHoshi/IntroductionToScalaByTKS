package part_6._2_6

/**
  * Created by vasily on 24.06.19.
  */

object Main extends App {
  val list = List(10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150)

  var l: List[Int] = list.filter(_ < 100).filter(_ % 4 == 0).map(f => f / 4)
  l.take(l.size - 1).foreach(e => println(e))

  //oneliners from comments
  list.takeWhile(_ < 100).filter(_ % 4 == 0).map(_ / 4).dropRight(1).foreach(println)
  list.collect{case x if x < 100 & x % 4 ==0 => x / 4}.dropRight(1).foreach(println)
  list.filter(i => i < 100 && i % 4 == 0).map(_ / 4).init.foreach(println)

}
