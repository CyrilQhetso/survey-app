# 📝 Lifestyle Survey Application

A full-stack web application built with **Angular** (frontend) and **Spring Boot** (backend) that allows users to fill out a lifestyle survey and view aggregated statistics based on the results.

---

## 📁 Project Structure

survey-app/
├── backend/ # Spring Boot application (Java)
└── frontend/ # Angular application (TypeScript)


---

## 🚀 Features

- Submit lifestyle survey responses
- Calculate and view aggregate statistics:
  - Total surveys completed
  - Average, oldest, and youngest ages
  - % of people who like Pizza
  - Average rating for eating out
- Validations for form inputs
- Responsive UI for all screen sizes
- Real-time age calculation based on date of birth

---

## ⚙️ Tech Stack

### 🔧 Backend
- Java 17
- Spring Boot 3.x
- Spring Data JPA
- H2 In-Memory Database
- Hibernate
- Maven

### 💻 Frontend
- Angular 17
- TypeScript
- Reactive Forms
- Bootstrap (custom styles)

---

## 🛠️ Setup Instructions

### 🔙 Backend Setup (Spring Boot)
1. Navigate to the `survey-backend` folder:
   ```bash
   cd survey-backend
   mvn clean install
   mvn spring-boot:run
  
### 🖥️ Frontend Setup (Angular)
1. Navigate to the `survey-frontend` folder:
   ```bash
   cd survey-frontend
   npm install
   ng serve

