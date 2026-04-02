# Journal App Backend (Spring Boot)

This is a backend REST API application for managing journal entries, built using Java and Spring Boot. The project demonstrates a clean layered architecture and follows best practices used in real-world backend development.

---

## 🚀 Features

- Create, Read, Update, Delete (CRUD) journal entries
- RESTful API design
- Clean layered architecture (Controller → Service → Repository → Database)
- DTO ↔ Entity separation
- Database integration using Spring Data JPA

---

## 🧠 Architecture

The application follows a layered architecture:

Client → Controller → Service → Repository → Database

- **Controller Layer**: Handles HTTP requests and responses  
- **Service Layer**: Contains business logic and DTO ↔ Entity conversion  
- **Repository Layer**: Handles database operations using JPA  
- **Entity Layer**: Represents database tables  

---

## 🛠️ Tech Stack

- Java  
- Spring Boot  
- Spring Data JPA (Hibernate)  
- PostgreSQL  

---

## 🧰 Tools Used

- IntelliJ IDEA (Development)  
- Postman (API Testing)  
- DBeaver (Database Management)  

---

src/main/java/com/swapnil/journalapp
│
├── Controller # REST Controllers
├── Service # Business Logic
│ └── Impl # Service Implementations
├── Repository # JPA Repositories
├── Entity # Database Entities
├── Dto # Data Transfer Objects
├── Config # Configuration (ModelMapper)
└── JournalApplication.java


---

## 🔗 API Endpoints (Sample)

| Method | Endpoint        | Description           |
|--------|---------------|----------------------|
| GET    | /journal      | Get all entries      |
| POST   | /journal      | Create new entry     |
| PUT    | /journal/{id} | Update entry         |
| DELETE | /journal/{id} | Delete entry         |

---

## ▶️ How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/SwapnilAndDev046/JournalAppSpringBoot

2. Navigate to the project directory:

cd JournalAppSpringBoot
Configure your database in application.properties

3. Run the application:

mvn spring-boot:run

## 📂 Project Structure
