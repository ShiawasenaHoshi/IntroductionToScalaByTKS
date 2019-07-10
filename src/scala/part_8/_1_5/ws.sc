case class Pair(first: Any, second: Any) {
  def swap: Pair = Pair(second, first)

  def apply(t: Any, s: Any) = new Pair(t, s)
}

val pair = Pair(123, "Oleg").swap
require(pair.first == "Oleg")
require(pair.second == 123)


