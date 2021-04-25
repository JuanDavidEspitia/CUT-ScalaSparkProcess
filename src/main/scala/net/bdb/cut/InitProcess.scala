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


  }

}






