val val1 = "Right1"
val VAL1LEFTELSE = 1
def service1: Either[String, Double] = {
  if (val1 == "Right1")
    Right(3.0)
  else
    Left("LEFT IN 1")
}
val val2Right = 3
def service2(res1: Double): Either[String, Int] = {
    if(res1 == 3)
        Right(4)
    else
        Left("LEFT IN 2")
}
def service3: String = "TEST"
def service4(res1: Double, res2: Int, res3: String): Either[String, String] = {
  Left(res1 + " " + res2 + " " + res3)
}

def result = for {
  res1 <- service1
  res2 <- service2(res1)
  res4 <- service4(res1, res2, service3)
} yield res4

result