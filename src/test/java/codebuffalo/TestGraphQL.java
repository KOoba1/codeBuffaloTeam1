package codebuffalo;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class TestGraphQL {

    @Test
    public void testCallSucceeds() {
        HashMap<String, String> parameters = new HashMap<>();
        Object actual = GraphQLHandler.doQuery(parameters);
        Assert.assertNotNull(actual);
    }

}
