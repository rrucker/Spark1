/**  SparkCouch2021. ScalaExemplar.sc
 * Showing some of Scala tools
 * 1.Type synonyms type D = Double;
 * 2. HOF functions that take or return functions
 * 'map' is such a HOF, as is filter, flatMap
 * anonymous function( lambda functions)
 *
 * 2021-01-29 rr
 */
 type D = Double; type V = Vector[D]

val vec1  = Vector(3.0, 4.0, 5.0)
val vec2 = Vector(6.0, 9.0, 15.0)
// Higher order function "map" takes an anonymous function
//and applies it to each element to return a list(
// or  whatever collection type it is working on)
// the transformed element need not be of the same type
val doubleVerbose: Vector[D] = vec1.map{ e => e * 2}
val double:Vector[D] = vec1 .map{ _ * 2}
val pairs = vec1 zip vec2
      Vector( (3.0, 6.0), (4.0, 9.0), (5.0, 15.0))
// functions take parameters of various types
def dot(v:Vector[D], w:Vector[D]):D =
              (v zip w) .map{case(x , y) => x * y}.sum
def dotVerbose(v: Vector[D],w: Vector[D]):D =
             (v zip w).map{ v =>v  match{case (x,y) => x * y}}.sum
//I can import at any point in the program,
// although usually at the start
import scala.math._
// euclidean length of a vector is called its "norm"
def norm(v: Vector[D]):D = sqrt(dot(v,v))
// Note the cosine similarity between any two compatible vectors
// IS the correlation coefficient
def cosineSimilarity(v:Vector[D], w: Vector[D]):D =
                               dot(v,w)/(norm(v) * norm(w))
cosineSimilarity(vec1, vec2)
// note that R2 , the statistical measure of closeness is the
// cosineSimilarity square
def angle(v:V, w:V):D = cosineSimilarity(v,w)// now convert to degrees
