package codebuffalo

import org.scalatest.{FunSpec, Matchers}

import scala.collection.JavaConverters._

class TestQuery extends FunSpec with Matchers {
  describe("A call to MuseumActivity") {
    it("should result in 2 events") {
      val result: String = GraphQLHandler.doQuery(Map[String,String]("category" -> "recreational").asJava)
      result should not be ""
    }
  }
}
