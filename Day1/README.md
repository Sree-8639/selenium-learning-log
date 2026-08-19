# Selenium – Day 1

## Table of Contents
1. [What is Selenium](#1-what-is-selenium)
2. [Selenium — Supported Languages, OS, Browsers](#2-selenium--supported-languages-os-browsers)
3. [Selenium Components](#3-selenium-components)
4. [Selenium WebDriver](#4-selenium-webdriver)
5. [WebDriver Implementation](#5-webdriver-implementation)
6. [What is API](#6-what-is-api)
7. [What is a Protocol](#7-what-is-a-protocol)
8. [Environment Setup](#8-environment-setup)
9. [Test Case 1 — First Selenium Test](#9-test-case-1--first-selenium-test)
10. [Assignment Tasks](#10-assignment-tasks)

---

## 1. What is Selenium
Selenium is an open-source tool/framework used for **automating web applications** for testing purposes. It allows testers to write scripts that interact with a web browser (click, type, navigate, validate) just like a real user would, instead of doing it manually.

## 2. Selenium — Supported Languages, OS, Browsers
- **Languages**: C#, Java, JavaScript, Python, Ruby
- **Operating Systems**: Windows, macOS, Linux
- **Browsers**: Firefox, Internet Explorer, Safari, Opera, Chrome, Edge

## 3. Selenium Components
Selenium consists of 3 components:
- **Selenium IDE**
- **Selenium WebDriver**
- **Selenium GRID**

## 4. Selenium WebDriver
- Used for automation of web applications.
- It is a **Java interface**.
- It is an **API**.

### What is an Interface?
**Interface**: a blueprint of a class containing public/static variables, default methods, public and abstract methods. An interface **must** be implemented through a class.

## 5. WebDriver Implementation
WebDriver interface is implemented through multiple classes: `ChromeDriver`, `InternetExplorerDriver`, `FirefoxDriver`, etc.

- `ChromeDriver`, `InternetExplorerDriver`, and `FirefoxDriver` are different classes, each with their own implementation of the WebDriver methods — because Chrome, Internet Explorer, and Firefox browsers each have a different internal architecture. So the same WebDriver method may behave/be implemented differently depending on which driver class is used.
- WebDriver is **not directly implemented** by these classes — in between there's a `RemoteWebDriver` class.

```
WebDriver (Interface) ---> RemoteWebDriver (Class) --extends--> ChromeDriver, EdgeDriver, FirefoxDriver
                                                        (Child classes for RemoteWebDriver / WebDriver)
```
- WebDriver variables can hold objects of any of these child classes.
- WebDriver is never used directly; it only defines the method blueprint (like `get()`, `findElement()`), and these methods are actually implemented by classes such as `ChromeDriver`, `FirefoxDriver`, and `InternetExplorerDriver` (via `RemoteWebDriver`). Since it must be implemented through a class to actually work, **therefore WebDriver is an interface**.

## 6. What is API
- **API** = Application Programming Interface.
- API contains business logic and acts as an interface / assistive layer to an application:
```
Front End (Presentation Layer) <--response-- Application Layer (Business Layer) <--response-- DB Layer (Backend)
Front End --request--> Application Layer --request--> DB Layer
```
- A request is sent → automatically triggers the API → API sends request to DB layer → DB layer returns response → response goes back to API → API sends it to frontend layer.
```
Java Program --calling--> WebDriver Methods --performing--> Browser
```
- WebDriver is an **API** because it works as an interface between client and browser:
```
Client ---> WebDriver ---> Browser
```
- Abstract methods are implemented through RemoteWebDriver.
- Methods aren't different across browsers, but implementation differs due to architecture.

## 7. What is a Protocol
A **protocol** is a set of rules that defines how two systems communicate with each other — in this case, how WebDriver methods talk to the browser to send commands and get responses.

### JSON Wire Protocol vs W3C WebDriver Protocol

| Point | JSON Wire Protocol (Old) | W3C WebDriver Protocol (New) |
|---|---|---|
| Used in | Selenium 2 and below | Selenium 4 and above |
| Standard | Not a W3C standard (vendor-specific) | Official W3C standard |
| Consistency | No consistency across tools | Consistent across all tools and languages |
| Browser support | Limited, architecture differences caused issues | Better browser compatibility |
| Features | Limited commands and features | Supports modern web features |
| Maintenance | Hard to maintain, not future-proof | Easier maintenance, future-proof |
| Interoperability | Poor interoperability across tools/platforms | Interoperable with tools like Appium, Cypress, etc. |
| Format | JSON over HTTP | HTTP + JSON (W3C combines both) |
| Example command | `{ "sessionId": "abc123", "command": "GET", "url": "/session/abc123/url", "parameters": { "url": "https://example.com" } }` | `{ "sessionId": "abc123", "capabilities": { "alwaysMatch": { "browserName": "chrome" } }, "commands": [ { "method": "GET", "url": "https://example.com" } ] }` |

---

## 8. Environment Setup

### Method 1: Manual Process
1. Download Eclipse, install and open it.
2. Create a Workspace and a Java Project.
3. Download WebDriver JARs (`.zip`) and extract them.
   > **.jar file** = Java Archiving file — consists of a bulk amount of classes and interfaces.
4. Attach JARs to the Java project:
   - Right-click project folder → **Properties**
   - **Java Build Path** → **Libraries** → **Classpath**
   - **Add External JARs** → select JAR files → **Apply and Close**
5. A new folder called **"Referenced Libraries"** will appear.
6. If a new version is released: delete old JARs, download new version JARs, repeat the attach process.

### Method 2: Creation through Maven Project (Recommended)
Maven is a **build tool**.

1. Create a Maven project:
   - ☑ Create a simple project
   - ☑ Use default workspace location
   - Next → Group Id: `seleniumwebdriver`, Artifact Id: `seleniumwebdriver` → Finish

2. Default packages created:
   | Folder | Purpose |
   |---|---|
   | `src/main/java` | Java code files |
   | `src/main/resources` | Upload excel/other files (used by developers; optional, can be deleted) |
   | `src/test/java` | Used by testers for testing |
   | `src/test/resources` | Used by testers for testing |

3. **pom.xml** — important file used to add dependency versions and automate JAR downloads.
   - Open `pom.xml`
   - Inside `<project>` tag, add a `<dependencies>` tag
   - Go to [mvnrepository.com](https://mvnrepository.com)
   - Search "selenium java" → open the first result → select version → choose **Maven** tab → copy the dependency code → paste it inside `<dependencies>` tag → Save → Update

4. **Updating the project**:
   - Right-click project folder → **Maven** → **Update**
   - Check ☑ **Force Update** → OK
   - Do this every time `pom.xml` is changed.
   - When a new version is needed, just change the version number in `pom.xml` and update — it auto-deletes old JAR and downloads new one.

---

## 9. Test Case 1 — First Selenium Test

**Setup:**
- In `src/test/java` → create a package: Right-click project → New → Package → Name: `Day1` → Finish
- Inside that package → create a class: Right-click → New → Class → Name: `FirstTestCase`
  - ☑ public
  - ☑ public static void main
  - ☑ Inherited abstract methods
  - Finish

**Test Case Requirements:**
1. Launch browser (Chrome)
2. Open URL: `https://www.saucedemo.com/`
3. Validate title should be **"Swag Labs"**
4. Close browser

---

## 10. Assignment Tasks

Same as Test Case 1, but with a different URL:

1. Launch browser (Chrome)
2. Open URL: `https://demowebshop.tricentis.com/`
3. Validate title should be **"Demo Web Shop"**
4. Close browser
