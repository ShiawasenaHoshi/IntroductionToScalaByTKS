implicit def strToInt(x: String) = x.toInt
"123"
val y: Int = "123"
math.max("123", 111)

class Container[A <% Int] { def addIt(x: A) = 123 + x }

(new Container[String]).addIt("123")