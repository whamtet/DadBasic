package org.dadbasic

class BranchStatementTest extends DadGeneratorTest {
  it should "function using simple if statements" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING vartrue\n" +
        "LOOK AT THIS JOKER @YES\n" +
        "IMAGINE IF vartrue\n" +
        "WHAT A DAG \"this branch should be reached\"\n" +
        "I'M JUST GOING TO HAVE A FIVE MINUTE NAP\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("this branch should be reached\n")
  }

  it should "function using simple if statements vol2" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING vartrue\n" +
        "LOOK AT THIS JOKER @NOT REALLY\n" +
        "IMAGINE IF vartrue\n" +
        "WHAT A DAG \"this branch should not be reached\"\n" +
        "I'M JUST GOING TO HAVE A FIVE MINUTE NAP\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("")
  }

  it should "function using simple if else statements" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING vartrue\n" +
        "LOOK AT THIS JOKER @YES\n" +
        "IMAGINE IF vartrue\n" +
        "WHAT A DAG \"this branch should be reached\"\n" +
        "OTHERWISE THERE WILL BE A CONSEQUENCE\n" +
        "WHAT A DAG \"this branch should not be reached\"\n" +
        "I'M JUST GOING TO HAVE A FIVE MINUTE NAP\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("this branch should be reached\n")
  }

  it should "function using simple if else statements vol2" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING varfalse\n" +
        "LOOK AT THIS JOKER @NOT REALLY\n" +
        "IMAGINE IF varfalse\n" +
        "WHAT A DAG \"this branch should not be reached\"\n" +
        "OTHERWISE THERE WILL BE A CONSEQUENCE\n" +
        "WHAT A DAG \"this branch should be reached\"\n" +
        "I'M JUST GOING TO HAVE A FIVE MINUTE NAP\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("this branch should be reached\n")
  }

  it should "function using assigning variables in if statements" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING var\n" +
        "LOOK AT THIS JOKER 0\n" +
        "HELLO CHRIS MOLLOY SPEAKING vartrue\n" +
        "LOOK AT THIS JOKER @YES\n" +
        "IMAGINE IF vartrue\n" +
        "WHAT A HARD CASE var\n" +
        "YOU CRACK ME UP 3\n" +
        "I'VE EATEN TOO MUCH\n" +
        "I'M JUST GOING TO HAVE A FIVE MINUTE NAP\n" +
        "WHAT A DAG var\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("3\n")
  }


  it should "function using stub while statement" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING varfalse\n" +
        "LOOK AT THIS JOKER @NOT REALLY\n" +
        "WHILE varfalse\n" +
        "JUST ONE MORE GAME OF CIV\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("")
  }


  it should "function using stub while statement vol2" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "WHILE @NOT REALLY\n" +
        "JUST ONE MORE GAME OF CIV\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("")
  }



  it should "function when while loop executed once" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING varfalse\n" +
        "LOOK AT THIS JOKER @YES\n" +
        "WHILE varfalse\n" +
        "WHAT A HARD CASE varfalse\n" +
        "YOU CRACK ME UP @NOT REALLY\n" +
        "I'VE EATEN TOO MUCH\n" +
        "WHAT A DAG \"while statement printed once\"\n" +
        "JUST ONE MORE GAME OF CIV\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("while statement printed once\n")
  }

  it should "function when while loop executed consequently" in {
    val code =
      "FRONT ROWS TAKE AIM!\n" +
        "HELLO CHRIS MOLLOY SPEAKING isLessThan10\n" +
        "LOOK AT THIS JOKER @YES\n" +
        "HELLO CHRIS MOLLOY SPEAKING n\n" +
        "LOOK AT THIS JOKER 0\n" +
        "WHILE isLessThan10\n" +
        "WHAT A HARD CASE n\n" +
        "YOU CRACK ME UP n\n" +
        "MUTOR 1\n" +
        "I'VE EATEN TOO MUCH\n" +
        "WHAT A DAG n\n" +
        "WHAT A HARD CASE isLessThan10\n" +
        "YOU CRACK ME UP 10\n" +
        "TASTIER THAN n\n" +
        "I'VE EATEN TOO MUCH\n" +
        "JUST ONE MORE GAME OF CIV\n" +
        "I'LL GO WASH THE DISHES\n"
    getOutput(code) should equal("1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n")
  }
}
