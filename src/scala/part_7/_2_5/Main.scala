package part_7._2_5

import scala.io.StdIn

/**
  * Created by vasily on 07.07.19.
  */
object Main {

  trait StringProcessor {
    def process(input: String): String
  }

  def main(args: Array[String]) {
    val tokenDeleter = new StringProcessor {
      override def process(input: String): String = input.replaceAll("[-.?!)(,:]", "")
    }

    val shortener = new StringProcessor {
      override def process(input: String): String = if (input.length > 20) input.substring(0, 20) + "..." else input
    }

    val toLowerConvertor = new StringProcessor {
      override def process(input: String): String = input.toLowerCase
    }

    println(toLowerConvertor.process(shortener.process(StdIn.readLine())))

  }

  def bestSolutionFromComments(args: Array[String]): Unit = {
    val tokenDeleter: StringProcessor = _.replaceAll("\\p{Punct}", "")

    val shortener: StringProcessor = input =>
      if (input.length <= 20) input
      else s"${input.take(20)}..."

    val toLowerConvertor: StringProcessor = _.toLowerCase

    val transform: String => String = (toLowerConvertor.process _).andThen(tokenDeleter.process).andThen(shortener.process)

    println(toLowerConvertor.process(shortener.process(StdIn.readLine())))
  }
}
