package codebuffalo

import org.scalatest.{FunSpec, Matchers}

import scala.collection.JavaConverters._

class TestQuery extends FunSpec with Matchers {
  describe("A call to MuseumActivity") {
    it("should result in Nietzsche's") {
      val params: java.util.HashMap[String, String] = new java.util.HashMap[String, String]()
      params.put("category", "Creative")
      val result: Object = GraphQLHandler.doQuery(params)
      result should not be null
      result shouldBe a[Query]
      val q: Query = result.asInstanceOf[Query]
      q.activityId shouldBe 9216391
    }
    it("should result in Guitar Center") {
      Thread.sleep(500)
      val params: java.util.HashMap[String, String] = new java.util.HashMap[String, String]()
      params.put("category", "Chill_Master")
      val result: Object = GraphQLHandler.doQuery(params)
      result should not be null
      result shouldBe a[Query]
      val q: Query = result.asInstanceOf[Query]
      q.activityId shouldBe 3192099
    }
    it("should result in Albright-Knox Art Gallery") {
      Thread.sleep(500)
      val params: java.util.HashMap[String, String] = new java.util.HashMap[String, String]()
      params.put("category", "Fun")
      val result: Object = GraphQLHandler.doQuery(params)
      result should not be null
      result shouldBe a[Query]
      val q: Query = result.asInstanceOf[Query]
      q.activityId shouldBe 5490351
    }
    it("should result in one of two events") {
      Thread.sleep(500)
      val params: java.util.HashMap[String, String] = new java.util.HashMap[String, String]()
      params.put("category", "Social_Butterfly")
      val result: Object = GraphQLHandler.doQuery(params)
      result should not be null
      result shouldBe a[Query]
      val q: Query = result.asInstanceOf[Query]
      q.activityId == 6509779 || q.activityId == 2211716 shouldBe true
    }
  }
}
