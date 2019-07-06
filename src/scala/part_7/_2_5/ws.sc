val s = "This is a Wonderful Test!"

trait StringProcessor {
  def process(input: String): String
}

val tokenDeleter = new StringProcessor {
  override def process(input: String): String = input.replaceAll("[-.?!)(,:]", "")
}

val shortener = new StringProcessor {
  override def process(input: String): String = if (input.length > 20) input.substring(0, 20) + "..." else input
}

val toLowerConvertor = new StringProcessor {
  override def process(input: String): String = input.toLowerCase
}

toLowerConvertor.process(shortener.process(tokenDeleter.process(s)))