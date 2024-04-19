# Usa una imagen base con JRE 17 en Alpine
FROM eclipse-temurin:17-alpine

# Create a new group with specific uid and non-root user called "admin"
# Be sure that group id are not present on host. if already exist change by arbitrary other uid
RUN addgroup -g 1028 devopsc \
    && adduser -D -G devopsc admin

# Create a new mount point at /tmp on native host because a volume is more efficient and faster than filesystem
VOLUME /tmp

# define argumentos
ARG JAR_FILE
ARG DB_PASSWORD
ARG DB_USER
ARG DB_NAME
ARG DB_SERVER

# Establece la variable de entorno con el valor de los argumentos
ENV DB_PASSWORD=$DB_PASSWORD
ENV DB_NAME=$DB_NAME
ENV DB_USER=$DB_USER
ENV DB_SERVER=$DB_SERVER

# Copia el archivo JAR
COPY ${JAR_FILE} /tmp/app.jar

# Change ownership of the /app directory to the "admin" user
RUN chown -R admin:devopsc /tmp

# Cambia al usuario 'admin'
USER admin

EXPOSE 80

# Ejecutamos el jar al iniciar el contenedor
ENTRYPOINT ["java","-jar","/tmp/app.jar"]