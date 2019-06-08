package part_3._3_4

/**
  * Created by vasily on 06.06.19.
  */
object Main extends App{
  def isCapital(word: String, pos: Int): Boolean = {
    Character.isUpperCase(word.charAt(pos))
  }

  println(isCapital("Scala", 0))
}
