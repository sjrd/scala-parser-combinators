import scala.util.parsing.combinator.Parsers
import scala.util.parsing.input.CharSequenceReader

import utest._

object T1100 extends TestSuite {
  class TestParsers extends Parsers {
    type Elem = Char

    def p: Parser[List[Char]] = rep1(p1)
    def p1: Parser[Char] = accept('a') | err("errors are propagated")
  }

val expected = """[1.4] error: errors are propagated

aaab
   ^"""

  def tests = TestSuite {

    "t1100" - {
      val tstParsers = new TestParsers
      val s = new CharSequenceReader("aaab")
      assert(expected == tstParsers.p(s).toString)
    }

  }
}
