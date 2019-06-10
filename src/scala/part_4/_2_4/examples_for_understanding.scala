package part_4._2_4

/**
  * Created by vasily on 10.06.19.
  */
object alert {
  def printAlertMessage(): Unit = {
    println("ALERT!!!")
  }
  printAlertMessage()
}

object multiplication {
  def multipleIntegers(first: Int, second: Int): Int = {
    val result = first * second
    result
  }

  println(multipleIntegers(5, 6))
}

object salaries_long {
  val salaries = Seq(20000, 70000, 40000)
  val doubleSalary = (x: Int) => x * 2
  val newSalaries = salaries.map(doubleSalary)
  println(newSalaries)
}

object salaries_short {
  val salaries = Seq(20000, 70000, 40000)
  val newSalaries = salaries.map(_ * 2)
  println(newSalaries)
}

object IDK {
  def sumTo(x: Int): Int = if(x == 0) 0 else x + sumTo(x - 1)

  def main(args: Array[String]) {
    alert
    multiplication
    salaries_long
    salaries_short

    val add1 = (_: Int) + 1
    println(add1(2))

    val calc42 = (f: Int => Int) => f(v1 = 42)
    println(calc42(add1))
    println(calc42(_ + 7))
    println(calc42(sumTo)) /*короче, у калк42 такая сигнатура, что он ждет метода, принимающего инт и возвращающего инт.
    Затем вхожую функцию - f берем и запускаем с параметром 42. v1 совершенно не обязателен, можно и просто 42 написать.
    Поиграю сам:
    */

    val bf = (takeIntReturnBool: Int => Boolean) => takeIntReturnBool(57)
    //теперь нужен метод с сигнатурой Int и возвращающий булеан
    val bool = (_: Int) % 2 == 1
    println(bf(bool))


  }
}