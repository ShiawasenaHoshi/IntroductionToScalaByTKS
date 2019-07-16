trait Vect extends Any {
  type Item

  def length: Int

  def get(index: Int): Item

  def set(index: Int, item: Item): Vect.Aux[Item]
}

object Vect {
  type Aux[I] = Vect {type Item = I}
}

final case class StringVect(str: String) extends Vect {
  type Item = Char

  def length = str.length

  def get(index: Int) = str.charAt(index)

  def set(index: Int, item: Char): Vect.Aux[Char] = StringVect(str.updated(index, item))
}

final case class BoolVect64(values: Long) extends Vect {
  type Item = Boolean

  def length = 64

  def get(index: Int) = ((values >> index) & 1) == 1

  def set(index: Int, item: Boolean): Vect.Aux[Boolean] = {
    val mask = 1L << index
    val item_numeric = if (item) 1 else 0
    BoolVect64((values & ~mask) | ((item_numeric << index) & mask))
  }
}

final case class BoolVect8(values: Byte) extends Vect {
  type Item = Boolean

  def length = 8

  def get(index: Int) = ((values >> index) & 1) == 1

  def set(index: Int, item: Boolean): Vect.Aux[Boolean] = {
    val mask = 1 << index
    val item_numeric = if (item) 1 else 0
    BoolVect8(((values & ~mask) | ((item_numeric << index) & mask)).toByte)
  }
}

def toList(vect: Vect): List[vect.Item] = (0 until vect.length).map(i => vect.get(i)).toList

BoolVect8(1) //==List(true, false, false, false, false, false, false, false)

BoolVect64(453141517689L)
toList(BoolVect64(453141517689L))
toList(BoolVect64(453141517689L).set(63, item = true))
toList(BoolVect64(453141517689L).set(63, item = true).set(0, item = false))
BoolVect64(453141517689L).set(63, item = true).set(0, item = false)

toList(BoolVect8(7))
toList(BoolVect8(7).set(7, true))
toList(BoolVect8(7).set(7, true).set(0, false))
toList(BoolVect8(7).set(7, true).set(0, false).set(5, true))
toList(BoolVect8(7).set(7, true).set(0, false).set(5, true).set(7, false))
BoolVect8(7).set(7, true).set(0, false).set(5, true).set(7, false).get(7)
BoolVect8(7).set(7, true).set(0, false).set(5, true).set(7, false).get(5)
