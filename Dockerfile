FROM dadbasic-env
RUN rm -r project src build.sbt
ADD project project
ADD src src
ADD build.sbt build.sbt
RUN sbt assembly
