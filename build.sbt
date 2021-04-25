name := "CUT-Process"
version := "0.1"
scalaVersion := "2.11.12"
organization := "net.bdb.cut"

val sparkVersion = "2.3.2"

resolvers := Seq("Hortonworks" at "https://repo.hortonworks.com/content/repositories/releases/",
  "Google" at "https://mvnrepository.com/artifact/",
  "Google2" at "https://mvnrepository.com/artifact/com.google.cloud.bigdataoss/gcs-connector")

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion % "provided",
  "org.apache.spark" %% "spark-sql" % sparkVersion % "provided",
  "com.databricks" %% "spark-csv" % "1.5.0" % "provided",
  "com.github.scopt" %% "scopt" % "3.3.0"
)



