package q2io.rho

import org.specs2._

class RhoSpecs extends Specification { def is = s2"""

  Rho Calculus Specification
    freeName(0)      $e1 
    freeName(input)  $e2
    freeeName(lift)  $e3
    freeeName(drop)  $e4 
    freeeName(par)   $e5
    freeeName(quote) $e6
    freeeName(Rho.Process) $e7
"""
 import FreeName._ 
 import q2io._

  def e1 = fn(Zero) === "0"

  def e2 = { // x(y).P
    val computation = Input(
                           Quote(Zero), //x
                           Quote(Zero), //y
                           Par(Zero,Zero) //P
    )
    val freeName = fn(computation)
    println(s"input-computation = ${computation}")
    println(s"freeName(input-computation)= ${freeName}")
    freeName.trim === "{'0'} U 0 U 0"
  }

  def e3 = {
    val computation = Lift( // x.<|P|>
                           Quote(Zero), // x
                           Zero)  //<|P|>
    val freeName = fn(computation)
    println(s"lift-computation = ${computation}")
    println(s"freeName(lift-computation)= ${freeName}")
    freeName.trim === "{'0'} U 0"
  }
  def e4 =  { 
    val computation = Drop(Quote(Par(Zero, Zero)))
    val freeName = fn(computation)
    println(s"drop-computation = ${computation}")
    println(s"freeName(drop-computation)= ${freeName}")
    freeName.trim === "{'0|0'}"
  }

  def e5 =  {
    val computation = Par( Zero, Zero )
    val freeName = fn(computation)
    println(s"par-computation = ${computation}")
    println(s"freeName(par-computation)= ${freeName}")
    freeName.trim === "0 U 0"
  }

  def e6 = {
    val computation = Drop(Quote(Zero))
    val freeName = fn(computation)
    println(s"Drop-computation = ${computation}")
    println(s"freeName(Drop-computation)= ${freeName}")
    freeName.trim === "{'0'}"
  }

  def e7 = {
    val computation = q2io.rho.Process(Par( Zero, Zero ) )
    val freeName = fn(computation)
    println(s"RHO.par -computation = ${computation}")
    println(s"freeName(RHO.par-computation)= ${freeName}")
    freeName.trim === "0 U 0"
  }

}
