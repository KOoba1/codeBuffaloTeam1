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
}
