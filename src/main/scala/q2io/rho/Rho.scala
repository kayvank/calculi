package q2io.rho


sealed class Rho
case class Process(p: q2io.Process) extends Rho
case class Name(n: q2io.Name) extends Rho
