import org.apache.log4j.{Level, Logger}
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{SQLImplicits, SparkSession}
import org.apache.spark.sql.types._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.expressions.MutableAggregationBuffer
import org.apache.spark.sql._
import org.apache.spark.ml.linalg.DenseVector
import org.apache.spark.ml.linalg.SparseVector
import org.apache.spark.ml.linalg.{Vectors, Vector}
import org.apache.spark.ml.linalg.DenseVector


object Sparky extends App{
Logger.getLogger("org").setLevel(Level.OFF)
type I = Int ; type S = String; type D = Double; type B = Boolean
val spark = SparkSession.builder().appName("Sparky")
.master("local[*]").getOrCreate()
spark.conf.set("spark.sql.shuffle.partitions", "5")
import spark.implicits._
println(s" Spark version: ${spark.version}")

}// end Sparky
