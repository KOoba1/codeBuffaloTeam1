package codebuffalo

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
                       events: List[Event]
                      )

