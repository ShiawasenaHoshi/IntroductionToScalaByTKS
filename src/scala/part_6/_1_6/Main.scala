package part_6._1_6

/**
  * Created by vasily on 24.06.19.
  */
object Lesson {
  val ints: List[Int] = List(0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0)
}

object Main {
  def main(args: Array[String]) {
    val ints: List[Int] = Lesson.ints
    println(ints.filter(_ == 0).mkString(","))
    println(ints.filter(_ == 1).mkString(","))

    //2 oneliners by other participants
    println({
      ints.partition(_ == 0).productIterator.foreach(x => println(x.asInstanceOf[List[Int]].mkString(",")))
    })

    println({
      ints.groupBy(_ == 1).values.foreach(a => println(a.mkString(",")))
    })
  }
}

