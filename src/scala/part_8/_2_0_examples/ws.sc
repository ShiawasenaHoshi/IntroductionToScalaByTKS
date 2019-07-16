import scala.util.Random

//case class Named[T](name: String, get: T)
case class Named[+T](name: String, get: T)

val namedDouble = Named("y", 1.5)
val namedString = Named("name", "somestring")

//----------------------COVARIANCE-----------------------

abstract class Animal(val tongue: String) {
  val age: Int

  def isAlive: Boolean
}

case class Dog(age: Int) extends Animal("Bark") {
  def isAlive = age < 13
}

case class Cat(age: Int, diet: String) extends Animal("Meow") {
  def isAlive = age < 15
}

object ShroedingersCat extends Cat(0, "Neutrino") {
  val rng = new Random()

  override def isAlive = rng.nextDouble() < 0.5
}

def speak(na: Named[Animal]): Unit = {
  val animal = na.get
  if (animal.isAlive)
    println(s"${na.name}: ${animal.tongue}")
}

speak(Named("ordinary cat", Cat(13, "whiskas")))
speak(Named("ordinary dog", Dog(10)))
speak(Named("Shroedingers cat", ShroedingersCat))

//---------------------CONTRVARIANCE---------------------------
//class Vet[A]
class Vet[-A]

def treatDogs(vet: Vet[Dog]) {}
val commonVet = new Vet[Animal]()
treatDogs(commonVet) //error: class Vet is not contrvariant in type A

