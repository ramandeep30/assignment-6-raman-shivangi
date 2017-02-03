import java.io.File

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future


/**
  * Created by Ramandeep and Shivangi on 2/3/17.
  */

class FileOperations {
  def getListOfFiles(path: String): Future[List[File]] = {

    def getFiles(path: String, fileList: List[File]): List[File] = {
      val directory = new File(path)

      if (directory.exists() && directory.isDirectory) {

        val listOfFiles = fileList ::: directory.listFiles.filter(_.isFile).toList

        val listOfDirectories = directory.listFiles.filter(_.isDirectory).toList
        listOfFiles ::: listOfDirectories.flatMap(x => getFiles(x.getPath, List[File]()))
      }
      else {
        fileList
      }
    }
    Future {
      getFiles(path, List())
    }
  }
}
