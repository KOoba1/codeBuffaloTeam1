package codebuffalo

import org.scalatra._
// JSON-related libraries
import org.json4s.{DefaultFormats, Formats}

// JSON handling support from Scalatra
import org.scalatra.json._
import scala.collection.JavaConverters._

class App extends ScalatraServlet with ContentEncodingSupport with JacksonJsonSupport {

  // Sets up automatic case class to JSON output serialization, required by
  // the JValueResult trait.
  protected implicit lazy val jsonFormats: Formats = DefaultFormats

  // Before every action runs, set the content type to be in JSON format.
  before() {
    contentType = formats("json")
  }

  get("/") {
    """{"hello world"}"""
  }

  get("/similar/:id") {
    params.get("id") match {
      case Some(idlabel) =>
        val id = Integer.parseInt(idlabel)
        val ids = Recommendation.recommend(id).asScala
        ids
      case None => "{}"
    }
  }

}