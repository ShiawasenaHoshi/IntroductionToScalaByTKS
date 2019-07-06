
class Waiter(name: String, list: List[String]) {
  println(s"My name $name")
  var l = list

  def giveMe(dish: String): Waiter = {
    l = l :+ dish
    this
  }

  def complete(): List[String] = l
}

val waiter = new Waiter("Иван", List.empty)
val positions = waiter.giveMe("борщ").giveMe("хлеб").complete()