# Онлайн библиотека на Spring
____

## Требования к заданию

Написать web-приложение для управления электронной библиотекой.
Приложение должно уметь:

- Искать книги по автору или названию.
- Управлять списком книг: добавить/редактировать/удалить книгу
- Управлять списком авторов: добавить/редактировать/удалить автора
- Связь между книгами и авторами - многие ко многим.


## Текущая реализация

Приложение умеет:
- Искать книги по автору или названию.
- Управлять списком книг: добавить
- Управлять списком авторов: добавить
- Связь между авторами и книгами - многие ко многим.

Приложение реализовано с использованием Spring Boot.

Связь с БД MySQL реализована через JpaRepository.
Созданы классы @Entity Author и Book.

Index.html расположена в templates/index.html

Возможность удалять и редактировать книги и авторов предусмотрена в контроллере, и сервисе, 
но пока должным образом не реализована. 

## Отсутствуют

Какие-либо тесты.

Обработчики ошибок и т.д.