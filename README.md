# Bravi Challenge
The challenge project to enter the Bravi. Your objective is validate balanced brackets.

## How works
This is an API REST that attend request for /v1/brackets.

### /v1/brackets
Meets the GET method and validate if input received contains balanced brackets.
- Example 0 (Checking '{}\[\]()')
```shell script
$  curl -I -X GET 'http://localhost:8080/v1/brackets?input=%7B%7D%5B%5D%28%29'
```
- Example 1 (Checking '{}[')
```shell script
$  curl -I -X GET 'http://localhost:8080/v1/brackets?input=%7B%7D%5B'
```
Will returns:
- 200 if input contains balanced brackets
- 204 if input not contains balanced brackets
- 400 if input not present
- 500 if occurs any error

## Run locally quickly

### Requirements
- Docker 19.03^
- Docker Compose 1.23^

Run and test the application with command below \
**Attention**: Have free ports 8080
```shell script
$ docker-compose up -d
```
Access the address http://localhost:8080/ and use as from swagger-ui

## Run and develop

### Requirements
- Gradle 5.6^
- Java 11^

Install all dependencies...
```shell script
$ gradle build
```
Run project...
```shell script
$ gradle bootRun
```
Access the address http://localhost:8080/ and use as from swagger-ui