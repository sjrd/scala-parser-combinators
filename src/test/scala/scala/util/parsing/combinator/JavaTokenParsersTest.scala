package scala.util.parsing.combinator

import scala.util.parsing.input.CharArrayReader

import utest._

object JavaTokenParsersTest extends TestSuite {

  def tests = TestSuite {

    "parseDecimalNumber" - {
      object TestJavaTokenParsers extends JavaTokenParsers
      import TestJavaTokenParsers._
      assert("1.1" == decimalNumber(new CharArrayReader("1.1".toCharArray)).get)
      assert("1." == decimalNumber(new CharArrayReader("1.".toCharArray)).get)
      assert(".1" == decimalNumber(new CharArrayReader(".1".toCharArray)).get)
      // should fail to parse and we should get Failure as ParseResult
      val failure = decimalNumber(new CharArrayReader("!1".toCharArray)).asInstanceOf[Failure]
      assert("""string matching regex `(\d+(\.\d*)?|\d*\.\d+)' expected but `!' found""" == failure.msg)
    }

    /* requires support for regexp "\p{javaJavaIdentifierStart}\p{javaJavaIdentifierPart}*"
    "parseJavaIdent" - {
      object javaTokenParser extends JavaTokenParsers
      import javaTokenParser._
      def parseSuccess(s: String): Unit = {
        val result = parseAll(ident, s)
        assertMatch(result) {
          case Success(r, _) if r == s =>
        }
      }
      def parseFailure(s: String, errorColPos: Int): Unit = {
        val result = parseAll(ident, s)
        assertMatch(result) {
          case Failure(_, next) =>
            val pos = next.pos
            assert(1 == pos.line)
            assert(errorColPos == pos.column)
        }
      }
      parseSuccess("simple")
      parseSuccess("with123")
      parseSuccess("with$")
      parseSuccess("with\u00f8\u00df\u00f6\u00e8\u00e6")
      parseSuccess("with_")
      parseSuccess("_with")

      parseFailure("3start", 1)
      parseFailure("-start", 1)
      parseFailure("with-s", 5)
      // we♥scala
      parseFailure("we\u2665scala", 3)
      parseFailure("with space", 6)
    }
    */

  }

}
