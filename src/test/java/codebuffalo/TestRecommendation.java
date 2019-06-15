package codebuffalo;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestRecommendation {

    @Test
    public void testThatTwoRecommendationsExist() {
        List<Integer> expected = Arrays.asList(4, 6);
        List<Integer> actual = Recommendation.recommend(3);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testInfluencersChoice() {
        Assert.assertFalse(Recommendation.influenced(8));
        Assert.assertFalse(Recommendation.influenced(2987));
        Assert.assertTrue(Recommendation.influenced(123));
        Assert.assertTrue(Recommendation.influenced(456));
    }

    @Test
    public void testEvents1() {
        List<Event> events = Recommendation.events(5490351);
        Assert.assertEquals("Should be 3 events", 3, events.size());
    }

    @Test
    public void testEvents2() {
        List<Event> events = Recommendation.events(2211716);
        Assert.assertEquals("Should be 2 events", 2, events.size());
    }

    @Test
    public void testEvents3() {
        List<Event> events = Recommendation.events(3192099);
        Assert.assertEquals("Should be 1 event", 1, events.size());
    }

    @Test
    public void testEvents4() {
        List<Event> events = Recommendation.events(9216391);
        Assert.assertEquals("Should be 1 event", 1, events.size());
    }

    @Test
    public void testEvents5() {
        List<Event> events = Recommendation.events(6509779);
        Assert.assertEquals("Should be 1 event", 1, events.size());
    }

    @Test
    public void testEvents6() {
        List<Event> events = Recommendation.events(3334444);
        Assert.assertEquals("Should be 0 events", 0, events.size());
    }
}
