package codebuffalo

import org.json4s.JsonAST.JValue
import org.json4s._
import org.json4s.jackson.JsonMethods._

import scala.collection.JavaConverters._

object Json {
  implicit val formats = DefaultFormats

  def unmarshallActivity(s: String): Activity = {
    parse(s).extract[Activity]
  }

  def unmarshallEvents(s: String): java.util.List[Event] = {
    val events: JValue = parse(s)
    val sequence = events match {
      case JArray(x) => x
      case _ => throw new Exception("Should be list of events")
    }
    sequence.map(_.extract[Event]).asJava
  }
}
