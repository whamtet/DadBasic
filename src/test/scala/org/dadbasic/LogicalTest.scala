package org.dadbasic

import org.parboiled.errors.ParsingException

class LogicalTest extends DadGeneratorTest {
  it should "False Or True Evaluate True" in {
    val code = "FRONT ROWS TAKE AIM!\n" +
      "HELLO CHRIS MOLLOY SPEAKING var\n" +
      "LOOK AT THIS JOKER 0\n" +
      "WHAT A HARD CASE var\n" +
      "YOU CRACK ME UP 0\n" +
      "NASE BLASEN 1\n" +
      "I'VE EATEN TOO MUCH\n" +
      "WHAT A DAG var\n" +
      "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("1\n")
  }


  it should "True Or False Evaluate True" in {
    val code = "FRONT ROWS TAKE AIM!\n" +
      "HELLO CHRIS MOLLOY SPEAKING var\n" +
      "LOOK AT THIS JOKER @NOT REALLY\n" +
      "WHAT A HARD CASE var\n" +
      "YOU CRACK ME UP @YES\n" +
      "NASE BLASEN @NOT REALLY\n" +
      "I'VE EATEN TOO MUCH\n" +
      "WHAT A DAG var\n" +
      "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("1\n")
  }

  it should "True Or True Evaluate True" in {
    val code = "FRONT ROWS TAKE AIM!\n" +
      "HELLO CHRIS MOLLOY SPEAKING var\n" +
      "LOOK AT THIS JOKER @NOT REALLY\n" +
      "WHAT A HARD CASE var\n" +
      "YOU CRACK ME UP @YES\n" +
      "NASE BLASEN @YES\n" +
      "I'VE EATEN TOO MUCH\n" +
      "WHAT A DAG var\n" +
      "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("1\n")
  }

  it should "False Or False Evaluate False" in {
    val code = "FRONT ROWS TAKE AIM!\n" +
      "HELLO CHRIS MOLLOY SPEAKING var\n" +
      "LOOK AT THIS JOKER @NOT REALLY\n" +
      "WHAT A HARD CASE var\n" +
      "YOU CRACK ME UP @NOT REALLY\n" +
      "NASE BLASEN @NOT REALLY\n" +
      "I'VE EATEN TOO MUCH\n" +
      "WHAT A DAG var\n" +
      "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("0\n")
  }

  it should "False And True Evaluate False" in {
    val code = "FRONT ROWS TAKE AIM!\n" +
      "HELLO CHRIS MOLLOY SPEAKING var\n" +
      "LOOK AT THIS JOKER @NOT REALLY\n" +
      "WHAT A HARD CASE var\n" +
      "YOU CRACK ME UP @NOT REALLY\n" +
      "AND @YES\n" +
      "I'VE EATEN TOO MUCH\n" +
      "WHAT A DAG var\n" +
      "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("0\n")
  }

  it should "True And False Evaluate False" in {
    val code = "FRONT ROWS TAKE AIM!\n" +
      "HELLO CHRIS MOLLOY SPEAKING var\n" +
      "LOOK AT THIS JOKER @NOT REALLY\n" +
      "WHAT A HARD CASE var\n" +
      "YOU CRACK ME UP @YES\n" +
      "AND @NOT REALLY\n" +
      "I'VE EATEN TOO MUCH\n" +
      "WHAT A DAG var\n" +
      "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("0\n")
  }

  it should "True And True Evaluate True" in {
    val code = "FRONT ROWS TAKE AIM!\n" +
      "HELLO CHRIS MOLLOY SPEAKING var\n" +
      "LOOK AT THIS JOKER @NOT REALLY\n" +
      "WHAT A HARD CASE var\n" +
      "YOU CRACK ME UP @YES\n" +
      "AND @YES\n" +
      "I'VE EATEN TOO MUCH\n" +
      "WHAT A DAG var\n" +
      "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("1\n")
  }

  it should "True and True and False evaluates False" in {
    val code =
    "FRONT ROWS TAKE AIM!\n" +
    "HELLO CHRIS MOLLOY SPEAKING var\n" +
    "LOOK AT THIS JOKER @NOT REALLY\n" +
    "WHAT A HARD CASE var\n" +
    "YOU CRACK ME UP 1\n" +
    "AND 1\n" +
    "AND 0\n" +
    "I'VE EATEN TOO MUCH\n" +
    "WHAT A DAG var\n" +
    "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("0\n")
  }

  it should "True and True and True evaluates True" in {
    val code =
    "FRONT ROWS TAKE AIM!\n" +
    "HELLO CHRIS MOLLOY SPEAKING var\n" +
    "LOOK AT THIS JOKER @NOT REALLY\n" +
    "WHAT A HARD CASE var\n" +
    "YOU CRACK ME UP 1\n" +
    "AND 1\n" +
    "AND 1\n" +
    "I'VE EATEN TOO MUCH\n" +
    "WHAT A DAG var\n" +
    "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("1\n")
  }

