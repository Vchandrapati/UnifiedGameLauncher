import java.io.{File, FileFilter}
import scala.collection.mutable.ArrayBuffer

class EpicGamesSearchStrategy extends SearchStrategy {
  override def search(file: File): ArrayBuffer[File] = {
    var searchFile = file
    val filter = new FileFilter {
      override def accept(pathname: File): Boolean = {
        pathname.getName.contains(".exe") && !pathname.getName.contains("Cheat") && !pathname.getName.contains("Uninstaller") && !pathname.getName.contains("gamelaunch")
      }
    }

    val dirFilter = new FileFilter {
      override def accept(pathname: File): Boolean = {
        pathname.isDirectory
      }
    }

    val subs = file.listFiles(dirFilter)
    val validDirs = ArrayBuffer[File]()

    if (subs != null) {
      for (subDir <- subs) {
        // Check if it's not the "Engine" directory and contains a "Binaries" subdirectory
        if (subDir.getName != "Engine" && new File(subDir, "Binaries").isDirectory || subDir.getName == "Binaries") {
          validDirs += subDir
        }
      }
    }

    // get dirs
    // If dirs contains a dir called binaries check if it contains Win64
    // If not check each folder not named Engine or dir named binaries
    // if not found then return None


    for (sub <- validDirs) {
      val subDir = sub.listFiles(dirFilter)
      for(dir <- subDir)
      if (new File(dir, "Win64").isDirectory) {
        searchFile = new File(dir, "Win64")
      }
    }


    val exeList = ArrayBuffer[File]()
    for (sub <- searchFile.listFiles(filter))
      exeList += sub

    exeList
  }
}
