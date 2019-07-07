trait Animal {
  val sound: String

  def voice: Unit = println("voice: " + sound)
}

class Cat extends Animal {
  override val sound: String = "Meow!"
}

class Dog extends Animal {
  override val sound: String = "Woof!"
}

class Fish extends Animal {
  override val sound: String = ""

  override def voice: Unit = println("Fishes are silent!")
}

val animals = Seq(new Cat, new Dog, new Fish)
animals.foreach(_.voice)