import utest._

object T4138 extends TestSuite {
  object p extends scala.util.parsing.combinator.JavaTokenParsers

  def tests = TestSuite {

    "t4138" - {
      assert("""[1.45] parsed: "lir 'de\' ' \\ \n / upa \"new\" \t parsing"""" == p.parse(p.stringLiteral, """"lir 'de\' ' \\ \n / upa \"new\" \t parsing"""").toString)
      assert("""[1.5] parsed: "s """" == p.parse(p.stringLiteral, """"s " lkjse"""").toString)
    }

  }
}
