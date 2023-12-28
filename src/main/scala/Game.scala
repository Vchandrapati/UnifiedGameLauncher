import java.io.File

case class Game(name: String, distributorName: String, localFilesLocation: String, assumedExeLocation: Option[File])
