final case class Named[A](name: String, value: A) {
  def withName(newName: String): Named[A] = Named(newName, value)

  def toMap: Map[String, A] = Map(name -> value)

  def mapValue[B](f: A => B): Named[B] = Named(name, f(value))
}


final case class Dict[I <: Item](items: List[I]) {
  def +:[J >: I](item: J): Dict[J] = Dict(item :: items)
}

def dict[I <: Item](items: I*): Dict[I] = Dict(items.toList)

trait Item {
  def key: String

  def value: String
}

trait Comparable[A <: Comparable[A]] {
  def compare(x: A): Int
}

//-----------------practice---------------------
final case class MultiMap[Key, Value](items: Map[Key, List[Value]]) {
  override def toString: String =
    s"Multimap(${
      items.map { case (key, values) =>
        s"$key -> ${values.mkString(", ")}"
      }.mkString("; ")})"

  def add(key: Key, value: Value): MultiMap[Key, Value] =
    MultiMap(items + (key -> (items.get(key) match {
      case Some(values) => value :: values
      case None => List(value)
    })))

  def map[B](f: Value => B): MultiMap[Key, B] = MultiMap(items.mapValues(_.map(f)))

}

object MultiMap {
  def apply[Key, Value](items: (Key, Value)*): MultiMap[Key, Value] =
    MultiMap(items.groupBy(_._1).mapValues(_.map(_._2).toList))
}

val dict =  MultiMap(
  "apple" -> "fruit",
  "pear" -> "fruit",
  "carrot" -> "yellow",
  "apple" -> "delicious",
  "carrot" -> "vegetable"
)

dict.add("pear", "delicious").add("melon", "yellow")


dict.map(_.toUpperCase())

dict.map(_.length)