package codebuffalo

import java.util

import org.json4s.FieldSerializer
import org.scalatra._
// JSON-related libraries
import org.json4s.{DefaultFormats, Formats}

// JSON handling support from Scalatra
import org.scalatra.json._
import scala.collection.JavaConverters._
import org.json4s.jackson.Serialization._
import org.json4s.jackson.JsonMethods._

class App extends ScalatraServlet with ContentEncodingSupport with JacksonJsonSupport {

  // Sets up automatic case class to JSON output serialization, required by
  // the JValueResult trait.
  protected implicit lazy val jsonFormats: Formats = DefaultFormats +
    FieldSerializer[Query]() + FieldSerializer[Event]() + FieldSerializer[Activity]()

  // Before every action runs, set the content type to be in JSON format.
  before() {
    contentType = formats("json")
  }

  get("/?") {
    """["hello","world"]"""
  }

  get("/events/:id/?") {
    params.get("id") match {
      case Some(idlabel) =>
        val id = Integer.parseInt(idlabel)
        val ids = Recommendation.events(id).asScala
        ids
      case None => "{}"
    }
  }

  get("/graphql/?") {
    val parameters: java.util.HashMap[String, String] = new util.HashMap
    params.get("category").foreach(c => parameters.put("category", c))
    GraphQLHandler.doQuery(parameters)
  }

}