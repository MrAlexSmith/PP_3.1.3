### **Группа: java_may18_2023_1**
### **Студент: Александр Ковалёв**
# Java Pre-Project - Spring Boot, Security.
## Практическая задача 3.1.3
### Логин администратора: admin@email.com
### Все пользователи имеют пароль: 123
### _ВНИМАНИЕ! В конфигурации-заготовке, которая указана в ссылке условия задачи, применяется устаревшая методика. В предыдущей задаче 3.1.2 применяются самые последние версии зависимостей на 25.07.2023 г. В связи с этим в задаче 3.1.3 применяются самые последние версии зависимостей на 25.07.2023 г. Также в данной задаче используется новая методика, рекомендуемая производителем Spring Security. С рекомендациями можно ознакомиться на официальном сайте https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter._
#### **Условие:**
Склонируйте проект по [ссылке](https://github.com/KataAcademy/PP_3_1_2_Boot_Security) и просмотрите его.
Модуль Spring Security позволяет нам внедрять права доступа, а также контролировать их исполнение без ручных проверок.
Spring Security базируется на 2х интерфейсах, которые определяют связь сущностей с секьюрностью: UserDetails и GrantedAuthority.
UserDetails - то, что будет интерпретироваться системой как пользователь.
GrantedAuthority - сущность, описывающая права юзера.
Оба эти интерфейса имеют множество реализаций: просмотрите класс WebSecurityConfig, в методе configure() с помощью настроек userDetailsService() мы собираем единственный на всю программу экземпляр UserDetails с именем и паролем user , а его роль “USER” так же будет преобразована в экземпляр GrantedAuthority.
Это простейший способ создания секьюрности. Так же мы можем использовать jdbc-аутентификацию путем написания запроса, возвращающего пользователя и роль.
Как вы понимаете, такие способы максимально просты, но лишены достаточной гибкости, потому наиболее часто используемый вариант настройки выглядит как имплементация UserDetails и GrantedAuthority в классах-сущностях с переопределением существующих методов.
### **Рассмотрим приложение.**
#### **Новые классы:**
- WebSecurityConfig- настройка секьюрности по определенным URL, а также настройка UserDetails и GrantedAuthority.
- LoginSuccessHandler - хэндлер, содержащий в себе алгоритм действий при успешной аутентификации. Например, тут мы можем отправить пользователя с ролью админа на админку после логина, а с ролью юзер на главную страницу сайта и т.п.
#### **Задание**:
1. Перенесите классы и зависимости из предыдущей задачи.
2. Создайте класс Role и свяжите User с ролями так, чтобы юзер мог иметь несколько ролей.
3. Имплементируйте модели Role и User интерфейсами GrantedAuthority и UserDetails соответственно. Измените настройку секьюрности с inMemory на userDetailService.
4. Все CRUD-операции и страницы для них должны быть доступны только пользователю с ролью admin по url: /admin/.
5. Пользователь с ролью user должен иметь доступ только к своей домашней странице /user, где выводятся его данные. Доступ к этой странице должен быть только у пользователей с ролью user и admin. Не забывайте про несколько ролей у пользователя!
6. Настройте logout с любой страницы с использованием возможностей thymeleaf.
7. Настройте LoginSuccessHandler так, чтобы админа после аутентификации направляло на страницу /admin, а юзера на его страницу /user.