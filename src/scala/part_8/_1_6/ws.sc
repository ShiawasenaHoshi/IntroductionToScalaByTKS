case class WrongSolutionButPassed[T] (first: T, second: T) {
  def smaller =
    if (first.toString.toInt < second.toString.toInt) first
    else second
}
val t = Pair(BigInt("1000000000000000"),BigInt("7000000000000000"))
//require(t.smaller == BigInt("1000000000000000")) //not working

case class RightSolution[T](first: T, second: T)(implicit im: T => Ordered[T]) {
  def smaller: T = {
    if (first < second) first
    else second
  }
}
val p = RightSolution(BigInt("1000000000000000"),BigInt("7000000000000000"))
require(p.smaller == BigInt("1000000000000000"))