    it should "True and True and True and True and False evaluates False" in {
    val code =
    "FRONT ROWS TAKE AIM!\n" +
    "HELLO CHRIS MOLLOY SPEAKING var\n" +
    "LOOK AT THIS JOKER @NOT REALLY\n" +
    "WHAT A HARD CASE var\n" +
    "YOU CRACK ME UP @YES\n" +
    "AND @YES\n" +
    "AND @YES\n" +
    "AND @YES\n" +
    "AND @NOT REALLY\n" +
    "I'VE EATEN TOO MUCH\n" +
    "WHAT A DAG var\n" +
    "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("0\n")
  }

    it should "False or False or False evaluates False" in {
    val code =
    "FRONT ROWS TAKE AIM!\n" +
    "HELLO CHRIS MOLLOY SPEAKING var\n" +
    "LOOK AT THIS JOKER @NOT REALLY\n" +
    "WHAT A HARD CASE var\n" +
    "YOU CRACK ME UP @NOT REALLY\n" +
    "NASE BLASEN @NOT REALLY\n" +
    "NASE BLASEN @NOT REALLY\n" +
    "I'VE EATEN TOO MUCH\n" +
    "WHAT A DAG var\n" +
    "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("0\n")
  }

    it should "False or True and False evaluates False" in {
    val code =
    "FRONT ROWS TAKE AIM!\n" +
    "HELLO CHRIS MOLLOY SPEAKING var\n" +
    "LOOK AT THIS JOKER @NOT REALLY\n" +
    "WHAT A HARD CASE var\n" +
    "YOU CRACK ME UP @NOT REALLY\n" +
    "NASE BLASEN @YES\n" +
    "AND @NOT REALLY\n" +
    "I'VE EATEN TOO MUCH\n" +
    "WHAT A DAG var\n" +
    "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("0\n")
  }

  it should "False And False Evaluate False" in {
    val code = "FRONT ROWS TAKE AIM!\n" +
      "HELLO CHRIS MOLLOY SPEAKING var\n" +
      "LOOK AT THIS JOKER @NOT REALLY\n" +
      "WHAT A HARD CASE var\n" +
      "YOU CRACK ME UP @NOT REALLY\n" +
      "AND @NOT REALLY\n" +
      "I'VE EATEN TOO MUCH\n" +
      "WHAT A DAG var\n" +
      "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("0\n")
  }

