## Описание
Агрегатор предложений букмекерских компаний. На первой странице предлагается выбрать страну и ввести номер телефона, после ввода (можно вводить рандомный с любой понравившейся страной из списка) открывается список предложений от букмекерских компаний.

## О проекте
Данные хранятся локально.
Архитектура проекта старается следовать принципам Clean architecture, и делится на модули:

* app - модуль, который знает обо всех модулях в проекте и выступает местом для хранения всех зависимостей (в классе MainApp)
* common - модуль для хранения общей на проект информации: расширений классов, сущностей для обмена данными между слоями ui, domain, data, настроек темы, и ресурсов
* data - модуль для работы с внутренней БД
* *-ui - модули для хранений экранов и вью моделей для них
* *-domain - модули для выполнения бизнес логики и подтягивания данных из слоя data в слой ui

## Скриншоты

<img src="https://github.com/askosarygin/ApostasEsportivas/assets/77168356/34853887-e5ee-41db-9de3-c1900d37958e" alt="drawing" width="200"/>
<img src="https://github.com/askosarygin/ApostasEsportivas/assets/77168356/8ebbedf2-7874-4fde-9319-46a0db592b3b" alt="drawing" width="200"/>
<img src="https://github.com/askosarygin/ApostasEsportivas/assets/77168356/863b2d01-3bb3-45a0-9663-0c6a4c9763c5" alt="drawing" width="200"/>
