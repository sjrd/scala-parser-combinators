import scala.io.Source
import scala.util.parsing.combinator.Parsers
import scala.util.parsing.input.Reader
import scala.util.parsing.input.Position

import utest._

object T5514 extends TestSuite with Parsers {
  var readerCount = 0
  class DemoReader(n: Int) extends Reader[String] {
    def atEnd = n == 0
    def first = if (n >= 0) "s" + n else throw new IllegalArgumentException("No more input.")
    def rest = new DemoReader(n - 1)
    def pos = new Position {
      def line = 0
      def column = 0
      def lineContents = first
    }
    readerCount += 1
  }


  type Elem = String
  def startsWith(prefix: String) = acceptIf(_ startsWith prefix)("Error: " + _)

  def tests = TestSuite {

    "t5514" - {
      val resrep = startsWith("s").*(new DemoReader(10))
      assert("[0.0] parsed: List(s10, s9, s8, s7, s6, s5, s4, s3, s2, s1)" == resrep.toString)
      assert(11 == readerCount)

      readerCount = 0
      val resrep5 = repN(5, startsWith("s"))(new DemoReader(10))
      assert("[0.0] parsed: List(s10, s9, s8, s7, s6)" == resrep5.toString)
      assert(6 == readerCount)
    }

  }
}