  it should "False Equals False evaluates True" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING varfalse\n" +
        "LOOK AT THIS JOKER @NOT REALLY\n" +
        "HELLO CHRIS MOLLOY SPEAKING varfalse2\n" +
        "LOOK AT THIS JOKER @NOT REALLY\n" +
        "WHAT A HARD CASE varfalse\n" +
        "YOU CRACK ME UP @NOT REALLY\n" +
        "NOW WHAT DOES THIS REMIND YOU OF varfalse2\n" +
        "I'VE EATEN TOO MUCH\n" +
        "WHAT A DAG varfalse\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("1\n")
  }
  it should "True Equals False evaluates False" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING varfalse\n" +
        "LOOK AT THIS JOKER @NOT REALLY\n" +
        "HELLO CHRIS MOLLOY SPEAKING result\n" +
        "LOOK AT THIS JOKER @NOT REALLY\n" +
        "WHAT A HARD CASE result\n" +
        "YOU CRACK ME UP @YES\n" +
        "NOW WHAT DOES THIS REMIND YOU OF varfalse\n" +
        "I'VE EATEN TOO MUCH\n" +
        "WHAT A DAG result\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("0\n")
  }

    it should "True Equals True Equals True evaluates True" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING result\n" +
        "LOOK AT THIS JOKER @NOT REALLY\n" +
        "WHAT A HARD CASE result\n" +
        "YOU CRACK ME UP @YES\n" +
        "NOW WHAT DOES THIS REMIND YOU OF @YES\n" +
        "NOW WHAT DOES THIS REMIND YOU OF @YES\n" +
        "I'VE EATEN TOO MUCH\n" +
        "WHAT A DAG result\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("1\n")
  }

   it should "(13 Equals 13) equals True evaluates True" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING result\n" +
        "LOOK AT THIS JOKER @NOT REALLY\n" +
        "WHAT A HARD CASE result\n" +
        "YOU CRACK ME UP 13\n" +
        "NOW WHAT DOES THIS REMIND YOU OF 13\n" +
        "NOW WHAT DOES THIS REMIND YOU OF @YES\n" +
        "I'VE EATEN TOO MUCH\n" +
        "WHAT A DAG result\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("1\n")
  }

   it should "(13 Equals 14) equals False evaluates True" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING result\n" +
        "LOOK AT THIS JOKER @NOT REALLY\n" +
        "WHAT A HARD CASE result\n" +
        "YOU CRACK ME UP 13\n" +
        "NOW WHAT DOES THIS REMIND YOU OF 14\n" +
        "NOW WHAT DOES THIS REMIND YOU OF @NOT REALLY\n" +
        "I'VE EATEN TOO MUCH\n" +
        "WHAT A DAG result\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("1\n")
  }

   it should "(1 Equals 2) equals 3 evaluates False" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING result\n" +
        "LOOK AT THIS JOKER @NOT REALLY\n" +
        "WHAT A HARD CASE result\n" +
        "YOU CRACK ME UP 1\n" +
        "NOW WHAT DOES THIS REMIND YOU OF 2\n" +
        "NOW WHAT DOES THIS REMIND YOU OF 3\n" +
        "I'VE EATEN TOO MUCH\n" +
        "WHAT A DAG result\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("0\n")
  }

  it should "13 Equals 13 Equals 14 evaluates False" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING result\n" +
        "LOOK AT THIS JOKER @NOT REALLY\n" +
        "WHAT A HARD CASE result\n" +
        "YOU CRACK ME UP 13\n" +
        "NOW WHAT DOES THIS REMIND YOU OF 13\n" +
        "NOW WHAT DOES THIS REMIND YOU OF 14\n" +
        "I'VE EATEN TOO MUCH\n" +
        "WHAT A DAG result\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("0\n")
  }

  it should "1 Equals 2 evaluates False" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING one\n" +
        "LOOK AT THIS JOKER 1\n" +
        "HELLO CHRIS MOLLOY SPEAKING two\n" +
        "LOOK AT THIS JOKER 2\n" +
        "HELLO CHRIS MOLLOY SPEAKING result\n" +
        "LOOK AT THIS JOKER @YES\n" +
        "WHAT A HARD CASE result\n" +
        "YOU CRACK ME UP one\n" +
        "NOW WHAT DOES THIS REMIND YOU OF two\n" +
        "I'VE EATEN TOO MUCH\n" +
        "WHAT A DAG result\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("0\n")
  }

  it should "2 is greater than 1 evaluates True" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING one\n" +
        "LOOK AT THIS JOKER 1\n" +
        "HELLO CHRIS MOLLOY SPEAKING two\n" +
        "LOOK AT THIS JOKER 2\n" +
        "HELLO CHRIS MOLLOY SPEAKING result\n" +
        "LOOK AT THIS JOKER @YES\n" +
        "WHAT A HARD CASE result\n" +
        "YOU CRACK ME UP two\n" +
        "TASTIER THAN one\n" +
        "I'VE EATEN TOO MUCH\n" +
        "WHAT A DAG result\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("1\n")
  }

  it should "1 is greater than 2 evaluates False" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING one\n" +
        "LOOK AT THIS JOKER 1\n" +
        "HELLO CHRIS MOLLOY SPEAKING two\n" +
        "LOOK AT THIS JOKER 2\n" +
        "HELLO CHRIS MOLLOY SPEAKING result\n" +
        "LOOK AT THIS JOKER @YES\n" +
        "WHAT A HARD CASE result\n" +
        "YOU CRACK ME UP one\n" +
        "TASTIER THAN two\n" +
        "I'VE EATEN TOO MUCH\n" +
        "WHAT A DAG result\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("0\n")
  }

  it should "3 is greater than 3 evaluates False" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING three\n" +
        "LOOK AT THIS JOKER 3\n" +
        "HELLO CHRIS MOLLOY SPEAKING three2\n" +
        "LOOK AT THIS JOKER 3\n" +
        "HELLO CHRIS MOLLOY SPEAKING result\n" +
        "LOOK AT THIS JOKER @YES\n" +
        "WHAT A HARD CASE result\n" +
        "YOU CRACK ME UP three\n" +
        "TASTIER THAN three2\n" +
        "I'VE EATEN TOO MUCH\n" +
        "WHAT A DAG result\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("0\n")
  }

  it should "detect faulty logical operations" in {
    val code = "FRONT ROWS TAKE AIM!\n" +
      "RIGHT? WRONG! VAR\n" +
      "LOOK AT THIS JOKER @NOT REALLY\n" +
      "WHAT A HARD CASE VAR\n" +
      "@NOT REALLY\n" +
      "@NOT REALLY\n" +
      "NASE BLASEN\n" +
      "@YES\n" +
      "I'VE EATEN TOO MUCH\n" +
      "I'LL GO WASH THE DISHES\n"
    intercept[ParsingException] {
      getOutput(code)
    }
  }
}
