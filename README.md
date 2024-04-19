# example-docker-compose-orchestation-Spring-boot-App
# for compile spring-boot aplications
  mvn clean install -DskipTest
# for run docker compose 
  docker-compose up -d
# for run docker compose with file config  "compose-stack-app.yml"
  docker compose -f compose-stack-app.yml up -d
# the environment variable is defined into file .env
# other command for docker-compose
   - docker compose ps
   - docker compose stop
   - docker compose rm
# other commands docker
   - docker ps
   - docker ps -a
   - docker image ls
   - docker logs <container>
   
