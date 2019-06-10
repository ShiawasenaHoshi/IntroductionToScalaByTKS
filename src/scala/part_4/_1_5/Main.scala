package part_4._1_5

/**
  * Created by vasily on 06.06.19.
  */
object Main extends App {
  def getGift() = {
    println("The gift is received")
    100
  }

  def sendGift(currentAmount: Int, gift: => Int) = {
    if (currentAmount >= 500)
      currentAmount + gift
    else
      currentAmount
  }

  val accountAmounts = List(100, 200, 500, 300, 700)
  val newAmounts = accountAmounts.map(amount => amount > sendGift(amount, getGift()))
  println(newAmounts)
}
