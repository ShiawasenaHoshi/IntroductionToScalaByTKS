package part_4._2_4

/**
  * Created by vasily on 06.06.19.
  */
object LessonData{
  def searchInArray(cond: Int => Boolean, array: List[Int]): List[Int] = {
    array.filter(cond)

  }
}

object Main {
  def main(args: Array[String]) {
    val cond = (_: Int) % 2 == 1
    println(LessonData.searchInArray(cond, List(8,11,12)))
    val searchOdd2 = (array: List[Int]) => LessonData.searchInArray(cond, array)
    println(searchOdd2(List(8,11,12)))
    val searchOdd = (array: List[Int]) => LessonData.searchInArray((_: Int) % 2 == 1, array)
    println(searchOdd(List(8,11,12)))
  }
}
