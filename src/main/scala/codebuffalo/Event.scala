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

final case class Activity(key: Int,
                       activityId: Int,
                       name: String,
                       description: String,
                       address: String,
                       category: String,
                       popularity: Double,
                       price: Double,
                       time: String)

final case class Query(activityId: Int,
                       activity: Activity,
                       events: List[Event]
                      )

