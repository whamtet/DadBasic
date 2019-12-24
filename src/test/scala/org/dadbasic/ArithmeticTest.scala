package org.dadbasic

import org.parboiled.errors.ParsingException

class ArithmeticTest extends DadGeneratorTest {

  it should "function when a variable is declared" in {
    val code: String =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING var\n" +
        "LOOK AT THIS JOKER 123\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("")
  }

  it should "function when an integer is printed" in {
    val code: String =
      "FRONT ROWS TAKE AIM!\n" +
        "WHAT A DAG 123\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("123\n")
  }

  it should "evaluate when a negative integer is printed" in {
    val code: String =
      "FRONT ROWS TAKE AIM!\n" +
        "WHAT A DAG -111\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("-111\n")
  }

  it should "evaluate when a 'boolean' is printed" in {
    val code: String =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING varfalse\n" +
        "LOOK AT THIS JOKER @NOT REALLY\n" +
        "WHAT A DAG varfalse\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("0\n")
  }

  it should "evaluate when a string is printed" in {
    val code: String =
      "FRONT ROWS TAKE AIM!\n" +
        "WHAT A DAG \"this should be printed\"\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("this should be printed\n")
  }

  it should "evaluate when a more exotic string is printed" in {
    val code: String =
      "FRONT ROWS TAKE AIM!\n" +
        "WHAT A DAG \"!!! ??? äöäöäöä@#0123=+-,.\"\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("!!! ??? äöäöäöä@#0123=+-,.\n")
  }

  it should "evaluate when an integer is declared and printed" in {
    val code: String =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING A\n" +
        "LOOK AT THIS JOKER 999\n" +
        "HELLO CHRIS MOLLOY SPEAKING B\n" +
        "LOOK AT THIS JOKER 555\n" +
        "WHAT A DAG A\n" +
        "WHAT A DAG B\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("999\n555\n")
  }
  it should "evaluate when a negative integer is declared and printed" in {
    val code: String =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING a\n" +
        "LOOK AT THIS JOKER -999\n" +
        "HELLO CHRIS MOLLOY SPEAKING b\n" +
        "LOOK AT THIS JOKER -555\n" +
        "WHAT A DAG a\n" +
        "WHAT A DAG b\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("-999\n-555\n")
  }

  it should "evaluate when assigning a variable" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING var\n" +
        "LOOK AT THIS JOKER 22\n" +
        "WHAT A HARD CASE var\n" +
        "YOU CRACK ME UP 123\n" +
        "I'VE EATEN TOO MUCH\n" +
        "WHAT A DAG var\n" +
        "I'LL GO WASH THE DISHES\n"

