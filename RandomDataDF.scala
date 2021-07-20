def randomStr(length: Int) = scala.util.Random.alphanumeric.take(length).mkString
def randomInt() = scala.util.Random.nextInt
import org.apache.spark.SparkConf
val conf = new SparkConf().setAppName("Scala_random_string_data").setMaster("yarn-client")
import org.apache.spark.SparkContext
val sparkContext = new SparkContext(conf)
val df = sparkContext.parallelize(Seq.fill(40000){(randomInt(),randomStr(20),randomStr(1000))},10).toDF("message_id","id","text_row")
sparkContext.stop()
