# Лабораторная работа #2

[![License: CC BY-NC-ND 4.0](https://img.shields.io/badge/License-CC%20BY--NC--ND%204.0-lightgrey.svg)](https://creativecommons.org/licenses/by-nc-nd/4.0/)
![GitHub Classroom Workflow](../../workflows/GitHub%20Classroom%20Workflow/badge.svg?branch=master)

## Калькулятор

### Формулировка

Основываясь на [Лабораторной работе #1](https://github.com/Romanow-Education/homework1-template) реализовать web сервер
для вычисления арифметических выражений. Автоматизировать процесс сборки, тестирования и релиза на Heroku.

Web сервер имеет только один метод:

```http request
POST /api/v1/eval
Accept: text/plain
Content-Type: text/plain
```

На вход в body получает строку, на выходе `200 OK` и в теле возвращает результат. Если входное выражение содержит
некорректную скобочную структуру, то возвращаем `400 Bad Request`.

### Требования

1. Деплой на Heroku реализовать средствами `GitHub Actions`, для деплоя использовать `Docker`.
2. После успешного деплоя на Heroku, через `newman` запускаются интеграционные тесты. Интеграционные тесты можно
   проверить локально, для этого нужно импортировать в Postman
   коллекцию [postman_collection.json](postman/postman_collection.json) и
   environment [postman_environment.local.json](postman/postman_environment.local.json).
3. В [postman_environment.heroku.json](postman/postman_environment.heroku.json) заменить значение `baseUrl` на адрес
   развернутого сервиса на heroku.
4. В [classroom.yml](.github/workflows/classroom.yml) дописать `email` и `name` для деплоя на Heroku.

### Сборка и прогон тестов

```shell
$ ./gradlew clean build

$ newman run -e postman/postman_environment.json postman/postman_collection.local.json
```

### Прием домашнего задания

Как только тесты будут успешно пройдены, в Github Classroom на dashboard появится отметка об успешной сдаче. Так же в
самом репозитории появится бейдж со статусом сборки.