name := "CodeBuffalo"

version := "1.0"

scalaVersion := "2.12.8"

val ScalatraVersion = "2.6.5"

libraryDependencies ++= Seq(
  "org.scalatra"            %% "scalatra"          % ScalatraVersion,
  "org.scalatra"            %% "scalatra-scalate"  % ScalatraVersion,
  "org.scalatra"            %% "scalatra-specs2"   % ScalatraVersion    % Test,
  "ch.qos.logback"          % "logback-classic"    % "1.2.3"            % Provided,
  "org.eclipse.jetty"       %  "jetty-webapp"      % "9.4.19.v20190610" % Provided,
  "javax.servlet"           %  "javax.servlet-api" % "3.1.0"            % Provided,
  "org.scalatra"            %% "scalatra-json"     % ScalatraVersion,
  "org.json4s"              %% "json4s-jackson"    % "3.6.6",
  "junit"                   % "junit"              % "4.12",
  "com.novocode"            % "junit-interface"    % "0.11" % "test",

  "com.apollographql.apollo" % "apollo-api" % "0.4.1"
)
enablePlugins(ScalatraPlugin)
