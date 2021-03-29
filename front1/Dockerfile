FROM debian

RUN apt-get update && \
    apt-get upgrade && \
	apt-get -y install openjdk-11-jre

COPY lab7.jar /home
CMD ["java","-jar", "/home/lab7.jar"]