# Лабораторная работа #2

[![License: CC BY-NC-ND 4.0](https://img.shields.io/badge/License-CC%20BY--NC--ND%204.0-lightgrey.svg)](https://creativecommons.org/licenses/by-nc-nd/4.0/)
![GitHub Classroom Workflow](../../workflows/GitHub%20Classroom%20Workflow/badge.svg?branch=master)

## Калькулятор

### Формулировка

Основываясь на [Лабораторной работе #1](https://github.com/Romanow-Education/homework1-template) реализовать web сервер
для вычисления арифметических выражений.

Web сервер имеет только один метод

```http request
POST /api/v1/eval
Accept: text/plain
Content-Type: text/plain
```

На вход в body получает строку, на выходе `200 OK` и в теле возвращает результат. Если входное выражение содержит
некорректную скобочную структуру, то возвращаем `400 Bad Request`.

### Сборка и прогон тестов

```shell
$ ./gradlew clean build

$ newman run -e postman/postman_environment.json postman/postman_collection.json
```

### Прием домашнего задания

Как только тесты будут успешно пройдены, в Github Classroom на dashboard появится отметка об успешной сдаче. Так же в
самом репозитории появится бейдж со статусом сборки.