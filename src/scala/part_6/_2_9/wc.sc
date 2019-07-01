type Point = (Int, Int)
type Field = Vector[Vector[Boolean]]
type Ship = List[Point]
type Fleet = Map[String, Ship]
type Game = (Field, Fleet)
//
//def newField(size: Int): Field = Range(0, 10).map(b => Range(0, 10).map(t => false).asInstanceOf[Vector[Boolean]]).asInstanceOf[Field]
//
//def printField(field: Field): Unit = println(field.map(v => v.map(b => if (b) " X" else " .").mkString("")).mkString("\n"))
//val testField = ".........................X.........X.........X.........X............................................"
//var ship: Ship = List[Point]((6, 5), (7, 6), (8, 5), (9, 5))
//var field: Field = newField(10)
//
//val x = List[Point]((1, 4), (1, 3), (1, 2), (1, 1))
//x.groupBy(_._1).map { case (k, v) => (k, v.map(_._2)) }
//
//
//
//
//
//def validateShip(ship: Ship): Boolean = ship match {
//  case size if ship.length > 4 || ship.length < 1 => false
//  case out if ship.unzip.productIterator.toList.asInstanceOf[List[List[Int]]].flatten.exists(i => i > 9 || i < 0) => false
//  case _ => ship.size == 1 || List(ship.unzip._1.sorted, ship.unzip._2.sorted).count(l => Range(l.head, l.last + 1).size == l.size) == 1
//}
//
//val fleet3: Fleet = Map[String, Ship](
//  "BlackPearl" -> List[Point]((1, 6), (1, 7), (1, 8)),
//  "MillenniumFalcon" -> List[Point]((2, 5), (3, 5), (4, 5), (5, 5)),
//  "BlackCurve" -> List[Point]((2, 6), (2, 7), (3, 7)),
//  "MillenniumCurve" -> List[Point]((4, 5), (5, 5), (5, 6), (4, 6)),
//  "TwoDeckCurve" -> List[Point]((6, 6), (7, 7)),
//  "VaryagOutOfField" -> List[Point]((9, 9), (9, 10)),
//  "One1" -> List[Point]((7, 7)),
//  "Two2" -> List[Point]((7, 7)),
//  "gaps1" -> List[Point]((7, 7), (7, 9)),
//  "gaps2" -> List[Point]((7, 9), (7, 7)),
//  "gaps3" -> List[Point]((1, 1), (1, 2), (1, 3), (1, 5)),
//  "gaps4" -> List[Point]((1, 5), (1, 3), (1, 2), (1, 1))
//)
//
//fleet3.filter(m => validateShip(m._2)).keys == Set("MillenniumFalcon", "Two2", "BlackPearl", "One1")
//
//
//def markUsedCells(field: Field, ship: Ship): Field = Range(0, 10).map(i => Range(0, 10).map(j => ship.contains((i, j)) || field(i)(j))).asInstanceOf[Field]
////printField()
//
//markUsedCells(field, ship).map(v => v.map(b => if (b) "X" else ".").mkString("")).mkString("") == testField
//
//List(ship.unzip._1.sorted, ship.unzip._2.sorted).map(l => Range(l.head, l.last + 1).size == l.size).sorted == List(false, true)
//List(ship.unzip._1.sorted, ship.unzip._2.sorted).count(l => Range(l.head, l.last + 1).size != l.size)
//
//var notAllowed = Vector[Point]()
//
//ship.foreach(v => {
//  for {i <- v._1 - 1 to v._1 + 1; j <- v._2 - 1 to v._2 + 1}
//    notAllowed = notAllowed :+ (i, j)
//})
//var test = Set((1, 4), (1, 5), (1, 6), (2, 4), (2, 5), (2, 6), (3, 4), (3, 5), (3, 6), (2, 5), (2, 6), (2, 7), (3, 5), (3, 6), (3, 7), (4, 5), (4, 6), (4, 7), (3, 4), (3, 5), (3, 6), (4, 4), (4, 5), (4, 6), (5, 4), (5, 5), (5, 6), (4, 4), (4, 5), (4, 6), (5, 4), (5, 5), (5, 6), (6, 4), (6, 5), (6, 6))
//val res = ship.flatMap(t => Range(-1, 2).flatMap(i => List((t._1 + i, t._2 + i), (t._1 - i, t._2 + i), (t._1 + i, t._2 - i), (t._1, t._2 + i), (t._1 + i, t._2)))).toSet.filter(p => p.productIterator.toList.asInstanceOf[List[Int]].count(v => v >= 0 && v < 10) == 2)
//test == res

val inShipCount = 3
println(Range(0, scala.io.StdIn.readInt()).
  map(i => scala.io.StdIn.readLine().split(" ")))