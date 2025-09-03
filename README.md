# Tutorial-08-Spring-Boot-con-H2
(Course: Software Architecture)

This repository contains a small Spring Boot 3 application built as part of the Software Architecture course.  
It demonstrates:

- JPA Entities with relationships (Nutricionista, Paciente, Nota, Medicion)  
- Spring Data JPA repositories with custom queries and projections  
- Services with constructor, field, and setter-based dependency injection  
- REST controllers exposing endpoints for comparison and CRUD operations  
- H2 in-memory database with seed data (`data.sql`)  
- Profiles for development (in-memory H2) and staging (file-based H2)  
- H2 console enabled at `/h2-console` for interactive database exploration  

---

### How to run
```bash
mvn clean spring-boot:run -Dspring-boot.run.profiles=dev
```

Made by: Alejandro Garcés Ramírez