Kickstarter project

Short documentation.

Project uses Spring IoC, Spring MVC, Spring Security, ORM Hibernate frameworks. Configuration for these frameworks is provided in the files "application-context.xml", "spring-security.xml".

Project components:<br>
1. DB - SQLite for tests, MySQL for production version. Dialect used - MySQL.<br>
2. DAO - package "dao".<br>
3. Model - package "model".<br>
4. Controllers - package "controller".<br>
5. Business logic - package "service".<br>
6. UI - JSPs.<br>
7. Integration and Unit tests - package "test".<br>

During installation of the project, integration test creates the database and all the necessary tables. Several test categories and projects are put in the database after the creation for test purposes. In case of reinstalling the application, all tables in the database are dropped.

Spring IoC, Spring MVC and ORM Hibernate frameworks work by the way of using annotations (@Repository for DAO, @Service for Services, @Controller for Controllers, @Entity for Model items). All Spring beans are singletons, injected using the annotation @Autowired.

All classes provided in the package "model" have their table represenation in the database. There are also specific DAO, Service and Controller classes for each such class.

Connection pool and session factory are created by Spring and used by DAO classes.

All requests from user are handled by the Spring DispatcherServlet, and then redirected to the required controller. Controllers return ModelAndView objects with the reference to the appropriate JSP page, and additional prarmeters (if needed).

All security issues (log in / log out, remembering the password) are resolved by the Spring security filter.

JSPs use Bootstrap themes.

All logs are traced using Log4J framework. All log information is displayed on the console and copied to file "logging.log"
