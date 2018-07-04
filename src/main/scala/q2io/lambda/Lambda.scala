package model

sealed trait M[X]
case class Variable[X](x: X) extends M[X]
case class Abstraction[X](x: X, m: M[X]) extends M[X]
case class Application[X](m1: M[X], m2: M[X]) extends M[X]

// P,Q ::= 0 | for (x ← y)P | x!Q | P|Q | *x
// x,y := @P
