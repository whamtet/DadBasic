package org.dadbasic

class FeatureTest extends DadGeneratorTest {

  it should "print fibonacci numbers from 1 to 10" in {
    val code = "FRONT ROWS TAKE AIM!\n" +
      "HELLO CHRIS MOLLOY SPEAKING prev\n" +
      "LOOK AT THIS JOKER -1\n" +
      "HELLO CHRIS MOLLOY SPEAKING result\n" +
      "LOOK AT THIS JOKER 1\n" +
      "HELLO CHRIS MOLLOY SPEAKING sum\n" +
      "LOOK AT THIS JOKER 0\n" +
      "HELLO CHRIS MOLLOY SPEAKING loop\n" +
      "LOOK AT THIS JOKER @YES\n" +
      "HELLO CHRIS MOLLOY SPEAKING index\n" +
      "LOOK AT THIS JOKER 0\n" +
      "HELLO CHRIS MOLLOY SPEAKING limit\n" +
      "LOOK AT THIS JOKER 10\n" +
      "\nWHILE loop\n" +
      "\tWHAT A HARD CASE sum\n" +
      "\tYOU CRACK ME UP result\n" +
      "\tMUTOR prev\n" +
      "\tI'VE EATEN TOO MUCH\n" +
      "\n\tWHAT A HARD CASE prev\n" +
      "\tYOU CRACK ME UP result\n" +
      "\tI'VE EATEN TOO MUCH\n\t" +
      "\n\tWHAT A HARD CASE result\n" +
      "\tYOU CRACK ME UP sum\n" +
      "\tI'VE EATEN TOO MUCH\n\t" +
      "\n\tWHAT A HARD CASE index\n" +
      "\tYOU CRACK ME UP index\n" +
      "\tMUTOR 1\n" +
      "\tI'VE EATEN TOO MUCH\n\t" +
      "\n\tWHAT A HARD CASE loop\n" +
      "\tYOU CRACK ME UP limit\n" +
      "\tTASTIER THAN index\n" +
      "\tI'VE EATEN TOO MUCH\n\t" +
      "\n\tWHAT A DAG sum\n" +
      "JUST ONE MORE GAME OF CIV\n" +
      "\nI'LL GO WASH THE DISHES"

    getOutput(code) should equal("0\n1\n1\n2\n3\n5\n8\n13\n21\n34\n")
  }


  it should "print fibonacci when using recursion" in {
    val code = "FRONT ROWS TAKE AIM!\n" +
      "HELLO CHRIS MOLLOY SPEAKING result\n" +
      "LOOK AT THIS JOKER 0\n" +
      "KIDS LOOK OUT THE WINDOW result\n" +
      "PASS ME THE VEGETABLE MATTER fib 9\n" +
      "WHAT A DAG result\n" +
      "I'LL GO WASH THE DISHES\n" +
      "\nCONSTRUCTION STARTED fib\n" +
      "I DIDN'T CATCH THAT val\n" +
      "RIGHTO\n" +
      "\tHELLO CHRIS MOLLOY SPEAKING endrecursion\n" +
      "\tLOOK AT THIS JOKER @NOT REALLY\n" +
      "\tWHAT A HARD CASE endrecursion\n" +
      "\tYOU CRACK ME UP 2\n" +
      "\tTASTIER THAN val\n" +
      "\tI'VE EATEN TOO MUCH\n\n" +
      "\tIMAGINE IF endrecursion\n" +
      "\t\tHERE YOU GO val\t\n" +
      "\tOTHERWISE THERE WILL BE A CONSEQUENCE\n" +
      "\t\tHELLO CHRIS MOLLOY SPEAKING temp1\n" +
      "\t\tLOOK AT THIS JOKER 0\n" +
      "\t\tHELLO CHRIS MOLLOY SPEAKING temp2\n" +
      "\t\tLOOK AT THIS JOKER 0\n\n" +
      "\t\tWHAT A HARD CASE val\n" +
      "\t\tYOU CRACK ME UP val\n" +
      "\t\tLITTLE RATBAG 1\n" +
      "\t\tI'VE EATEN TOO MUCH\n" +
      "\t\tKIDS LOOK OUT THE WINDOW temp1\n" +
      "\t\tPASS ME THE VEGETABLE MATTER fib val\n" +
      "\t\tWHAT A HARD CASE val\n" +
      "\t\tYOU CRACK ME UP val\n" +
      "\t\tLITTLE RATBAG 1\n" +
      "\t\tI'VE EATEN TOO MUCH\n" +
      "\t\tKIDS LOOK OUT THE WINDOW temp2\n" +
      "\t\tPASS ME THE VEGETABLE MATTER fib val\n" +
      "\t\tWHAT A HARD CASE val\n" +
      "\t\tYOU CRACK ME UP temp1\n" +
      "\t\tMUTOR temp2\n" +
      "\t\tI'VE EATEN TOO MUCH\n" +
      "\t\tHERE YOU GO val\n" +
      "\t\tI'M JUST GOING TO HAVE A FIVE MINUTE NAP\n\n" +
      "\nI'M STUFFED"

    getOutput(code) should equal("34\n")
  }


