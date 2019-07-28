FROM ubuntu:18.04
RUN apt update && apt install -y openjdk-8-jdk && mkdir groovy-lib
COPY hello.groovy .
COPY java-lib ./java-lib
ENV CLASSPATH=/java-lib/*
CMD java groovy.ui.GroovyMain  hello.groovy