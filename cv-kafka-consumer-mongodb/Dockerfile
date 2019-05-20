FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ENV TIMEZONE America/Argentina/Buenos_Aires

# Set up timezone
RUN apk add --update tzdata
RUN cp /usr/share/zoneinfo/${TIMEZONE} /etc/localtime
RUN echo "${TIMEZONE}" > /etc/timezone
ADD ./target/cv-kafka-consumer-mongodb-1.0.0-exec.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS="-Xms512m -Xmx512m"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
