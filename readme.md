Download https://repo1.maven.org/maven2/org/eclipse/jetty/jetty-distribution/9.4.19.v20190610/jetty-distribution-9.4.19.v20190610.zip
and unzip into some folder

Build code with
$ sbt package

Copy /target/scala-2.12/codebuffalo_2.12-1.0.war into webapps folder of jetty

Launch server with
$ jetty-distribution-9.4.19.v20190610/bin/jetty.sh start








To push our GraphQL server to manage the data schema:
npx apollo service:push --endpoint=<your graphql endpoint here>

In .env file we have ENGINE_API_KEY=service:codeBuffaloTeam1-2019:nZoIK0OglFFTYR3inxKtKA

To access management: 
https://engine.apollographql.com/account/gh.brassogre/services

codeBuffaloTeam1-2019