package part_4._1_6

/**
  * Created by vasily on 06.06.19.
  */
object Main extends App {
  def fibs(num: Int) = {
    if (num == 1) 1
    else if (num == 2) 1
    else {
      var fib1, fib2 = 1
      var i, fib_sum = 0
      while (i < num - 2) {
        fib_sum = fib1 + fib2
        fib1 = fib2
        fib2 = fib_sum
        i = i + 1
      }
      fib_sum
    }
  }

  println(fibs(25) + " =  75025")
}
