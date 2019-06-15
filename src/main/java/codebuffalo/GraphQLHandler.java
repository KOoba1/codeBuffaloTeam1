package codebuffalo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

import static graphql.schema.idl.RuntimeWiring.newRuntimeWiring;

public class GraphQLHandler {

    public static String doQuery(java.util.Map<String, String> parameters) throws Exception {
			  String schema = "type Query{bored: String} type schema{query: Query}";

        SchemaParser schemaParser = new SchemaParser();
        TypeDefinitionRegistry typeDefinitionRegistry = schemaParser.parse(schema);

        RuntimeWiring runtimeWiring = newRuntimeWiring()
                .type("Query",
                        builder -> builder.dataFetcher("bored",
                                e -> sendGet(makeUrl(parameters))))
                .build();
        //localhost:8080/team1/events/{id}
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        GraphQLSchema graphQLSchema = schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);

        GraphQL build = GraphQL.newGraphQL(graphQLSchema).build();
        ExecutionResult executionResult = build.execute("{bored}");

        if(executionResult.isDataPresent()) {
            String res = executionResult.getData().toString();
            System.out.println(res.substring(res.indexOf("{", 1), res.indexOf("}", 1) + 1));
            return getKey(res);
        } else {
            throw new RuntimeException("No data present for requested parameters");
        }
    }

    private static String getKey(String result) {
        int keyIndex = result.indexOf("\"key\"");
        String key = result.substring(keyIndex + 7, result.indexOf("\"", keyIndex + 8));
        System.out.println(key);
        return key;
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
        try(BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
        }
        return response.toString();
    }
}
