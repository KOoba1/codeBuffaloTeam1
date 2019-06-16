package codebuffalo

import org.json4s.{DefaultFormats, FieldSerializer}
import org.scalatest.{FunSpec, Matchers}
import org.json4s.jackson.Serialization._
import org.json4s.jackson.JsonMethods._

class TestQuery extends FunSpec with Matchers {
  implicit val formats = DefaultFormats + FieldSerializer[Query]() + FieldSerializer[Event]() + FieldSerializer[Activity]()

  describe("A call to MuseumActivity") {
    it("should result in Nietzsche's") {
      val params: java.util.HashMap[String, String] = new java.util.HashMap[String, String]()
      params.put("category", "Creative")
      val result: Object = GraphQLHandler.doQuery(params)
      result should not be null
      result shouldBe a[Query]
      val q: Query = result.asInstanceOf[Query]
      q.activityId shouldBe 9216391
      q.events.size should not be 0
      val s = write(q.events)
      s should not be "[]"
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
      q.events.size should not be 0
      val s = write(q.events)
      s should not be "[]"
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
      q.events.size should not be 0
      val s = write(q.events)
      s should not be "[]"
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
      q.events.size should not be 0
      val s = write(q.events)
      s should not be "[]"
    }
  }
}