  it should "printf modulos when a modulo function is defined" in {
    val code = "FRONT ROWS TAKE AIM!\n" +
      "HELLO CHRIS MOLLOY SPEAKING result1\n" +
      "LOOK AT THIS JOKER 0\n" +
      "HELLO CHRIS MOLLOY SPEAKING result2\n" +
      "LOOK AT THIS JOKER 0\n" +
      "HELLO CHRIS MOLLOY SPEAKING result3\n" +
      "LOOK AT THIS JOKER 0\n" +
      "HELLO CHRIS MOLLOY SPEAKING result4\n" +
      "LOOK AT THIS JOKER 0\n" +
      "KIDS LOOK OUT THE WINDOW result1\n" +
      "PASS ME THE VEGETABLE MATTER modulo 9 4\n" +
      "WHAT A DAG result1\n" +
      "KIDS LOOK OUT THE WINDOW result2\n" +
      "PASS ME THE VEGETABLE MATTER modulo 4795 87\n" +
      "WHAT A DAG result2\n" +
      "KIDS LOOK OUT THE WINDOW result3\n" +
      "PASS ME THE VEGETABLE MATTER modulo 3978 221\n" +
      "WHAT A DAG result3\n" +
      "KIDS LOOK OUT THE WINDOW result4\n" +
      "PASS ME THE VEGETABLE MATTER modulo 5559 345\n" +
      "WHAT A DAG result4\n" +
      "I'LL GO WASH THE DISHES\n" +
      "CONSTRUCTION STARTED modulo\n" +
      "I DIDN'T CATCH THAT dividend\n" +
      "I DIDN'T CATCH THAT divisor\n" +
      "RIGHTO\n" +
      "HELLO CHRIS MOLLOY SPEAKING quotient\n" +
      "LOOK AT THIS JOKER 0\n" +
      "HELLO CHRIS MOLLOY SPEAKING remainder\n" +
      "LOOK AT THIS JOKER 0\n" +
      "HELLO CHRIS MOLLOY SPEAKING product\n" +
      "LOOK AT THIS JOKER 0\n" +
      "WHAT A HARD CASE quotient\n" +
      "YOU CRACK ME UP dividend\n" +
      "GET OUT OF HERE divisor\n" +
      "I'VE EATEN TOO MUCH\n" +
      "WHAT A HARD CASE product\n" +
      "YOU CRACK ME UP divisor\n" +
      "PARENTAL UNITS quotient\n" +
      "I'VE EATEN TOO MUCH\n" +
      "WHAT A HARD CASE remainder\n" +
      "YOU CRACK ME UP dividend\n" +
      "LITTLE RATBAG product\n" +
      "I'VE EATEN TOO MUCH\n" +
      "HERE YOU GO remainder\n" +
      "I'M STUFFED"

    getOutput(code) should equal("1\n10\n0\n39\n")
  }

  it should "print squares from 1 to 10" in {
    val code = "FRONT ROWS TAKE AIM!\n" +
      "HELLO CHRIS MOLLOY SPEAKING limit\n" +
      "LOOK AT THIS JOKER 10\n" +
      "HELLO CHRIS MOLLOY SPEAKING index\n" +
      "LOOK AT THIS JOKER 1\n" +
      "HELLO CHRIS MOLLOY SPEAKING squared\n" +
      "LOOK AT THIS JOKER 1\n" +
      "HELLO CHRIS MOLLOY SPEAKING loop\n" +
      "LOOK AT THIS JOKER @YES \n\n" +
      "WHILE loop\n\n" +
      "\tWHAT A HARD CASE squared\n" +
      "\tYOU CRACK ME UP index\n" +
      "\tPARENTAL UNITS index\n" +
      "\tI'VE EATEN TOO MUCH\n" +
      "\tWHAT A DAG squared\n\t\n" +
      "\tWHAT A HARD CASE loop\n" +
      "\tYOU CRACK ME UP limit\n" +
      "\tTASTIER THAN index\n" +
      "\tI'VE EATEN TOO MUCH\n\t\n" +
      "\tWHAT A HARD CASE index\n" +
      "\tYOU CRACK ME UP index\n" +
      "\tMUTOR 1\n" +
      "\tI'VE EATEN TOO MUCH\n\t\n" +
      "JUST ONE MORE GAME OF CIV\n" +
      "I'LL GO WASH THE DISHES"

    getOutput(code) should equal("1\n4\n9\n16\n25\n36\n49\n64\n81\n100\n")
  }

}
