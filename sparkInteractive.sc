/**SparkCouch2021. sparkInteractive
 * first look at Spark
 * *** Important Note on DataFrame/Dataset
 * take(n) action that returns Rows of a DF'
 *    and instances of a case class DS
 * collect() action that returns ALL the
 *   Rows of a DF and ALL the instances
 *    of the case class type from
 *    all partitions (* be careful of memory overflow)
 *  limit(n) is a transformation and returns
 *    a DF ( or a DS if I started out with a DS
 *    a certain nr of rows
 * 2021-01-19 rr
 */
import org.apache.log4j.{Level, Logger}
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{SQLImplicits, SparkSession}
import org.apache.spark.sql.types._
import org.apache.spark.sql.functions._
import org.apache.spark.sql._
import org.apache.spark.ml.linalg.DenseVector
import org.apache.spark.ml.linalg.SparseVector
import org.apache.spark.ml.linalg.{Vectors, Vector}
import org.apache.spark.ml.linalg.DenseVector
// *********START  Interactive ************
Logger.getLogger("org").setLevel(Level.OFF)
type I = Int ; type S = String; type D = Double;
type B = Boolean
val spark = SparkSession.builder().appName("Sparky")
.master("local[*]").getOrCreate()
spark.conf.set("spark.sql.shuffle.partitions", "5")
// importing this allows later mthds ".toDF, *.toDS
import spark.implicits._

println(s" Spark version: ${spark.version}")
println(s"construct a range of Longs using a SparkSession method")
val nrs= spark.range(5).toDF("nr")
nrs.show(false)
val nativeObject= nrs.filter("nr >2").collect()
println(s"print out the filtered values: verbose, sparse ")
nativeObject.foreach(any => println(any))
nativeObject.foreach(println)
println(s" ACTIONS:  collect, take  on  a DataFrame ")
nrs.collect()
nrs.take(5)

println(s"transform the DataFrame to Dataset via a case class")
case class NrsLong(nr: Long)
val ds = nrs.as[NrsLong]
println(s"ACTIONS on a Dataset: count, collect, take  on a DS")
val dsCount   =  ds.count()
val dsCollect =  ds.collect()
val dsTake    =  ds.take(5)
// access second
val element2 = dsCollect(2).nr

// hmmmm how impose this type on nr?
// need a case class?
