trait AbstractBank {
  def a: Char = '_'

  def b: Char = '_'

  def c: Char = '_'

  def d: Char = '_'

  def e: Char = '_'

  def f: Char = '_'

  def issueCredit: Unit = println("" + b + c + a + d + f + e)
}

trait BankA extends AbstractBank {
  override val b = 'T'
  override val d = 'R'
  override val f = 'I'
}

trait BankB extends AbstractBank {
  override val a = 'E'
  override val f = 'D'
}

trait BankC extends AbstractBank {
  override val b = 'C'
  override val d = 'D'
}

trait BankD extends AbstractBank {
  override val c = 'R'
  override val b = 'C'
  override val d = 'E'
}

trait BankE extends AbstractBank {
  override val a = 'I'
  override val b = 'C'
  override val e = 'T'
}

class CreditBank() extends AbstractBank with BankE with BankB with BankA with BankD with BankC {
//  def issueCredit: Unit = println("" + b + c + a + d + f + e)
}

val v = new CreditBank
v.issueCredit
val e = new BankE {}.issueCredit
val b = new BankB {}.issueCredit
val a = new BankA {}.issueCredit
val d = new BankD {}.issueCredit
val c = new BankC {}.issueCredit
