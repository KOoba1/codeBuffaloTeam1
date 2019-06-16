Build requires that you have SBT (Simple build-tool installe)

Build code with
$ sbt package
There should be a file called ./target/scala-2.12/team1.war

(In emergency, there is a copy of that file in the root folder of the project)

Download
https://repo1.maven.org/maven2/org/eclipse/jetty/jetty-distribution/9.4.19.v20190610/jetty-distribution-9.4.19.v20190610.zip
and unzip into some folder

Copy /target/scala-2.12/code1.war into webapps folder of jetty-distribution/9.4.19.v20190610

Launch server with
$ cd jetty-distribution-9.4.19.v20190610
$ java -jar start.jar -Djetty.http.port=8081

*Instructions for javascript app go here*
