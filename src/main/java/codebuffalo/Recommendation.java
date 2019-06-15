package codebuffalo;

import java.util.ArrayList;
import java.util.List;

public class Recommendation {

    private Recommendation() {}

    public static List<Integer> recommend(int activity) {
        List<Integer> result = new ArrayList<>(128);
        result.add(activity + 1);
        result.add(activity * 2);
        return result;
    }

    public static boolean influenced(int activity) {
        return activity == 123 || activity == 456;
    }
}