    getOutput(code) should equal("123\n")
  }


  it should "evaluate when assigning multiple variables " in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING var\n" +
        "LOOK AT THIS JOKER 22\n" +
        "HELLO CHRIS MOLLOY SPEAKING var2\n" +
        "LOOK AT THIS JOKER 27\n" +
        "WHAT A HARD CASE var\n" +
        "YOU CRACK ME UP 123\n" +
        "I'VE EATEN TOO MUCH\n" +
        "WHAT A HARD CASE var2\n" +
        "YOU CRACK ME UP 707\n" +
        "I'VE EATEN TOO MUCH\n" +
        "WHAT A HARD CASE var\n" +
        "YOU CRACK ME UP var2\n" +
        "MUTOR var\n" +
        "I'VE EATEN TOO MUCH\n" +
        "WHAT A DAG var\n" +
        "I'LL GO WASH THE DISHES\n"

    getOutput(code) should equal("830\n")
  }

  it should "evaluate when an integer is incremented and printed" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING VAR\n" +
        "LOOK AT THIS JOKER 22\n" +
        "WHAT A HARD CASE VAR\n" +
        "YOU CRACK ME UP VAR\n" +
        "MUTOR 44\n" +
        "I'VE EATEN TOO MUCH\n" +
        "WHAT A DAG VAR\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("66\n")
  }

  it should "evaluate when an integer is decremented and printed" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING VAR\n" +
        "LOOK AT THIS JOKER 22\n" +
        "WHAT A HARD CASE VAR\n" +
        "YOU CRACK ME UP VAR\n" +
        "LITTLE RATBAG 44\n" +
        "I'VE EATEN TOO MUCH\n" +
        "WHAT A DAG VAR\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("-22\n")
  }

  it should "evaluate when an integer is decremented with a negative value" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING VAR\n" +
        "LOOK AT THIS JOKER 22\n" +
        "WHAT A HARD CASE VAR\n" +
        "YOU CRACK ME UP VAR\n" +
        "LITTLE RATBAG -44\n" +
        "I'VE EATEN TOO MUCH\n" +
        "WHAT A DAG VAR\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("66\n")
  }


  it should "evaluate when an integer is incremented with a negative value" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING VAR\n" +
        "LOOK AT THIS JOKER 22\n" +
        "WHAT A HARD CASE VAR\n" +
        "YOU CRACK ME UP VAR\n" +
        "MUTOR -44\n" +
        "I'VE EATEN TOO MUCH\n" +
        "WHAT A DAG VAR\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("-22\n")
  }

  it should "evaluate when multiplying variables" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING VAR\n" +
        "LOOK AT THIS JOKER 22\n" +
        "WHAT A HARD CASE VAR\n" +
        "YOU CRACK ME UP VAR\n" +
        "PARENTAL UNITS 13\n" +
        "I'VE EATEN TOO MUCH\n" +
        "WHAT A DAG VAR\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("286\n")
  }

  it should "evaluate when multiplying variables with different signs" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING VAR\n" +
        "LOOK AT THIS JOKER 22\n" +
        "WHAT A HARD CASE VAR\n" +
        "YOU CRACK ME UP VAR\n" +
        "PARENTAL UNITS -13\n" +
        "I'VE EATEN TOO MUCH\n" +
        "WHAT A DAG VAR\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("-286\n")
  }

  it should "evaluate when multiplying variables with zero" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING VAR\n" +
        "LOOK AT THIS JOKER 22\n" +
        "WHAT A HARD CASE VAR\n" +
        "YOU CRACK ME UP VAR\n" +
        "PARENTAL UNITS 0\n" +
        "I'VE EATEN TOO MUCH\n" +
        "WHAT A DAG VAR\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("0\n")
  }

  it should "evaluate when multiplying assigned variables" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING VAR\n" +
        "LOOK AT THIS JOKER 7\n" +
        "HELLO CHRIS MOLLOY SPEAKING VAR2\n" +
        "LOOK AT THIS JOKER 4\n" +
        "WHAT A HARD CASE VAR\n" +
        "YOU CRACK ME UP VAR\n" +
        "PARENTAL UNITS VAR2\n" +
        "I'VE EATEN TOO MUCH\n" +
        "WHAT A DAG VAR\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("28\n")
  }

  it should "evaluate when dividing variables" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING VAR\n" +
        "LOOK AT THIS JOKER 100\n" +
        "WHAT A HARD CASE VAR\n" +
        "YOU CRACK ME UP VAR\n" +
        "GET OUT OF HERE 4\n" +
        "I'VE EATEN TOO MUCH\n" +
        "WHAT A DAG VAR\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("25\n")
  }

  it should "evaluate when dividing variables with different signs" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING VAR\n" +
        "LOOK AT THIS JOKER 99\n" +
        "WHAT A HARD CASE VAR\n" +
        "YOU CRACK ME UP VAR\n" +
        "GET OUT OF HERE -33\n" +
        "I'VE EATEN TOO MUCH\n" +
        "WHAT A DAG VAR\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("-3\n")
  }

  it should "evaluate when dividing variables with one" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING VAR\n" +
        "LOOK AT THIS JOKER 22\n" +
        "WHAT A HARD CASE VAR\n" +
        "YOU CRACK ME UP VAR\n" +
        "GET OUT OF HERE 1\n" +
        "I'VE EATEN TOO MUCH\n" +
        "WHAT A DAG VAR\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("22\n")
  }

  it should "evaluate when dividing assigned variables" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING VAR\n" +
        "LOOK AT THIS JOKER 9\n" +
        "HELLO CHRIS MOLLOY SPEAKING VAR2\n" +
        "LOOK AT THIS JOKER 4\n" +
        "WHAT A HARD CASE VAR\n" +
        "YOU CRACK ME UP VAR\n" +
        "GET OUT OF HERE VAR2\n" +
        "I'VE EATEN TOO MUCH\n" +
        "WHAT A DAG VAR\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("2\n")
  }

  it should "evaluate when calculating modulo variables vol1" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING var\n" +
        "LOOK AT THIS JOKER 1\n" +
        "WHAT A HARD CASE var\n" +
        "YOU CRACK ME UP var\n" +
        "THERE'S A SHORTCUT AROUND HERE SOMEWHERE 2\n" +
        "I'VE EATEN TOO MUCH\n" +
        "WHAT A DAG var\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("1\n")
  }

  it should "evaluate when calculating modulo variables vol2" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING var\n" +
        "LOOK AT THIS JOKER 2\n" +
        "WHAT A HARD CASE var\n" +
        "YOU CRACK ME UP var\n" +
        "THERE'S A SHORTCUT AROUND HERE SOMEWHERE 2\n" +
        "I'VE EATEN TOO MUCH\n" +
        "WHAT A DAG var\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("0\n")
  }

  it should "evaluate using different arithmetic operations" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING VAR\n" +
        "LOOK AT THIS JOKER 22\n" +
        "WHAT A HARD CASE VAR\n" +
        "YOU CRACK ME UP 11\n" +
        "LITTLE RATBAG 43\n" +
        "MUTOR 54\n" +
        "MUTOR 44\n" +
        "I'VE EATEN TOO MUCH\n" +
        "WHAT A DAG VAR\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("66\n")
  }

  it should "evaluate using different arithmetic operations vol2" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING VAR\n" +
        "LOOK AT THIS JOKER 22\n" +
        "WHAT A HARD CASE VAR\n" +
        "YOU CRACK ME UP 11\n" +
        "LITTLE RATBAG 55\n" +
        "MUTOR 11\n" +
        "MUTOR 22\n" +
        "MUTOR 23\n" +
        "LITTLE RATBAG 0\n" +
        "MUTOR 0\n" +
        "MUTOR 1\n" +
        "I'VE EATEN TOO MUCH\n" +
        "WHAT A DAG VAR\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("13\n")
  }

  it should "evaluate using different arithmetic operations vol3" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING VAR\n" +
        "LOOK AT THIS JOKER 22\n" +
        "WHAT A HARD CASE VAR\n" +
        "YOU CRACK ME UP 11\n" +
        "LITTLE RATBAG 22\n" +
        "GET OUT OF HERE -11\n" +
        "PARENTAL UNITS 23\n" +
        "MUTOR 23\n" +
        "LITTLE RATBAG 22\n" +
        "GET OUT OF HERE 2\n" +
        "I'VE EATEN TOO MUCH\n" +
        "WHAT A DAG VAR\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("12\n")
  }

  it should "detect duplicate variable declarations" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING VAR\n" +
        "LOOK AT THIS JOKER 22\n" +
        "HELLO CHRIS MOLLOY SPEAKING VAR\n" +
        "LOOK AT THIS JOKER 22\n" +
        "I'LL GO WASH THE DISHES\n"
    intercept[ParsingException] {
      getOutput(code)
    }
  }

  it should "detect faulty variable names" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING 1VAR\n" +
        "LOOK AT THIS JOKER 123\n" +
        "I'LL GO WASH THE DISHES\n"
    intercept[ParsingException] {
      getOutput(code)
    }
  }
}
