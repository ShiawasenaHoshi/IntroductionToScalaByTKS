object FacedString {
  val regex = "\\*_\\*(.+)\\*_\\*".r
  def apply(input: String) = s"*_*$input*_*"

  def unapply(arg: String): Option[String] = arg match {
    case a if regex.findFirstMatchIn(arg).isDefined => Some(regex.findAllIn(arg).group(1))
    case _ => Some("Could not recognize string")
  }
}

"\\*_\\*(.+)\\*_\\*".r.findAllIn("asdasd*_*teswewet*_*weweew").group(1)
"\\*_\\*(.+)\\*_\\*".r.findAllIn("*_****text*_**_* -> ***text*_*").group(1)
FacedString.unapply("*_*teswewwwwwwwet*_*qwewefwefwq")