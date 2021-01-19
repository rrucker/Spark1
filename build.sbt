name := "SparkCouch2021"

version := "0.1"

scalaVersion := "2.12.10"
// % "provided" for mllib and streaming ? what does this do?? 12=20
libraryDependencies += "org.apache.spark" %% "spark-core" % "3.0.1"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.0.1"
libraryDependencies += "org.apache.spark" %% "spark-mllib" % "3.0.1"  % "provided"
libraryDependencies += "org.apache.spark" %% "spark-streaming" % "3.0.1"  % "provided"
libraryDependencies += "org.apache.spark" %% "spark-graphx" % "3.0.1"

libraryDependencies += "com.couchbase.client" %% "scala-client" % "1.1.1"
libraryDependencies += "org.apache.logging.log4j" % "log4j-core" % "2.14.0"
libraryDependencies  ++= Seq(
// Last stable release
"org.scalanlp" %% "breeze" % "1.1",

// Native libraries are not included by default. add this if you want them
// Native libraries greatly improve performance, but increase jar sizes.
// It also packages various blas implementations, which have licenses that may or may not
// be compatible with the Apache License. No GPL code, as best I know.
"org.scalanlp" %% "breeze-natives" % "1.1",

// The visualization library is distributed separately as well.
// It depends on LGPL code
"org.scalanlp" %% "breeze-viz" % "1.1"
)// end Seq
