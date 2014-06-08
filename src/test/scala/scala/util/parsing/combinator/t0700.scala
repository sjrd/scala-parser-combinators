import java.io.StringReader

import scala.util.parsing.combinator.Parsers
import scala.util.parsing.input.{CharArrayReader, StreamReader}

import utest._

object T0700 /*extends TestSuite*/ {
  class TestParsers extends Parsers {
    type Elem = Char

    def p: Parser[List[Int]] = rep(p1 | p2)
    def p1: Parser[Int] = 'a' ~ nl ~ 'b' ~ nl ^^^ 1
    def p2: Parser[Int] = 'a' ~ nl ^^^ 2
    def nl: Parser[Int] = rep(accept('\n') | accept('\r')) ^^^ 0
  }

  def tests = TestSuite {

    "t0700" - {
      val tstParsers = new TestParsers
      val s = "a\na\na"
      val r1 = new CharArrayReader(s.toCharArray())
      val r2 = StreamReader(new StringReader(s))
      assert("[3.2] parsed: List(2, 2, 2)" == tstParsers.p(r1).toString)
      assert("[3.2] parsed: List(2, 2, 2)" == tstParsers.p(r2).toString)
    }

  }
}
