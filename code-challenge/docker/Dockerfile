FROM ubuntu:trusty
MAINTAINER Leo zhang (lza@tradeshift.com)

# Install Java

RUN echo "deb http://archive.ubuntu.com/ubuntu trusty main universe" > /etc/apt/sources.list
RUN apt-get -y update
RUN apt-get -y install wget tar
RUN apt-get install -y software-properties-common python-software-properties
RUN apt-add-repository -y ppa:webupd8team/java

RUN apt-get update

RUN echo oracle-java7-installer shared/accepted-oracle-license-v1-1 select true | /usr/bin/debconf-set-selections

RUN sudo apt-get install -y oracle-java7-installer

RUN useradd --create-home codechallenge
ADD run.sh /home/codechallenge/run.sh
ADD warmup.war /home/codechallenge/warmup.war
ADD jetty-runner.jar /home/codechallenge/jetty-runner.jar

EXPOSE 8080

RUN sudo chmod 777 /home/codechallenge/run.sh

ENTRYPOINT /home/codechallenge/run.sh
