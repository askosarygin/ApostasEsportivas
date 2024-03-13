Агрегатор предложений букмекерских компаний. На первой странице предлагается выбрать страну и ввести номер телефона, после ввода (можно вводить рандомный с любой понравившейся страной из списка) открывается список предложений от букмекерских компаний.

Данные хранятся локально.

Архитектура проекта старается следовать принципам Clean architecture, и делится на модули:

* app - модуль, который знает обо всех модулях в проекте и выступает местом для хранения всех зависимостей (в классе MainApp)
* common - модуль для хранения общей на проект информации: расширений классов, сущностей для обмена данными между слоями ui, domain, data, настроек темы, и ресурсов
* data - модуль для работы с внутренней БД
* *-ui - модули для хранений экранов и вью моделей для них
* *-domain - модули для выполнения бизнес логики и подтягивания данных из слоя data в слой ui
