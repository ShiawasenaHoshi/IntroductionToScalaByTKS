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

val l1 = List(1, 2, 3)
val l2 = List(4, 5, 6)

val dl0 = new DiffListImpl[Int](identity)
dl0.result
dl0.prepend(l1).result
//
val dl = new DiffListImpl[Int](identity)

val result = dl.append(l2).prepend(l1).result// + " " + List(1, 2, 3, 4, 5, 6)


var listAppend: List[String] => List[String] = t => t ++ List("12")
var listAppend2: List[String] => List[String] = t => t ++ listAppend(List("23"))
var listAppend3: List[String] => List[String] = t => t ++ listAppend2(List("22"))


listAppend3(List())