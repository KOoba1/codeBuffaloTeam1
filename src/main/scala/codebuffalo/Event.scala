package codebuffalo

import scala.collection.JavaConverters._

final case class Event(eventId: Int,
                       activityId: Int,
                       name: String,
                       description: String,
                       address: String,
                       category: String,
                       popularity: Double,
                       price: Double,
                       time: String)

final case class Activity(activity: String,
                          accessibility: Double,
                          `type`: String,
                          participants: Int,
                          price: Double,
                          key: String)

final case class Query(activityId: Int,
                       activity: Activity,
                       events: List[Event])

object Query {
  def construct(activityId: Int,
                activity: Activity,
                events: java.util.List[Event]): Query = {
    Query(activityId, activity, events.asScala.toList)
  }
}
