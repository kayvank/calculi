package q2io

sealed trait Process 
case object Zero extends Process {
  override def toString: String = "0"
}
case class Input(x: Name, y: Name, p: Process) extends Process {
  override def toString: String = s"$x($y).$p"
}
case class Lift(x: Name, p: Process)extends Process  {
  override def toString: String = s"$x<|${p}|>"
}
case class Drop(x: Name) extends Process {
  override def toString: String = s"${172.toChar}$x${172.toChar}"
}
case class Par(p: Process, q: Process) extends Process {
  override def toString: String = s"$p|$q"
}
