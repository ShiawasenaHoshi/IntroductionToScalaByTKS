class Point(val x: Double, val y: Double, val z: Double) {
  override def toString(): String = {
    s"$x $y $z"
  }
}

case object Point {
  def apply(x: Double, y: Double, z: Double): Point = new Point(x, y, z)

  def average(l: List[Point]): Point = if (l.isEmpty) new Point(0, 0, 0) else List(Range(0, 3).toList.map(i => l.map(p => List(p.x, p.y, p.z)).map(lp => lp(i)).sum / l.size)).map(ll => new Point(ll(0), ll(1), ll(2))).head

  def show(p: Point) = p.toString()
}

val p1 = Point.apply(1, 2, 3)
val p2 = Point.apply(4, 5, 6)
val p3 = Point.apply(7, 8, 9)
Point.show(p1)
val l = List(p1, p2, p3)
Point.average(l).toString()
l.map(p => List(p.x, p.y, p.z)).unzip3(ll => (ll(0), ll(1), ll(2)))
l.unzip3(p => (p.x, p.y, p.z))
