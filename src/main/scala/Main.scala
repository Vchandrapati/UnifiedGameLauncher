import scala.collection.mutable.ArrayBuffer

object Main {
  def main(args: Array[String]): Unit = {
    val games = ArrayBuffer[Game]()
//    processGames(games, SteamReader)
//    processGames(games, BSGReader)
//    processGames(games, XboxReader)
    processGames(games, EpicGamesReader)

    games.foreach(x => println(x))
  }

  private def processGames(gamesList: ArrayBuffer[Game], reader: DirReader): Unit = {
    for (game <- reader.getGamesList) {
      reader.validateExe(game) match {
        case Some(exePath) =>
          val exeName = exePath.getName.split("\\.").dropRight(1).mkString(".")
          val addCaps = exeName.split("(?<!^)(?=[A-Z])").mkString(" ")
          val gameName = if (addCaps.length > game.getName.length) addCaps else game.getName
          gamesList += Game(gameName, reader.distributorName, game.getPath, Some(exePath))

        case None =>
          gamesList += Game(game.getName, reader.distributorName, game.getPath, None)
      }
    }
  }
}
