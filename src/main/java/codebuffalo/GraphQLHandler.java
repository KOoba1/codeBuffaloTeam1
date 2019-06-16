package codebuffalo;

import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static graphql.schema.idl.RuntimeWiring.newRuntimeWiring;

public class GraphQLHandler {

    private static final int[] E = new int[]{6509779, 2211716, 9216391, 3192099, 5490351};

    public static Object doQuery(java.util.HashMap<String, String> parameters) {
        filterForRelevance(parameters);
        String schema = "type Query{bored: String} type schema{query: Query}";

        SchemaParser schemaParser = new SchemaParser();
        TypeDefinitionRegistry typeDefinitionRegistry = schemaParser.parse(schema);

        RuntimeWiring runtimeWiring = newRuntimeWiring()
                .type("Query",
                        builder -> builder.dataFetcher("bored",
                                e -> sendGet(makeUrl(parameters))))
                .build();

        SchemaGenerator schemaGenerator = new SchemaGenerator();
        GraphQLSchema graphQLSchema = schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);

        GraphQL build = GraphQL.newGraphQL(graphQLSchema).build();
        ExecutionResult executionResult = build.execute("{bored}");

        if (executionResult.isDataPresent()) {
            Map<String, String> result = executionResult.getData();
            String json = result.get("bored");
            Activity a = Json.unmarshallActivity(json);

            return doQuery2(a);
        } else {
            throw new RuntimeException("No data present for requested parameters");
        }
    }

    public static Object doQuery2(Activity a) {
        int key = Integer.parseInt(a.key());

        String schema = "type Query{extra: String} type schema{query: Query}";

        SchemaParser schemaParser = new SchemaParser();
        TypeDefinitionRegistry typeDefinitionRegistry = schemaParser.parse(schema);

        RuntimeWiring runtimeWiring = newRuntimeWiring()
                .type("Query",
                        builder -> builder.dataFetcher("extra",
                                e -> sendGet("http://localhost:8080/team1/events/" + key)))
                .build();


        SchemaGenerator schemaGenerator = new SchemaGenerator();
        GraphQLSchema graphQLSchema = schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);

        GraphQL build = GraphQL.newGraphQL(graphQLSchema).build();
        ExecutionResult executionResult = build.execute("{extra}");

        if (executionResult.isDataPresent()) {
            Map<String, String> result = executionResult.getData();
            String json = result.get("extra");
            List<Event> events = Json.unmarshallEvents(json);
            return Query.construct(key, a, events);
        } else {
            throw new RuntimeException("No data present for requested parameters");
        }
    }

    private static int getKey(String result) {
        int keyIndex = result.indexOf("\"key\"");
        String key = result.substring(keyIndex + 7, result.indexOf("\"", keyIndex + 8));
        System.out.println(key);
        return Integer.parseInt(key);
    }

    private static String makeUrl(Map<String, String> map) {
        StringBuilder url = new StringBuilder("https://www.boredapi.com/api/activity?");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            url.append("&").append(entry.getKey()).append("=").append(entry.getValue());
        }
        return url.toString();
    }

    private static String sendGet(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        StringBuffer response = new StringBuffer();
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
        }
        return response.toString();
    }

    private static void filterForRelevance(java.util.HashMap<String, String> ps) {
        String c = ps.get("category");
        if (c != null) {
            switch (c) {
                case "Social_Butterfly":
                    if (new Random().nextBoolean()) {
                        ps.put("key", "6509779");
                    } else {
                        ps.put("key", "2211716");
                    }
                    break;
                case "Creative":
                    ps.put("key", "9216391");
                    break;
                case "Chill_Master":
                    ps.put("key", "3192099");
                    break;
                case "Fun":
                    ps.put("key", "5490351");
                    break;
                default:
                    int index = new Random().nextInt(5);
                    ps.put("key", String.valueOf(E[index]));
                    break;
            }
        }
    }
}
