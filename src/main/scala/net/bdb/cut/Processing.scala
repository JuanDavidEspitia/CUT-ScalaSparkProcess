package net.bdb.cut

import net.bdb.cut.InitProcess._
import net.bdb.cut.Utils._
import org.apache.spark.sql.{DataFrame, DataFrameReader}

class Processing (pathInput: String, delimiter: String, pathOutput: String,
                  partitionId: String, pathFinish: String, rulesHomologation: String)
{

  /**
   * Global variables
   */
  var dfDataInput: DataFrame = spark.emptyDataFrame
  var dfReaderTmp: DataFrameReader = null

  dfDataInput = spark.read
    .option("delimiter", delimiter)
    .option("header", "true")
    .option("charset", "UTF-8")
    .option("inferSchema", "false")
    .option("nullValue", "null")
    .option("mergeSchema", "true")
    .csv(pathInput)

  printInfo(s"Load Data into Dataframe with count(): ${dfDataInput.count()}")









}
