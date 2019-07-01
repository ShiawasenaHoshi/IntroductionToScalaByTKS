package part_6._2_10

import scala.io.StdIn

/**
  * Created by vasily on 01.07.19.
  */


abstract class DiffList[A](calculate: List[A] => List[A]) {
  def prepend(s: List[A]): DiffList[A]

  def append(s: List[A]): DiffList[A]

  def result: List[A]
}

final class DiffListImpl[A](listFunc: List[A] => List[A]) extends DiffList[A](listFunc) {

  def prepend(s: List[A]) = new DiffListImpl(t => s ++ listFunc(result))

  def append(s: List[A]) = new DiffListImpl(t => listFunc(result) ++ s)

  def result: List[A] = listFunc(List())
}


object Main {
  def main(args: Array[String]) {

    val l1 = List(1,2,3)
    val l2 = List(4,5,6)
    val dl = new DiffListImpl[Int](identity)

    val result = dl.append(l2).prepend(l1).result + " " + List(1,2,3,4,5,6)
  }
}

