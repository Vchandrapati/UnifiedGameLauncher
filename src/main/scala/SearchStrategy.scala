import java.io.File
import scala.collection.mutable.ArrayBuffer

trait SearchStrategy {
  def search(file: File): ArrayBuffer[File]
}
