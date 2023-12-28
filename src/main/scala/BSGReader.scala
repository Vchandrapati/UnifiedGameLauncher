import java.io.{File, FileFilter}

object BSGReader extends DirReader {
  private var _filePath = "C:\\Battlestate Games"
  private var dir = new File(_filePath)
  val distributorName = "Battlestate Games"
  val searchStrategy = new DefaultSearchStrategy

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
