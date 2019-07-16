class Person (val name: String)

class Student(name: String, val course: Int)
  extends Person(name)

case class Pair[T](first: T, second: T) {
  def replaceFirst[B >: T](newValue: B): Pair[B] = {
    Pair(newValue, second)
  }
}

def printNames(pair: Pair[Person]): Unit = {
  println("1: " + pair.first.name + "  2: " + pair.second.name)
}

val pair = Pair(new Student("Pavel", 1), new Student("Oleg", 5))
printNames(pair.replaceFirst(new Person("Oliver")))