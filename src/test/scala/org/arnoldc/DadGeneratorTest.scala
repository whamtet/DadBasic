package org.dadbasic

import org.scalatest._

abstract  class DadGeneratorTest extends FlatSpec with Matchers {

  val dadGenerator = new DadGenerator
  val byteCodeExecutor = new ByteCodeExecutor
  var className = "Hello"

  def getOutput(dadCode: String): String = {
    val (bytecode, root) = dadGenerator.generate(dadCode, className)
    byteCodeExecutor.getOutput(bytecode, className)
  }

}