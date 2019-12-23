FROM dadbasic-env
ADD project project
ADD src src
ADD build.sbt build.sbt
RUN sbt assembly
