package org.dadbasic
import org.scalatest.{Matchers, FlatSpec}
import java.io._

class InputTest extends DadGeneratorTest {

  it should "read integer from input" in {
    writeToFile(path, "123")
    val code =
      "FRONT ROWS TAKE AIM!\n" +
      "WHAT A DAG \"Input a number:\"\n" +
      "HELLO CHRIS MOLLOY SPEAKING result\n" +
      "LOOK AT THIS JOKER 0\n" +
      "KIDS LOOK OUT THE WINDOW result\n" +
      "PASS ME THE VEGETABLE MATTER\n" +
      "HOW ABOUT A GAME OF RUMMIKUB\n" +
      "WHAT A DAG result\n" +
      "WHAT A DAG \"Bye\"\n" +
      "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("Input a number:\n123\nBye\n")
  }

  val path = "test.in"

  override val byteCodeExecutor = new ByteCodeExecutor{

    override def getOutput(bytecode: Array[Byte], className: String): String = {

      val originalIn = System.in
      val outputRedirectionStream = new ByteArrayOutputStream()
      val fileInput = new BufferedInputStream(new FileInputStream(path))
      System.setOut(new PrintStream(outputRedirectionStream))
      System.setIn(fileInput)

      try {
        invokeMainMethod(bytecode, className)
      } finally {
        System.setOut(originalOutputStream)
        System.setIn(originalIn)
      }
      outputRedirectionStream.toString
    }
  }

  def writeToFile(file:String, data:String) = {
    val out = new FileOutputStream(file)
    out.write(data.getBytes)
    out.close()
  }


}