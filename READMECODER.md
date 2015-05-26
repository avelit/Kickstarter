Kickstarter project

Short documentation.

Project use Spring IoC, MVC, Security & Hibernate (see settings files)

Project tiers:<br>
1. DB - Sqlite in test & MySQL in production.<br>
2. DAO - package dao<br>
3. Business logic - package service<br>
4. UI - jsp`s<br>
5. Controllers - package controller<br>

Spring create connection pool bean & give it to session factory. Transaction manager receive session factory.
Transactions are created by annotations.
Beans are created by annotations (@Repository, @Service, @Component).
Beans are injected by annotations.
Controllers are mapped by annotations.

User send request to Spring. Spring resolve it via controllers (-service (-dao)) (if needed), create response and send it back.

Spring use ORM Hibernate.
Hibernate use annotations in model package & operations in dao package.
All class in model have own table in database & dao & service class

Security resolve by Spring security filter.

jsp`s use bootstrap themes.
