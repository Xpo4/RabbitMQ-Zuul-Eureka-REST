![image](https://user-images.githubusercontent.com/49644368/56210177-e911e580-605d-11e9-9709-6c66e0f67dcf.png)

# Demo-Service

![image](https://user-images.githubusercontent.com/49644368/56210321-45750500-605e-11e9-9008-9c3d2ef4a96e.png)

Demo-Service предназначен для:
* создания школ;
* просмотра всех созданных школ;
* поиска школы по ID;
* поиска школы по наименованию;
* поиска школы по стране;
* поиска школы по индексу;
* удаления школы по ID;
---
* создания классов;
* просмотра всех созданных классов;
* поиска класа по ID;
* поиска класс по номеру;
* удаления класса по ID. 

Ссылка на запросы для Postman (https://www.getpostman.com/collections/1553e60663d14b3554d1)

# Student-Service
Student-Service предназначен для просмотра учеников по номеру школы.

# Eureka-Server
Eureka-Server регистрирует:
* Demo-Service;
* Student-Service.

# Zuul-Service
* PreFilter - выводит в лог "PreFilter".
* PostFilter - добавляет к телу ответа "PostFilter" + "http://localhost:8090/School/SchoolNumber1".

# Producer-RabbitMQ
Producer-RabbitMQ предназначен для передачи сообщения с запросом.

Пример запроса:

http://localhost:9758/send?msg=http://localhost:2020/student-api/School/SchoolNumber1
http://localhost:9758/send?msg=http://localhost:2020/student-api/School/SchoolNumber2

# Consumer-RabbitMQ
Consumer-RabbitMQ предназначен для получения сообщения с запросом от Producer-RabbitMQ и вывода запроса в консоль. 
