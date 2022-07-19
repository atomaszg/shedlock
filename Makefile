clean:
	./gradlew clean
build: clean
	./gradlew build -x test

test:
	./gradlew test

docker-image:
	./gradlew jibDockerBuild --stacktrace \
	-Djib.from.image=eclipse-temurin:11-jre \
	-Djib.to.image=ghcr.io/tomasz-galuszka/shedlock \
	-Djib.to.tags=latest-local \
	-Djib.container.creationTime=USE_CURRENT_TIMESTAMP \
	-Djib.containerizingMode=packaged
docker-down:
	docker-compose --project-directory=$(shell pwd)/docker down --remove-orphans
docker-up: docker-down
	docker-compose --project-directory=$(shell pwd)/docker up -d
	docker-compose --project-directory=$(shell pwd)/docker ps
	docker-compose --project-directory=$(shell pwd)/docker logs -f shedlock-service
docker-logs:
	docker-compose --project-directory=$(shell pwd)/docker logs -f shedlock-service
docker-restart:
	docker-compose --project-directory=$(shell pwd)/docker stop shedlock-service
	docker-compose --project-directory=$(shell pwd)/docker up -d --no-deps --force-recreate --build shedlock-service
	docker-compose --project-directory=$(shell pwd)/docker logs -f shedlock-service