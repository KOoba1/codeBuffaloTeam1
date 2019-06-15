package codebuffalo;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestGraphQL {

    @Test
    public void testCallSucceeds() {
        Map<String, String> parameters = new HashMap<>();
        String actual = GraphQLHandler.doQuery(parameters);
        int id = Integer.parseInt(actual);
        Assert.assertNotEquals(0, id);
    }

}
