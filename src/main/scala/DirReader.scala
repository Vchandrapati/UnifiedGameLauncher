import java.io.{File, FileFilter}
import scala.collection.mutable.ArrayBuffer

trait DirReader {
  def getGamesList: Array[File]
  def filePath: String
  def filePath_=(newPath: String): Unit
  def distributorName: String
  def searchStrategy: SearchStrategy

  def validateExe(file: File): Option[File] = {
    ExeValidator.defineExe(file, searchStrategy)
  }

  def getGames(dir: File): Array[File] = {
    var restrictedWords = ArrayBuffer[String] ("Steam", "Sav", "Uninstall", "Epic", "EA", "Launch")
    val filter = new FileFilter {
      override def accept(pathname: File): Boolean = {
        pathname.isDirectory && !restrictedWords.exists(word => pathname.getName.contains(word))
      }
    }

    dir.listFiles(filter)
  }
}
