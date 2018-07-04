package q2io

sealed trait Name
case class Quote(p: Process) extends Name {
  override def toString: String =
    s"'$p'"
}
