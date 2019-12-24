package org.dadbasic

import org.parboiled.errors.ParsingException

class MethodTest extends DadGeneratorTest {

  it should "evalute method other than main" in {
    val code =
      "CONSTRUCTION STARTED mymethod\n" +
        "I'M STUFFED\n" +
        "FRONT ROWS TAKE AIM!\n" +
        "WHAT A DAG \"Hello\"\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("Hello\n")
  }

  it should "evalute method other than main2" in {
    val code =
      "CONSTRUCTION STARTED mymethod\n" +
        "I'M STUFFED\n" +
        "FRONT ROWS TAKE AIM!\n" +
        "WHAT A DAG \"Hello\"\n" +
        "I'LL GO WASH THE DISHES"
    getOutput(code) should equal("Hello\n")
  }

  it should "evalute method other than main3" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "WHAT A DAG \"Hello\"\n" +
        "I'LL GO WASH THE DISHES\n" +
        "CONSTRUCTION STARTED mymethod\n" +
        "I'M STUFFED\n"
    getOutput(code) should equal("Hello\n")
  }
  it should "evalute method other than main4" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "WHAT A DAG \"Hello\"\n" +
        "I'LL GO WASH THE DISHES\n" +
        "CONSTRUCTION STARTED mymethod\n" +
        "I'M STUFFED"
    getOutput(code) should equal("Hello\n")
  }

  it should "evalute a plain method call" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "PASS ME THE VEGETABLE MATTER printHello\n" +
        "I'LL GO WASH THE DISHES\n" +
        "CONSTRUCTION STARTED printHello\n" +
        "WHAT A DAG \"Hello\"\n" +
        "I'M STUFFED"
    getOutput(code) should equal("Hello\n")
  }

  it should "evalute a method call that takes an argument" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING argument\n" +
        "LOOK AT THIS JOKER 123\n" +
        "PASS ME THE VEGETABLE MATTER printInteger argument\n" +
        "I'LL GO WASH THE DISHES\n" +
        "CONSTRUCTION STARTED printInteger\n" +
        "I DIDN'T CATCH THAT value\n" +
        "WHAT A DAG value\n" +
        "I'M STUFFED"
    getOutput(code) should equal("123\n")
  }

  it should "evalute multiple method calls" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "PASS ME THE VEGETABLE MATTER printHello\n" +
        "PASS ME THE VEGETABLE MATTER printCheers\n" +
        "I'LL GO WASH THE DISHES\n" +
        "CONSTRUCTION STARTED printHello\n" +
        "WHAT A DAG \"Hello\"\n" +
        "I'M STUFFED\n" +
        "CONSTRUCTION STARTED printCheers\n" +
        "WHAT A DAG \"Cheers\"\n" +
        "I'M STUFFED"
    getOutput(code) should equal("Hello\nCheers\n")
  }

  it should "evalute method calls inside method calls" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "PASS ME THE VEGETABLE MATTER printHello\n" +
        "I'LL GO WASH THE DISHES\n" +
        "CONSTRUCTION STARTED printHello\n" +
        "WHAT A DAG \"Hello\"\n" +
        "PASS ME THE VEGETABLE MATTER printCheers\n" +
        "PASS ME THE VEGETABLE MATTER printHejsan\n" +
        "I'M STUFFED\n" +
        "CONSTRUCTION STARTED printCheers\n" +
        "WHAT A DAG \"Cheers\"\n" +
        "I'M STUFFED\n" +
        "CONSTRUCTION STARTED printHejsan\n" +
        "WHAT A DAG \"Hejsan\"\n" +
        "I'M STUFFED"
    getOutput(code) should equal("Hello\nCheers\nHejsan\n")
  }

  it should "evalute a return statement in void calls" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "PASS ME THE VEGETABLE MATTER method\n" +
        "I'LL GO WASH THE DISHES\n" +
        "CONSTRUCTION STARTED method\n" +
        "HERE YOU GO\n" +
        "I'M STUFFED\n"

    getOutput(code) should equal("")
  }

  it should "evalute multiple return statemenents in void calls" in {
    val code = "FRONT ROWS TAKE AIM!\n" +
      "PASS ME THE VEGETABLE MATTER printboolean @YES\n" +
      "PASS ME THE VEGETABLE MATTER printboolean @NOT REALLY\n" +
      "I'LL GO WASH THE DISHES\n" +
      "CONSTRUCTION STARTED printboolean\n" +
      "I DIDN'T CATCH THAT value\n" +
      "IMAGINE IF value\n" +
      "WHAT A DAG \"true\"\n" +
      "HERE YOU GO\n" +
      "OTHERWISE THERE WILL BE A CONSEQUENCE\n" +
      "WHAT A DAG \"false\"\n" +
      "HERE YOU GO\n" +
      "I'M JUST GOING TO HAVE A FIVE MINUTE NAP\n" +
      "I'M STUFFED\n"

    getOutput(code) should equal("true\nfalse\n")
  }

  it should "evalute multiple return statemenents in void calls permutation2" in {
    val code = "FRONT ROWS TAKE AIM!\n" +
      "PASS ME THE VEGETABLE MATTER printboolean @YES\n" +
      "PASS ME THE VEGETABLE MATTER printboolean @NOT REALLY\n" +
      "I'LL GO WASH THE DISHES\n" +
      "CONSTRUCTION STARTED printboolean\n" +
      "I DIDN'T CATCH THAT value\n" +
      "IMAGINE IF value\n" +
      "WHAT A DAG \"true\"\n" +
      "OTHERWISE THERE WILL BE A CONSEQUENCE\n" +
      "WHAT A DAG \"false\"\n" +
      "I'M JUST GOING TO HAVE A FIVE MINUTE NAP\n" +
      "I'M STUFFED\n"
    getOutput(code) should equal("true\nfalse\n")
  }

  it should "evalute multiple return statemenents in void calls permutation3" in {
    val code = "FRONT ROWS TAKE AIM!\n" +
      "PASS ME THE VEGETABLE MATTER printboolean @YES\n" +
      "PASS ME THE VEGETABLE MATTER printboolean @NOT REALLY\n" +
      "I'LL GO WASH THE DISHES\n" +
      "CONSTRUCTION STARTED printboolean\n" +
      "I DIDN'T CATCH THAT value\n" +
      "IMAGINE IF value\n" +
      "WHAT A DAG \"true\"\n" +
      "OTHERWISE THERE WILL BE A CONSEQUENCE\n" +
      "WHAT A DAG \"false\"\n" +
      "I'M JUST GOING TO HAVE A FIVE MINUTE NAP\n" +
      "HERE YOU GO\n" +
      "HERE YOU GO\n" +
      "I'M STUFFED\n"
    getOutput(code) should equal("true\nfalse\n")
  }


  it should "evalute multiple return statemenents in void calls with unreachable code" in {
    val code = "FRONT ROWS TAKE AIM!\n" +
      "PASS ME THE VEGETABLE MATTER method\n" +
      "I'LL GO WASH THE DISHES\n" +
      "CONSTRUCTION STARTED method\n" +
      "WHAT A DAG \"reached codeblock\"\n" +
      "HERE YOU GO\n" +
      "WHAT A DAG \"unreached codeblock\"\n" +
      "I'M STUFFED\n"

    getOutput(code) should equal("reached codeblock\n")
  }

  it should "evalute void method calls returning from branched statements" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "PASS ME THE VEGETABLE MATTER reverse @YES\n" +
        "I'LL GO WASH THE DISHES\n" +
        "CONSTRUCTION STARTED reverse\n" +
        "I DIDN'T CATCH THAT value\n" +
        "IMAGINE IF value\n" +
        "WHAT A DAG \"evaluated\"\n" +
        "HERE YOU GO\n" +
        "I'M JUST GOING TO HAVE A FIVE MINUTE NAP\n" +
        "WHAT A DAG \"not evaluated\"\n"+
        "HERE YOU GO\n" +
        "I'M STUFFED\n"
    getOutput(code) should equal("evaluated\n")
  }

  it should "evalute non void method calls returning from branched statements" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "PASS ME THE VEGETABLE MATTER reverse @YES\n" +
        "I'LL GO WASH THE DISHES\n" +
        "CONSTRUCTION STARTED reverse\n" +
        "I DIDN'T CATCH THAT value\n" +
        "RIGHTO\n" +
        "IMAGINE IF value\n" +
        "WHAT A DAG \"evaluated\"\n" +
        "HERE YOU GO 0\n" +
        "WHAT A DAG \"evaluated\"\n" +
        "I'M JUST GOING TO HAVE A FIVE MINUTE NAP\n" +
        "WHAT A DAG \"not evaluated\"\n"+
        "HERE YOU GO 0\n" +
        "I'M STUFFED\n"
    getOutput(code) should equal("evaluated\n")
  }

  it should "evalute assignments to variables from method calls " in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING result\n" +
        "LOOK AT THIS JOKER 0\n" +
        "KIDS LOOK OUT THE WINDOW result\n" +
        "PASS ME THE VEGETABLE MATTER square 7\n" +
        "WHAT A DAG result\n" +
        "I'LL GO WASH THE DISHES\n" +
        "CONSTRUCTION STARTED square\n" +
        "I DIDN'T CATCH THAT value\n" +
        "RIGHTO\n" +
        "WHAT A HARD CASE value\n" +
        "YOU CRACK ME UP value\n" +
        "PARENTAL UNITS value\n" +
        "I'VE EATEN TOO MUCH\n" +
        "HERE YOU GO value\n" +
        "I'M STUFFED\n"
    getOutput(code) should equal("49\n")
  }

  it should "detect unclosed main method" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "CONSTRUCTION STARTED printHello\n" +
        "WHAT A DAG \"Hello\"\n"
    intercept[ParsingException] {
      getOutput(code)
    }
  }
  it should "detect unclosed methods" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "I'LL GO WASH THE DISHES\n" +
        "CONSTRUCTION STARTED printHello\n" +
        "WHAT A DAG \"Hello\"\n"
    intercept[ParsingException] {
      getOutput(code)
    }
  }

  it should "detect calls to methods that are not declared" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "PASS ME THE VEGETABLE MATTER noSuchMethod\n" +
        "I'LL GO WASH THE DISHES\n"
    intercept[ParsingException] {
      getOutput(code)
    }
  }

  it should "detect if void method tries to return a parameter" in {
    val code = "FRONT ROWS TAKE AIM!\n" +
      "PASS ME THE VEGETABLE MATTER method\n" +
      "I'LL GO WASH THE DISHES\n" +
      "CONSTRUCTION STARTED method\n" +
      "HERE YOU GO 0\n" +
      "I'M STUFFED\n"

    intercept[ParsingException] {
      getOutput(code)
    }
  }

  it should "detect if a non-void method tries to return a without a parameter" in {
    val code = "FRONT ROWS TAKE AIM!\n" +
      "PASS ME THE VEGETABLE MATTER method 0\n" +
      "I'LL GO WASH THE DISHES\n" +
      "CONSTRUCTION STARTED method\n" +
      "I DIDN'T CATCH THAT value\n" +
      "RIGHTO\n" +
      "HERE YOU GO\n" +
      "I'M STUFFED\n"

    intercept[ParsingException] {
      getOutput(code)
    }
  }
}
