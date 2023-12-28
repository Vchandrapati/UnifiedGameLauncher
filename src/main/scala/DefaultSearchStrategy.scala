import java.io.{File, FileFilter}
import scala.collection.mutable.ArrayBuffer

class DefaultSearchStrategy extends SearchStrategy {
  override def search(file: File): ArrayBuffer[File] = {
    val filter = new FileFilter {
      override def accept(pathname: File): Boolean = {
        pathname.getName.contains(".exe") && !pathname.getName.contains("Cheat") && !pathname.getName.contains("Uninstall")
      }
    }

    val exeList = ArrayBuffer[File]()
    for (sub <- file.listFiles(filter))
      exeList += sub

    exeList
  }
}
