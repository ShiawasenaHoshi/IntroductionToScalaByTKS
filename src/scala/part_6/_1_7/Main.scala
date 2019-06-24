package part_6._1_7


/**
  * Created by vasily on 24.06.19.
  */

object Main {
  def main(args: Array[String]) {

    var k1: Int = 4
    var list1: List[Int] = List(3, 8, 1, 12, 23)
    var res1: Int = 12

    var k2: Int = 3
    var list2: List[Int] = List(4, 7, 6, 5, 12, 9, 5)
    var res2: Int = 5


    def kOrder(list: List[Int], k: Int): Int = list.sorted.toList(k - 1)

    println(kOrder(list1, k1) + " = " + res1)
    println(kOrder(list2, k2) + " = " + res2)

    var k: Int = scala.io.StdIn.readInt()
    var list: List[Int] = scala.io.StdIn.readLine().split(" ").map(s => Integer.parseInt(s)).toList
    println(kOrder(list, k))
  }
}
