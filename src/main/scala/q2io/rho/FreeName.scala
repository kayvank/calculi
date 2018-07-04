package q2io.rho

object FreeName {
  def fn(r: Rho): String =  r match {
    case q2io.rho.Process(p) ⇒ fn(p)
    case q2io.rho.Name(n) ⇒ fn(n)
  }
  def fn(n: q2io.Name): String = ""
  def fn(p: q2io.Process): String = {
    import q2io._
    p match {
      case Zero ⇒ s"0"
      case Input(x, _, p) ⇒ s"{$x} U ${fn(p)} "
      case Lift(x,p) ⇒ s"{$x} U ${fn(p)}"
      case Drop(x)⇒ s"{$x}"
      case Par(p, q) ⇒  s"${fn(p)} U ${fn(q)}"
    }
  }
}
 
