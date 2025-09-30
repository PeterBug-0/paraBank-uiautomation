# ParaBank Test Automation Framework

A Selenium-based test automation framework for ParaBank application using Java, TestNG, and Page Object Model (POM) design pattern.

## 🎯 Project Overview

This framework automates testing of the ParaBank demo banking application, covering user registration and login functionalities with data-driven testing capabilities.

**Application Under Test:** [ParaBank](https://parabank.parasoft.com/parabank/index.htm)

## 🏗️ Framework Architecture

```
src/
├── main/java/com/automation/
│   ├── base/
│   │   ├── BasePage.java          # Base page with reusable methods
│   │   └── BaseTest.java          # Base test setup and teardown
│   ├── pages/
│   │   ├── LoginPage.java         # Login page objects and actions
│   │   └── RegisterPage.java      # Registration page objects and actions
│   └── utils/
│       ├── ConfigReader.java      # Properties file reader utility
│       ├── ConfigManager.java     # Centralized config management
│       └── DriverManager.java     # WebDriver lifecycle management
└── test/
    ├── java/com/automation/tests/
    │   ├── LoginTest.java         # Login test scenarios
    │   └── RegisterTest.java      # Registration test scenarios
    └── resources/
        ├── config.properties      # Application configuration
        ├── locators.properties    # Element locators
        └── testdata.properties    # Test data
```

## 🚀 Features

- **Page Object Model (POM)** - Organized and maintainable page objects
- **Data-Driven Testing** - Externalized test data in properties files
- **Centralized Configuration** - All configs managed through ConfigManager
- **Cross-Browser Support** - Chrome, Firefox, Edge (via TestNG parameters)
- **Reusable Components** - BasePage with common Selenium operations
- **WebDriver Management** - Thread-safe driver handling with DriverManager
- **TestNG Integration** - Parallel execution and detailed reporting

## 📋 Prerequisites

- Java JDK 11 or higher
- Maven 3.6+
- Chrome/Firefox/Edge browser
- IDE (IntelliJ IDEA/Eclipse)

## 🔧 Setup Instructions

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd parabank-automation
   ```

2. **Install dependencies**
   ```bash
   mvn clean install
   ```

3. **Configure test data**
   
   Update `src/test/resources/testdata.properties` with your test data:
   ```properties
   firstname=John
   lastname=Doe
   username=johndoe123
   password=Test@123
   ```

4. **Run tests**
   ```bash
   # Run all tests
   mvn test
   
   # Run specific test class
   mvn test -Dtest=LoginTest
   
   # Run with specific browser
   mvn test -Dbrowser=firefox
   ```

## 📂 Configuration Files

### config.properties
```properties
base.url=https://parabank.parasoft.com/parabank/index.htm
browser=chrome
implicit.wait=10
explicit.wait=20
```

### locators.properties
Contains all web element locators:
- Registration form fields
- Login form fields
- Buttons and links

### testdata.properties
Contains test data for:
- User registration details
- Valid/invalid login credentials

## 🧪 Test Scenarios

### LoginTest
- ✅ Successful login with valid credentials
- ✅ Failed login with invalid credentials
- ✅ Login with empty username
- ✅ Login with empty password

### RegisterTest
- ✅ Successful user registration
- ✅ Registration with default test data
- ✅ Registration with custom data

## 📊 Key Components

### ConfigManager
Centralized configuration management that loads all properties files once and provides easy access:
```java
String url = ConfigManager.getConfigProperty("base.url");
String locator = ConfigManager.getLocator("login.username.name");
String testData = ConfigManager.getTestData("valid.username");
```

### DriverManager
Thread-safe WebDriver management with singleton pattern:
```java
DriverManager.initializeDriver("chrome");
WebDriver driver = DriverManager.getDriver();
DriverManager.quitDriver();
```

### BasePage
Reusable Selenium operations:
- `click(By locator)` - Click element
- `type(By locator, String text)` - Enter text
- `getText(By locator)` - Get element text
- `waitForElement(By locator)` - Explicit wait

## 🎨 Design Patterns Used

1. **Page Object Model (POM)** - Separation of page logic and test logic
2. **Singleton Pattern** - WebDriver instance management
3. **Factory Pattern** - Browser initialization
4. **Builder Pattern** - Test data construction

## 📈 Running Tests

### Via Maven
```bash
mvn clean test
```

### Via TestNG XML
Create `testng.xml`:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="ParaBank Test Suite">
    <test name="Login Tests">
        <parameter name="browser" value="chrome"/>
        <classes>
            <class name="com.automation.tests.LoginTest"/>
        </classes>
    </test>
</suite>
```

Run: `mvn test -DsuiteXmlFile=testng.xml`

### Via IDE
Right-click on test class → Run as TestNG Test

## 📝 Test Reports

TestNG generates detailed HTML reports at:
```
target/surefire-reports/index.html
```

## 🔍 Troubleshooting

### Common Issues

1. **"Cannot find elements when id is null"**
   - Ensure properties files are in correct location
   - Verify ConfigManager is loading properties correctly

2. **"Parameter 'browser' is required"**
   - Add `@Optional("chrome")` to setUp method
   - Or provide browser parameter in testng.xml

3. **WebDriver not found**
   - Download appropriate WebDriver executable
   - Or use WebDriverManager dependency

## 🤝 Contributing

1. Fork the repository
2. Create feature branch (`git checkout -b feature/new-feature`)
3. Commit changes (`git commit -m 'Add new feature'`)
4. Push to branch (`git push origin feature/new-feature`)
5. Open Pull Request

## 📄 License

This project is licensed under the MIT License.

## 👨‍💻 Author

Your Name - [Your GitHub Profile]

## 📞 Support

For issues or questions, please create an issue in the repository.

---

**Happy Testing! 🚀**
