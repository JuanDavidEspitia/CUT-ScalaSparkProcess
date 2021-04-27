package net.bdb.cut

import org.apache.hadoop.fs.FsUrlStreamHandlerFactory
import org.apache.spark.SparkContext
import org.apache.spark.sql.{Column, DataFrame, Encoders, Row, SparkSession, types}
import org.apache.log4j.{Level, Logger}
import java.net.URL

case class Config (pathInput: String = null, delimiter: String = null, pathOutput: String = null,
                  partitionId: String = null, pathFinish: String = null, rulesHomologation: String = null)


object InitProcess {

  val nameApp = "CUT-Process"

  /**
   * SparkSession: Entry point to the underlying Spark functionality for
   * programmatically creating Spark RDD, DataFrame and DataSet
   */
  val spark: SparkSession = SparkSession
    .builder()
    .appName(nameApp)
    .enableHiveSupport()
    .getOrCreate()

  /**
   * Space to declare global variables
   */
  var pathInput: String = null
  var delimiter: String = null
  var pathOutput: String = null
  var partitionId: String =  null
  var pathFinish: String = null
  var rulesHomologation: String = null

  /**
   * DataFrames Globales
   */
  var dfInputTXT: DataFrame = spark.emptyDataFrame
  var dfTransaction: DataFrame = spark.emptyDataFrame
  var dfCatalog: DataFrame = spark.emptyDataFrame


  def main(args: Array[String]): Unit = {
    //avoid some messages of spark
    Logger.getLogger("Ingestion").setLevel(Level.INFO)
    Logger.getLogger("spark").setLevel(Level.WARN)
    //allow read gs address
    URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory)

    /**
     * Spark entry point
     */
    var sc: SparkContext = spark.sparkContext
    println("Se ha creado satisfactoriamente el proyecto Demo de CUT")

    // parsing the arguments
    val parser = new scopt.OptionParser[Config]("Ingestion CUT") {
      head("Ingestion CUT", "1.0", "Allow to make the ingestion from a csv file to hive table")
      opt[String]('i', "pathInput") required() action { (x, c) =>
        c.copy(pathInput = x)
      } text "pathInput is the path from the csv file"
      opt[String]('d', "delimiter") required() action { (x, c) =>
        c.copy(delimiter = x)
      } text "delimiter of the table ex (, \t, -) "
      opt[String]('o', "pathOutput") required() action { (x, c) =>
        c.copy(pathOutput = x)
      } text "Path destiny from parquet data"
      opt[String]('p', "partitionId") required() action { (x, c) =>
        c.copy(partitionId = x)
      } text "Column Id partition"
      opt[String]('f', "pathFinish") action { (x, c) =>
        c.copy(pathFinish = x)
      } text "path file finish process"
      opt[String]('h', "rulesHomologation") action { (x, c) =>
        c.copy(rulesHomologation = x)
      } text ("rulesHomologation: Tabla de homologación")
      help("help").text("prints this usage text")
    }

    /**
     * Parser arguments, really similar to constructor method in Java
     * charge Arguments
     */
    parser.parse(args, Config()) map { config =>
      pathInput = config.pathInput
      delimiter = config.delimiter
      pathOutput = config.pathOutput
      partitionId = config.partitionId
      pathFinish = config.pathFinish
      rulesHomologation = config.rulesHomologation



















    }









  }

}






