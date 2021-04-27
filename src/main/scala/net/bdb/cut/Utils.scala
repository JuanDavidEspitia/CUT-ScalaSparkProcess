package net.bdb.cut

import org.apache.log4j.Logger


/**
 * Object create for functions of String, Characters, Logs Message and ...
 */
object Utils {

  val nameApp = "CUT-Process"
  // Patterns validation files
  val pattern1 = "(?:/(\\w+.){2}(P|S)(\\d+).(\\d+)_(\\d+)(.OK.txt))".r
  val pattern2 = "(?:/(\\w+.){2}(\\d+)_(\\d+)(.OK.txt))".r
  val pattern3 = "(?:/(\\w+.){3}[.](\\d+)(.OK.txt))".r
  val pattern4 = "(?:/((\\w+)[.]){3}(\\d+[_]\\d+)(.OK.txt)?)".r
  val pattern5 = "(?:/((\\w+)[.]){3}((R)+\\d+[_]\\d+)(.OK.txt))".r



  def printInfo(message: String): Unit =
  {
    Logger.getLogger(nameApp).info(message)
    //Añadir el metodo bitacora

  }







}
