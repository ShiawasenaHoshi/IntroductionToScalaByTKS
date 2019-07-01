package part_6._2_9


import part_6._2_9.Main.{Field, Fleet, Point, Ship}

import scala.collection.mutable.ListBuffer
import scala.io.StdIn

/**
  * Created by vasily on 26.06.19.
  */

object Main {
  type Point = (Int, Int)
  type Field = Vector[Vector[Boolean]]
  type Ship = List[Point]
  type Fleet = Map[String, Ship]
  type Game = (Field, Fleet)

  def main(args: Array[String]) {
    def readFleet: Fleet = Range(0, scala.io.StdIn.readInt())
      .flatMap(i => Seq(scala.io.StdIn.readLine().split(" "))
        .map(arr => arr(0) -> Range(0, arr(1).toInt)
          .map(j => Seq(scala.io.StdIn.readLine().split(" "))
            .map(tup => tup(0).toInt -> tup(1).toInt).head
          ).toList
        ).toMap)
      .toMap

    def validateShip(ship: Ship): Boolean = ship match {
      case size if ship.length > 4 || ship.length < 1 => false
      case out if ship.unzip.productIterator.toList.asInstanceOf[List[List[Int]]].flatten.exists(i => i > 9 || i < 0) => false
      case _ => ship.size == 1 || List(ship.unzip._1.sorted, ship.unzip._2.sorted).map(l => Range(l.head, l.last + 1).size == l.size).sorted == List(false, true)
    }

    def validatePosition(ship: Ship, field: Field): Boolean = !ship.flatMap(t => Range(-1, 2)
      .flatMap(i => List((t._1 + i, t._2 + i), (t._1 - i, t._2 + i), (t._1 + i, t._2 - i), (t._1, t._2 + i), (t._1 + i, t._2))))
      .toSet.filter(p => p.productIterator.toList.asInstanceOf[List[Int]].count(v => v >= 0 && v < 10) == 2)
      .exists(p => field(p._1)(p._2))


    def enrichFleet(fleet: Fleet, name: String, ship: Ship): Fleet = fleet + (name -> ship)

    def markUsedCells(field: Field, ship: Ship): Field = Range(0, 10).map(i => Range(0, 10).map(j => ship.contains((i, j)) || field(i)(j))).asInstanceOf[Field]

    def tryAddShip(game: Game, name: String, ship: Ship): Game = {
      if (validateShip(ship) && validatePosition(ship, game._1)) {
        println(name)
        return (markUsedCells(game._1, ship), enrichFleet(game._2, name, ship))
      }
      game
    }
    // Код для вставки на степик
//    val fleet: Fleet = readFleet
//    var game: Game = (field, Map.empty[String, Ship])
//    fleet.foreach(f => {
//      game = tryAddShip(game, f._1, f._2)
//    })

    var game: Game = (Test.newField(10), Map.empty[String, Ship])
    Test.fleet2.foreach(f => {
      //      println(f._1 + " " + validateShip(f._2))
      game = tryAddShip(game, f._1, f._2)
      //      Test.printField(game._1)
    })
  }

}

object Test {
  val fleetWithWrongShip: Fleet = Map[String, Ship](
    "MillenniumFalcon" -> List[Point]((2, 5), (3, 6), (4, 5), (5, 5)),
    "Varyag" -> List[Point]((2, 5), (3, 5), (4, 5), (5, 5), (6, 5))
  )

  val fleet1: Fleet = Map[String, Ship](
    "MillenniumFalcon" -> List[Point]((2, 5), (3, 5), (4, 5), (5, 5)),
    "Varyag" -> List[Point]((9, 9))
  )

  val fleet11: Fleet = Map[String, Ship](
    "MillenniumFalcon" -> List[Point]((2, 5), (3, 5), (4, 5), (5, 5)),
    "Varyag" -> List[Point]((9, 9))
  )
  val expected1 = List("MillenniumFalcon", "Varyag")
  val fleet2: Fleet = Map[String, Ship](
    "BlackPearl" -> List[Point]((1, 6), (1, 7), (1, 8)),
    "MillenniumFalcon" -> List[Point]((2, 5), (3, 5), (4, 5), (5, 5)),
    "Varyag" -> List[Point]((9, 9))
  )
  val expected2 = List("BlackPearl", "Varyag")

  val fleet3: Fleet = Map[String, Ship](
    "MillenniumFalcon" -> List[Point]((2, 5), (3, 6), (4, 5), (5, 5)),
    "BlackCurve" -> List[Point]((2, 6), (2, 7), (3, 7)),
    "MillenniumCurve" -> List[Point]((4, 5), (5, 5), (5, 6), (4, 6)),
    "TwoDeckCurve" -> List[Point]((6, 6), (7, 7)),
    "VaryagOutOfField" -> List[Point]((9, 9), (9, 10)),
    "One1" -> List[Point]((7, 7)),
    "Two2" -> List[Point]((7, 7)),
    "gaps1" -> List[Point]((7, 7), (7, 9)),
    "gaps2" -> List[Point]((7, 9), (7, 7)),
    "gaps3" -> List[Point]((1, 1), (1, 2), (1, 3), (1, 5)),
    "gaps4" -> List[Point]((1, 5), (1, 3), (1, 2), (1, 1))
  )
  val expected3 = List("BlackPearl", "Varyag")

  def printField(field: Field): Unit = println(field.map(v => v.map(b => if (b) " X" else " .").mkString("")).mkString("\n"))

  def newField(size: Int): Field = Range(0, 10).map(b => Range(0, 10).map(t => false).asInstanceOf[Vector[Boolean]]).asInstanceOf[Field]
}

object STDIN extends App {
  println(Range(0, scala.io.StdIn.readInt()).flatMap(i => Seq(scala.io.StdIn.readLine().split(" ")).map(arr => arr(0) -> Range(0, arr(1).toInt)
    .map(j => Seq(scala.io.StdIn.readLine().split(" ")).map(tup => tup(0).toInt -> tup(1).toInt).head
    ).toList
  ).toMap).toMap)
}

