# Домашнее задание к занятию "Композиция и зависимость объектов. Mockito при создании автотестов"

## Цель задания

1. Научиться проектировать классы, внутреннее состояние которых содержит наборы данных

------

## Инструкция к заданию

1. Скачайте и установите профессиональный редактор кода [Intellij Idea Community Version](https://www.jetbrains.com/idea/download/)
1. Откройте IDEA и [создайте и настройте новый Maven-проект](QA_Maven_Idea_Create.md) (под каждую задачу следует создавать отдельный проект, если обратное не сказано в условии)
2. Создайте пустой репозиторий на GitHub и свяжите его с папкой вашего проекта (не с какой-либо другой папкой).
3. Правильно настройте репозиторий в плане `.gitignore`. Проигнорируйте папки `.idea` и `target` (раньше была `out`) и `.iml`-файл - их в репозитории быть не должно.
4. Закоммитьте и запушьте созданный проект на гитхаб, [настройте Github Actions](QA_CI.md), сделайте `git pull`.
4. Выполните в IDEA требуемую задачу согласно условию.
5. Проверьте соблюдение [правил форматирования кода](QA_Java_Idea_Format.md)
6. Убедитесь что при запуске `mvn clean verify` (раньше было `mvn clean test`) все тесты запускаются, проходят, а сборка завершается успешно
7. Закоммитьте и отправьте в репозиторий содержимое папки проекта.
8. Убедитесь, что CI запустился на последнем коммите и завершился успешно (зелёная галочка).

------

## Материалы, которые пригодятся для выполнения задания

1. [Как создать Maven-проект в IDEA?](QA_Maven_Idea_Create.md)
1. [Как отформатировать код в Java?](QA_Java_Idea_Format.md)
1. [Как настроить CI на основе Github Actions?](QA_CI.md)

------

## Задание 1 (обязательное)

Вам необходимо реализовать менеджер афиши для фильмов. В качестве объекта фильма можно взять объект строки — название фильма — или создать свой дата-класс.

![image](https://user-images.githubusercontent.com/53707586/152697921-e71d853c-aa2e-482b-be61-39e6c2cfb0b1.png)

В этой задаче не нужно разделять менеджер и репозиторий — все фильмы должны храниться внутри массива в поле самого менеджера. Изначально, сразу после создания, менеджер не должен содержать фильмов. 

Менеджер должен уметь выполнять следующие операции:
1. Добавление нового фильма.
2. Вывод всех фильмов в порядке добавления (`findAll`).
3. Вывод максимально лимит* штук последних добавленных фильмов в обратном от добавления порядке (`findLast`).

*Сделайте так, чтобы по умолчанию выводилось последние 5 добавленных фильма, но при создании менеджера можно было указать другое число, чтобы, например, выдавать 7 или 3, а не 5. То есть у менеджера должно быть два конструктора: один без параметров, выставляющий лимит менеджера в 5, а другой с параметром, берущий значение лимита для менеджера из параметра конструктора.

Метод получения последних фильмов будет очень похож на тот, что был в лекции. Основное отличие в том, что вам в его начале надо будет вычислить правильный ожидаемый размер результирующего массива-ответа, а не просто брать длину массива, что лежит в поле. Сделать это можно, заведя целочисленную переменную, в которую вы сохраните желаемый размер создаваемого массива, вычислите с помощью условных операторов для неё значение, а затем только создадите массив, указав эту переменную как требуемый для него размер, например:

```java
...
  ??? resultLength;
  if ??? {
    resultLength = ???
  } else {
    resultLength = ???
  }
  ??? result = new ???[resultLength];
  for (???) {
    // заполняем result из массива, что лежит в поле
    // в обратном порядке
  }
...
```

Не забывайте про использование отладчика для поиска проблем вашей реализации, если тесты проходить не будут.

Напишите необходимые, с вашей точки зрения, автотесты на различные состояния менеджера. Можно делать их не в одном файле.

------