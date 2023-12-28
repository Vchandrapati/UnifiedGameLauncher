import java.io.{File, FileFilter}
import scala.collection.mutable.ArrayBuffer

class XboxSearchStrategy extends SearchStrategy{
  override def search(file: File): ArrayBuffer[File] = {
    var searchFile = file
    val filter = new FileFilter {
      override def accept(pathname: File): Boolean = {
        pathname.getName.contains(".exe") && !pathname.getName.contains("Cheat") && !pathname.getName.contains("Uninstaller") && !pathname.getName.contains("gamelaunch")
      }
    }

    val contentDir = new File(file, "Content")
    if (contentDir.exists() && contentDir.isDirectory) {
      searchFile = contentDir
    }

    val exeList = ArrayBuffer[File]()
    for (sub <- searchFile.listFiles(filter))
      exeList += sub

    exeList
  }
}
