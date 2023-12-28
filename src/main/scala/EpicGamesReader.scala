import java.io.File

object EpicGamesReader extends DirReader {
  private var _filePath = "C:\\Program Files\\Epic Games"
  private var dir = new File(_filePath)
  val distributorName = "Epic Games"
  val searchStrategy = new EpicGamesSearchStrategy

  def filePath: String = _filePath

  def filePath_=(newPath: String): Unit = {
    _filePath = newPath
    dir = new File(_filePath)
  }

  def getGamesList: Array[File] = {
    if (dir.exists() && dir.isDirectory) {
      getGames(dir)
    } else {
      println("Directory not found")
      new Array[File](0)
    }
  }
}
