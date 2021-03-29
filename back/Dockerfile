FROM debian

RUN apt-get update && \
    apt-get upgrade && \
	apt-get -y install openjdk-11-jre && \
	mkdir /home/files

COPY lab6.jar /home
CMD ["java","-jar", "/home/lab6.jar"]