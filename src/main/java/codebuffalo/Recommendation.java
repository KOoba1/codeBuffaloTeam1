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
                       time: String)

     */
    public static List<Event> events(int activity) { // Takes in the key of the activity that was chosen from the boredAPI
        List<Event> events = new ArrayList<>();

        // Adds specific events to our events List that correspond to the chosen activity
        switch (activity) {

            // Go to a museum
            case 5490351:
                events.add(new Event(1, 5490351,
                        "The Albright-Knox Art Gallery", "The Albright–Knox Art Gallery is an art " +
                        "museum located at 1285 Elmwood Avenue, " +
                        "Buffalo, New York, in Delaware Park. The gallery is a major showplace for modern" +
                        " art and contemporary art. It is located directly opposite Buffalo State College " +
                        "and the Burchfield Penney Art Center.",
                        "1285 Elmwood Ave, Buffalo, NY 14222",
                        "Fun", 0.8, 12,"Everday: 10am-5pm"));
                events.add(new Event(2, 5490351, "The Buffalo Museum of Science", "The Buffalo " +
                        "Museum of Science is a science museum " +
                        "located at Martin Luther King Jr. Park in Buffalo, New York, United States, northeast of " +
                        "the downtown district, near the Kensington Expressway. The historic building was designed by" +
                        " August Esenwein and James A. Johnson and opened in 1929.",
                        "Humboldt Pkwy, Buffalo, NY 14211", "Fun", 0.7, 11, "Everday: 10am-4pm"));
                events.add(new Event(3, 5490351, "The Buffalo History Museum","We have " +
                        "major collections on the Holland Land Company, U.S. President Millard Fillmore, Seneca Indians, " +
                        "Buffalo Bills, the Pan-American Exposition, the Larkin Company, and much more.  Recent collecting " +
                        "initiatives include our Newlywed Project, a collection of wedding memorabilia from legally-wed" +
                        " same-sex couples throughout WNY, our vintage menu collection drive seeking original menus from " +
                        "locally owned restaurants and the world’s largest Buffalo Bills football memorabilia collection.",
                        "1 Museum Ct, Buffalo, NY 14216", "Fun", 0.55, 10, "Everday: 10am-5pm"));
                break;

                // Go to a live music bar
            case 2211716:
                events.add(new Event(4, 2211716, "Nietzsche’s", "Nietzsche's is one of Buffalo’s " +
                        "truly legendary venues—not only because it is a linchpin in the local scene but because of its " +
                        "welcoming reputation among national and regional touring acts. Nietzsche’s is a fixture in " +
                        "Allentown, host to parties, benefits, local characters, and night after night after night of live music.",
                        "248 Allen St, Buffalo, NY 14201", "social butterfly", 0.95, 0,
                        "Everyday: 12pm - 4am"));
                events.add(new Event(5, 2211716, "Rec Room", "Live music bar", "79 W Chippewa St," +
                        " Buffalo, NY 14202", "social butterfly", 0.88, 0, "Friday's: 6pm - 3am" +
                        "Saturdays: 6pm - 2:30am"));
               break;

               // Learn a new instrument
            case 3192099:
                events.add(new Event(6, 3192099, "Guitar Center", "Our broad range of " +
                        "equipment makes us a major music player in the Buffalo area. If you're in the market for " +
                        "anything from guitars to mandolins to drums, we have an extensive selection of new, used, vintage " +
                        "and clearance gear.","3385 Union Rd Suite 300, Cheektowaga, NY 14225", "Chill Master",
                        0.4, 0, "Everday: 10am-9pm"));
                break;

               // Learn woodworking
            case 9216391:
                events.add(new Event(7, 9216391, "Toolbox OR Planter - Woodworking Class at The Foundry",
                        "In this quick class, you’ll get a overview of the tools in The Foundry's shared woodshop" +
                                " by making a classic carrier for tools OR an outdoor planter (same project different purpose)." +
                                " Learn about using the planer, tables saw, drills, and sanders. Participants leave with " +
                                "a whole new set of skills as well as a personalized keepsake - a container for your tools, " +
                                "herbs or geraniums...", "298 Northampton St, Buffalo, NY 14208", "Creative",
                        0.6,75, "6/29/2019: 4pm-7pm"));
                break;

                // Donate blood at a local blood center
            case 6509779:
                events.add(new Event(8, 6509779, "Union Road Blood Donation Center", "Blood Drive",
                        "3601 Union Road Cheektowaga, NY 14225", "social butterfly", 0.2, 0,
                        "6/16/2019: 7am-3pm"));
                break;

                default:
                break;
        } ;
        return events;
    }
}
