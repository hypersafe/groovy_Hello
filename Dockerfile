FROM ubuntu:18.04
RUN apt update && apt install -y openjdk-8-jdk && mkdir groovy-lib
COPY hello.groovy .
COPY groovy-lib ./groovy-lib
ENV CLASSPATH=/groovy-lib/*
CMD java groovy.ui.GroovyMain  hello.groovy