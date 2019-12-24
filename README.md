# DadBasic

Programming language based on the Dadisms of Chris Molloy.

## HelloWorld.basic

	IT'S SHOWTIME
	TALK TO THE HAND "hello world"
	YOU HAVE BEEN TERMINATED

## Quick Start

	wget http://lhartikk.github.io/DadBasic.jar
	echo -e "IT'S SHOWTIME\nTALK TO THE HAND \"hello world\"\nYOU HAVE BEEN TERMINATED" > hello.basic
	java -jar DadBasic.jar hello.basic
	java hello

To create some "audible" output you can try the -declaim option:

	java -jar DadBasic.jar -declaim hello.basic

## Brief overview of the keywords

Check the [wiki](http://github.com/whamtet/DadBasic/wiki/DadBasic) for more details

False `I LIED`

True `NO PROBLEMO`

If `BECAUSE I'M GOING TO SAY PLEASE`

Else `BULLSHIT`

EndIf `YOU HAVE NO RESPECT FOR LOGIC`

While `STICK AROUND`

EndWhile `CHILL`

PlusOperator `GET UP`

MinusOperator `GET DOWN`

MultiplicationOperator `YOU'RE FIRED`

DivisionOperator] `HE HAD TO SPLIT`

ModuloOperator  `I LET HIM GO`

EqualTo `YOU ARE NOT YOU YOU ARE ME`

GreaterThan `LET OFF SOME STEAM BENNET`

Or `CONSIDER THAT A DIVORCE`

And `KNOCK KNOCK`

DeclareMethod `LISTEN TO ME VERY CAREFULLY`

NonVoidMethod `GIVE THESE PEOPLE AIR`

MethodArguments `I NEED YOUR CLOTHES YOUR BOOTS AND YOUR MOTORCYCLE`

Return `I'LL BE BACK`

EndMethodDeclaration `HASTA LA VISTA, BABY`

CallMethod `DO IT NOW`

AssignVariableFromMethodCall `GET YOUR ASS TO MARS`

DeclareInt `HEY CHRISTMAS TREE`

SetInitialValue `YOU SET US UP`

BeginMain `IT'S SHOWTIME`

EndMain `YOU HAVE BEEN TERMINATED`

Print `TALK TO THE HAND`

ReadInteger `I WANT TO ASK YOU A BUNCH OF QUESTIONS AND I WANT TO HAVE THEM ANSWERED IMMEDIATELY`

AssignVariable `GET TO THE CHOPPER`

SetValue `HERE IS MY INVITATION`

EndAssignVariable `ENOUGH TALK`

ParseError `WHAT THE FUCK DID I DO WRONG`
