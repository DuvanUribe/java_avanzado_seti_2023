FROM amazoncorretto:17-alpine
VOLUME /tmp
COPY *.jar ms_ch_primero.jar
RUN adduser -D -g '' appuser && chown appuser: /ms_ch_primero.jar
USER appuser
RUN sh -c 'touch /ms_ch_primero.jar'
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=70 -Djava.security.egd=file:/dev/./urandom"
# Replace with a non-root user to avoid running the container with excessive privileges

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS  -jar ms_ch_primero.jar" ]
