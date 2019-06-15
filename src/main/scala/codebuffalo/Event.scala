package codebuffalo

import java.time.LocalDateTime

final case class Event(eventId: Int,
                       activityId: Int,
                       name: String,
                       description: String,
                       address: String,
                       category: String,
                       popularity: Double,
                       price: Double,
                       time: TimeRange)

//final case class LatLong(lat: Double, lon: Double)

final case class TimeRange(start: String, end: String)

case class Category(label: String)

object Chill extends Category("Chill Master")

object Butterfly extends Category("Social Butterfly")

object Creative extends Category("Creative")

object Worker extends Category("Worker Bee")

object Fun extends Category("Frolicker")
