# Simple Fullstack User Management System

A simple fullstack CRUD (Create, Read, Update, Delete) application that allows adding, deleting, editing, and viewing users stored in a MySQL database.

## 📌 Project Name
**User Management System – React, Spring Boot & MySQL**

---
## 📖 Overview
This project is a beginner‑friendly fullstack application built to understand the basics of:
- Building REST APIs using Spring Boot
- Connecting backend to MySQL using JDBC/JPA
- Performing CRUD operations
- Creating a frontend UI using React.js

The application allows users to:
- Add a new user
- View a list of all users
- View detailed info of a specific user
- Edit user details
- Delete a user from the database

---
## 🛠️ Tech Stack Used
### **Frontend**
- React JS
- Axios for API requests
- React Router DOM for routing
- Bootstrap / CSS for styling

### **Backend**
- Spring Boot
- Spring Web
- JDBC / Spring Data JPA

### **Database**
- MySQL

---
## 📂 Project Structure
```
project/
├── backend/
│   ├── src/main/java/com/example/backend/
│   │   ├── controller/UserController.java
│   │   ├── model/User.java
│   │   ├── repository/UserRepository.java
│   │   ├── service (optional)
│   └── src/main/resources/application.properties
│
├── frontend/
│   ├── src/components/
│   │   ├── AddUser.js
│   │   ├── EditUser.js
│   │   ├── ViewUser.js
│   │   └── Home.js
│   ├── src/layout/Navbar.js
│   └── App.js
```

---
## ⚙️ Backend Setup (Spring Boot)
1. Install MySQL and create a database:
```sql
CREATE DATABASE userdb;
```

2. Update your `application.properties` file:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/userdb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

3. Run the Spring Boot application:
```bash
mvn spring-boot:run
```
Backend runs on: **http://localhost:8080**

---
## 🎨 Frontend Setup (React)
1. Navigate to the frontend folder:
```bash
cd frontend
```

2. Install dependencies:
```bash
npm install
```

3. Run the React app:
```bash
npm start
```
Frontend runs on: **http://localhost:3000**

---
## 🔗 API Endpoints
| Method | Endpoint | Description |
|--------|-------------|----------------|
| GET | `/users` | Get all users |
| GET | `/user/{id}` | Get single user |
| POST | `/user` | Add new user |
| PUT | `/user/{id}` | Update user |
| DELETE | `/user/{id}` | Delete user |

---
## 🚀 Features
- Simple and clean UI
- Fully functional CRUD operations
- MySQL persistence
- Structured and scalable backend
- Easy project to learn fullstack development

---
## 📘 Steps to Use the Application
1. Open the React app in your browser.
2. Navigate to **Add User** and submit a new entry.
3. See the user list on the home page.
4. Click **View**, **Edit**, or **Delete** for each user.
5. All actions update the database instantly.

---
## 📝 Future Improvements
- Add form validation
- Add pagination
- Add authentication (JWT)
- Add search functionality
- Dockerize the project

---
## 👨‍💻 Author
Project created by **GanuGT**.

---
## 📜 License
This project is open-source and free to use.

