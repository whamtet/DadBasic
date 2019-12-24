package org.dadbasic

import org.dadbasic.ast.RootNode


class DadGenerator extends ClassLoader {

  def generate(dadCode: String, filename: String): (Array[Byte], RootNode) = {
    val parser = new DadParser
    val rootNode = parser.parse(dadCode)
    (rootNode.generateByteCode(filename), rootNode)
  }
}
