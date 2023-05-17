# Дипломный проект по курсу «Тестировщик ПО»
___________________________________________________

## Запуск приложения
1. Для запуска контейнеров: 
* Запустить Docker;
* Запустить контейнеры БД MySQL, PostgreSQL, симулятор банковских сервисов. Для этого в терминале, находясь в папке проекта, ввести команду `docker-compose up` 
2. Для запуска приложения с MySQL, запустить в терминале команду `java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar`
1. Для запуска приложения с PostgreSQL, запустить в терминале команду `java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar artifacts/aqa-shop.jar`
1. Открыть приложение в браузере [http://localhost:8080/](http://localhost:8080/) 

## Запуск тестов
По команде через терминал IDE:
1. для БД MySQL: ./gradlew clean test "-Ddb.url=jdbc:mysql://localhost:3306/app"
2. для БД Postgres: ./gradlew clean test "-Durl=jdbc:postgresql://localhost:5432/app"

## Отчет ALLURE REPORT
1. Для просмотра результатов запустить в терминале `./gradlew allureServe`
1. Результаты доступны по адресу [http://localhost:37653/index.html](http://localhost:37653/index.html)


## Завершение работы приложения
1. Остановка контейнеров и очистка данных, ввести в терминале команду `docker-compose down` 
2. Остановка тестов и работы приложения, в терминале нажать **CTRL + C** 


## Документация 
1. [План автоматизации тестирования.](https://github.com/VikaMin/Diplomaqa/blob/main/docs/Plan.md) 
2. [Отчётные документы по итогам автоматизированного тестирования. ](https://github.com/VikaMin/Diplomaqa/blob/main/docs/Report.md)
3. [Отчётные документы по итогам автоматизации. ](https://github.com/VikaMin/Diplomaqa/blob/main/docs/Summary.md)
