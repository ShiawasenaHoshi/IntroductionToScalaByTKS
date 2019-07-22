package part_8._4_6

/**
  * Created by vasily on 22.07.19.
  */

object Main {

  trait Expr[T] {
    //==monoid
    def literalInt(value: Int): T

    def variable(name: String): T

    def times(x: T, y: T): T

    def plus(x: T, y: T): T

    def minus(x: T, y: T): T = plus(x, negate(y))

    def negate(x: T): T = times(x, literalInt(-1))
  }




  object exprSyntax {
    def literalInt[T](value: Int)(implicit expr: Expr[T]): T = expr.literalInt(value)

    def X[T](implicit expr: Expr[T]): T = expr.variable("x")

    def Y[T](implicit expr: Expr[T]): T = expr.variable("y")

    def Z[T](implicit expr: Expr[T]): T = expr.variable("z")

    implicit class IntToExpr[T](x: Int)(implicit expr: Expr[T]) {
      def lit: T = expr.literalInt(x)
    }

    implicit class NumOps[T](val x: T) {
      def +(y: T)(implicit expr: Expr[T]): T = expr.plus(x, y)

      def -(y: T)(implicit expr: Expr[T]): T = expr.minus(x, y)

      def *(y: T)(implicit expr: Expr[T]): T = expr.times(x, y)

      def unary_-(implicit expr: Expr[T]): T = expr.negate(x)
    }

  }
  final case class Print(s: String, priority: Int, isLit: Boolean = false) {
    def print(outer: Int = 0) = if (outer <= priority) s else s"($s)"
  }

  object Expr {
    // monoid
    implicit val stringOrderExpr: Expr[Print] = new Expr[Print] {
      override def literalInt(value: Int) = Print(value.toString, 4, isLit = true)

      override def variable(name: String): Print = Print(name.toUpperCase(), 5)

      override def times(x: Print, y: Print): Print = if (x.isLit) Print(x.print(3) + "" + y.print(3), 3) else Print(x.print(3) + "*" + y.print(3), 3)

      override def plus(x: Print, y: Print): Print = Print(x.print(2) + "+" + y.print(2), 2)

      override def minus(x: Print, y: Print): Print = Print(x.print(2) + "-" + y.print(2), 2)

      override def negate(x: Print): Print = Print("-" + x.print(1), 1)
    }
  }

  def main(args: Array[String]) {

    import exprSyntax._

    def function[T: Expr]: T = X * X + 2.lit * (Y + Z * X * 2.lit) - 7.lit * Z + 4.lit

    println(function[Print].print()) // X*X+2(Y+Z*X*2)-7Z+4
  }
}
