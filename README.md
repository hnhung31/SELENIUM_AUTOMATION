<h1 align="center">🚀 E-Commerce Automation Testing Framework</h1>

<div align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white" alt="Java"/>
  <img src="https://img.shields.io/badge/Selenium-43B02A?style=for-the-badge&logo=selenium&logoColor=white" alt="Selenium"/>
  <img src="https://img.shields.io/badge/TestNg-FF7F00?style=for-the-badge&logo=testng&logoColor=white" alt="TestNG"/>
  <img src="https://img.shields.io/badge/Maven-C71A22?style=for-the-badge&logo=apachemaven&logoColor=white" alt="Maven"/>
  <img src="https://img.shields.io/badge/Allure_Report-FFCE54?style=for-the-badge&logo=qa1&logoColor=black" alt="Allure"/>
</div>

## 📝 Overview
This repository contains a robust **Automated Testing Framework** built from scratch to test the core UI flows of the E-commerce web application [Automation Exercise](https://automationexercise.com/). 

The framework is designed to ensure application stability, enhance code reusability, and maintainability using industry-standard design patterns.

## 🏗️ Architecture & Design Patterns
- **Page Object Model (POM):** Separates the test logic from the UI element locators. This ensures that any changes in the UI only require updates in the corresponding Page class, not in the test scripts.
- **Data-Driven Approach:** Utilizing POJO models (e.g., `User.java`, `ContactUs.java`) to handle test data effectively.

## 🛠️ Tech Stack
- **Programming Language:** Java (JDK 11+)
- **Automation Tool:** Selenium WebDriver
- **Testing Framework:** TestNG
- **Build Tool:** Apache Maven
- **Reporting:** Allure Report (integrated with AspectJ Weaver for comprehensive and interactive test execution reports)

## 📂 Project Structure
```text
src/
 ├── test/
 │    ├── java/
 │    │    ├── bases/         # BaseTest configurations (WebDriver setup, teardown)
 │    │    ├── models/        # POJO classes for Data holding (User, ContactUs)
 │    │    ├── pages/         # Page Object classes (Locators and Actions)
 │    │    └── testCases/     # TestNG Test classes containing test assertions
 │    └── resources/          # Test data, configuration files, XML runners
 ├── pom.xml                  # Maven dependencies and build configurations
 └── testng.xml               # TestNG suite runner file
```

## 🚀 Getting Started

### Prerequisites
Make sure you have the following installed on your machine:
- [Java Development Kit (JDK) 11 or higher](https://www.oracle.com/java/technologies/downloads/)
- [Apache Maven](https://maven.apache.org/download.cgi)
- IDE (IntelliJ IDEA, Eclipse, or VS Code)
- Google Chrome or Firefox browser

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/hnhung31/SELENIUM_AUTOMATION.git
   ```
2. Navigate to the project directory:
   ```bash
   cd SELENIUM_AUTOMATION
   ```
3. Install dependencies using Maven:
   ```bash
   mvn clean install
   ```

## ⚙️ Execution

### Run Tests
To execute the test suite, run the following command in your terminal:
```bash
mvn clean test
```
*Alternatively, you can run tests directly via the `testng.xml` file using your IDE.*

## 📊 Reporting
This project uses **Allure Report** to generate beautiful, interactive test reports.

1. After running the tests, Allure results will be stored in the `allure-results` folder.
2. To generate and open the HTML report in your default browser, run:
   ```bash
   mvn allure:serve
   ```

## 💡 Key Highlights for Recruitment
- Developed automated test cases for various core modules including Authentication, Cart, Checkout, and Product catalogs.
- Efficient handling of Synchronization issues using Explicit Waits.
- Clean code architecture with strict separation of concerns (Asserts are strictly kept in the Test classes, not in the Page classes).
