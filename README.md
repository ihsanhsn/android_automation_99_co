# Android Automation Project

This repository hosts the Android automation testing code using Appium and Java with TestNG.

## Prerequisites

Before you can run these tests, you need to have the following installed on your machine:
- Java JDK (version 8 or newer)
- Android SDK & ADB
- Appium Server (can be installed via npm)
- Node.js (for npm)
- Any IDE (like IntelliJ IDEA or Eclipse)
- An Android emulator or real device set up for testing

## Project Structure

The structure of this project is outlined as follows:

```plaintext
android_automation_99_co/
├── .idea/                       # IDE configuration files
├── src/
│   ├── app/
│   │   └── android_wdio.apk     # The APK file for the Android application
│   ├── main/
│   │   └── java/
│   │       └── org/
│   │           └── example/
│   │               └── App.java # Main application code (not related to testing)
│   ├── test/
│   │   └── java/
│   │       └── com/
│   │           └── company/
│   │               └── app/
│   │                   └── test/
│   │                       ├── BaseTest.java   # Base setup for Appium tests
│   │                       ├── LoginTest.java  # Test scenarios for login functionality
│   │                       └── FormsTest.java  # Test scenarios for forms handling
├── .gitignore                   # Specifies intentionally untracked files to ignore
├── pom.xml                      # Maven project configuration file
└── README.md                    # Project documentation
```

## How to run the test

1. Open terminal
2. Cd to directory project android_automation_99_co
3. Type this command to run all automation

```sh
   mvn test
```
4. Type this command to run by test suite or class

```sh
   mvn test -Dtest=class_name #example: LoginTest
```

## Automation Results

- Login Test
  <img width="954" alt="LoginTest" src="https://github.com/ihsanhsn/android_automation_99_co/assets/8023900/f05bc99c-8148-4823-9b0c-2364739fe74a">

- Forms Test
  <img width="947" alt="FormsTest" src="https://github.com/ihsanhsn/android_automation_99_co/assets/8023900/0166b8b8-0a6f-4668-a7d2-97b3e1b52ecb">
