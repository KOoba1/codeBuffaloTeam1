package codebuffalo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Recommendation {

    private Recommendation() {
    }

    public static List<Integer> recommend(int activity) { // Takes in the key from the bored API

        List<Integer> result = new ArrayList<>(128);
        result.add(activity + 1);
        result.add(activity * 2);
        return result;  // returns a list of integers
    }

    public static boolean influenced(int activity) {
        return activity == 123 || activity == 456;
    }

    /*
    final case class Event(eventId: Int,
                       activityId: Int,
                       name: String,
                       description: String,
                       address: String,
                       category: Category,
                       popularity: Double,
                       price: Double,
                       location: Option[LatLong],
                       time: Option[TimeRange])

     */
    public static List<Event> events(int activity) { // Takes in the key from the bored API
        List<Event> events = new ArrayList<>();

        switch (activity) {

            // Events that are in the "Fun"
            case 5490351:
                events.add(new Event(1, 5490351,
                        "The Albright-Knox Art Gallery", "The Albright–Knox Art Gallery is an art " +
                        "museum located at 1285 Elmwood Avenue, " +
                        "Buffalo, New York, in Delaware Park. The gallery is a major showplace for modern" +
                        " art and contemporary art. It is located directly opposite Buffalo State College " +
                        "and the Burchfield Penney Art Center.",
                        "1285 Elmwood Ave, Buffalo, NY 14222",
                        "Fun", 0.8, 12, new TimeRange("10am", "5pm")));
                events.add(new Event(2, 5490351, "The Buffalo Museum of Science", "The Buffalo " +
                        "Museum of Science is a science museum " +
                        "located at Martin Luther King Jr. Park in Buffalo, New York, United States, northeast of " +
                        "the downtown district, near the Kensington Expressway. The historic building was designed by" +
                        " August Esenwein and James A. Johnson and opened in 1929.",
                        "Humboldt Pkwy, Buffalo, NY 14211", "Fun", 0.7, 11, new TimeRange("10am", "4pm")));
                break;

                // Events that are in "Social Butterfly"
            case 2211716:
                events.add(new Event(3, 2211716, "Nietzsche’s", "Nietzsche's is one of Buffalo’s " +
                        "truly legendary venues—not only because it is a linchpin in the local scene but because of its " +
                        "welcoming reputation among national and regional touring acts. Nietzsche’s is a fixture in " +
                        "Allentown, host to parties, benefits, local characters, and night after night after night of live music.",
                        "248 Allen St, Buffalo, NY 14201", "social butterfly", 0.95, 0, new TimeRange("12pm", "4am")));
               break;

               // Events that are in "Chill Master"
            case 3192099:
                events.add(new Event(4, 3192099, "Guitar Center", "Our broad range of " +
                        "equipment makes us a major music player in the Buffalo area. If you're in the market for " +
                        "anything from guitars to mandolins to drums, we have an extensive selection of new, used, vintage " +
                        "and clearance gear.","3385 Union Rd Suite 300, Cheektowaga, NY 14225", "Chill Master",
                        0.5, 0, new TimeRange("10am", "9pm")));
                break;
           // case 9216391:
               // events.add(new Event)
                default:
                break;
        } ;
        return events;
    }
}
