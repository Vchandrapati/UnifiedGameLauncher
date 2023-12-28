import java.io.File
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object ExeValidator {
  def defineExe(dir: File): Option[File] = {
    val searchStrategy = new DefaultSearchStrategy
    val exeList = searchStrategy.search(dir)
    exeValidator(exeList, dir.getName)
  }

  def defineExe(dir: File, searchStrategy: SearchStrategy): Option[File] = {
    val exeList = searchStrategy.search(dir)
    exeValidator(exeList, dir.getName)
  }

  private def exeValidator(exeList: ArrayBuffer[File], name: String): Option[File] = {
    if(exeList.length == 1)
      exeList.head
    else if(exeList.isEmpty)
      return None

    val scores = exeList.map(f => (f, termMatcher(name, f.getName))).toMap
    // Find the file with the smallest edit distance
    val minDistanceFile = scores.minBy(_._2)
    if (minDistanceFile._2 <= 20) Some(minDistanceFile._1) else None
  }

  private def termMatcher(name: String, searchTerm: String): Double = {
    val n = name.length
    val m = searchTerm.length

    val row = Array.fill(m + 1)(0)
    for (j <- 0 to m) {
      row(j) = j
    }

    for (i <- 0 until n) {
      var prevDiag = i
      row(0) = i + 1

      for (j <- 0 until m) {
        val oldDiag = row(j + 1)
        val indicator = if (name(i) != searchTerm(j)) 1 else 0

        row(j + 1) = Math.min(Math.min(row(j) + 1, row(j + 1) + 1), prevDiag + indicator)
        prevDiag = oldDiag
      }
    }

    row(m)
  }
}
