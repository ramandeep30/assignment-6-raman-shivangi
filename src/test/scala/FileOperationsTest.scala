

import org.scalatest.FlatSpec
import scala.concurrent.Await
import scala.concurrent.duration._

class FileOperationsTest extends FlatSpec {

  val fileOperation = new FileOperations

  it should "return the number of files in knoldus folder" in {
    assert(Await.result(fileOperation.getListOfFiles("/home/shubham/Knoldus"), 1.seconds).length == 8)
  }

  it should "return the number of files in LLP folder" in {
    assert(Await.result(fileOperation.getListOfFiles("/home/shubham/LLP"), 1.seconds).length == 0)
  }
  it should "return the number of files in Raman folder" in {
    assert(Await.result(fileOperation.getListOfFiles("/home/shubham/Raman"), 1.seconds).length == 1)
  }
  it should "return the number of files in Shvangi folder" in {
    assert(Await.result(fileOperation.getListOfFiles("/home/shubham/Shivangi.txt"), 1.seconds).length == 0)
  }
}
