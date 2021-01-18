## Run Redis
`docker run -d -p 6379:6379 --name redis redis`
## Run App
`./gradlew bootRun`
## Stop Redis
`docker stop redis && docker rm redis`