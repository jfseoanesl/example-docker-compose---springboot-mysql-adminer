# example-docker-compose-orchestation-Spring-boot-App
# for compile spring-boot aplications
  mvn clean install -DskepTest
# for run docker compose 
  docker-compose up -d
# for run docker compose with file config  "compose-stack-app.yml"
  docker compose -f compose-stack-app.yml up -d
# the environment variable is defined into file .env
