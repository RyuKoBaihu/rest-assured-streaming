# 🎬 Rest Assured Streaming - Automated API Testing Framework

This project demonstrates how to validate **video streaming APIs** (e.g., YouTube, AWS S3, EC2 endpoints) using **Java + Rest Assured + Cucumber**.  
It showcases a **scalable, maintainable, and recruiter-friendly framework** designed to highlight strong **SDET / QA Automation Engineering** skills.

---

## ✨ Highlights

- ✅ **API Testing with Rest Assured** – clean, fluent, and reliable test design.
- ✅ **Cucumber BDD** – business-readable scenarios for collaboration across QA, Dev, and Product.
- ✅ **Streaming Validation** – examples for video metadata, ads insertion, and quality checks.
- ✅ **Scalable Design** – reusable utilities, modular architecture, and CI/CD-ready.
- ✅ **Best Practices** – clean code, logging, assertions, environment config, and reporting.

---

## 📂 Project Structure

## 📂 Project Structure

```bash
rest-assured-streaming/
├── .github/
│   └── workflows/
│       └── ci.yml                # GitHub Actions workflow (CI/CD)
│
├── src/
│   └── test/java/
│       ├── features/             # Cucumber feature files (BDD scenarios)
│       │   └── video_streaming.feature
│       ├── steps/                # Step Definitions (glue code)
│       │   └── VideoSteps.java
│       ├── runners/              # Cucumber/JUnit runners
│       │   └── TestRunner.java
│       └── utils/                # Utility classes (Config, Helpers, etc.)
│           └── Config.java
│
├── src/test/resources/
│   └── application.properties    # API keys, base URI, video ID (not versioned)
│
├── pom.xml                       # Maven dependencies (Rest Assured, Cucumber, JUnit)
└── README.md

---

## 🚀 Getting Started

### Prerequisites
- **Java 17+**
- **Maven 3.9+**
- Internet access (to hit YouTube/streaming APIs)

### Installation
```bash
git clone https://github.com/RyuKoBaihu/rest-assured-streaming.git
cd rest-assured-streaming
mvn clean install