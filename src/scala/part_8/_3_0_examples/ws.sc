type IntList = List[Int] //alias
type DenseMatrix[A] = Vector[Vector[A]] //with type
type SparseMatrix[+A] = Map[(Int, Int), A] //with covariance

def evens(xs: IntList): IntList = xs.filter(_ % 2 == 0) //alias usage same as original type
//type Matrix[F[X] <: Iterable[X], A] = F[F[A]] //parameter boundary

type IntMap[A] = Map[Int, A]

//custom types
//type DenseMatrixCustom[A] = Matrix[IntMap, A] //todo

//custom types

//component types
trait Item {
  type Key
  type Value

  def key: Key

  def value: Value
}

trait Coyoneda[A] {
  self =>
  type Pivot
  val start: Pivot
  val run: Pivot => A

  def value: A = run(start)
}

trait Container {
  type Item

  def values: List[Item]
}

val ints = new Container {
  type Item = Int
  val values = List(1, 2, 3)
}

ints.values

trait ContainerAux {
  type Item

  def values: List[Item]
}

object ContainerAux {
  type Aux[I] = ContainerAux {type Item = I}
}

