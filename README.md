# Custom Testing Framework for Orange HRM Demo

![Cucumber](https://img.shields.io/badge/Cucumber-23D96C?style=for-the-badge&logo=cucumber&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-43B02A?style=for-the-badge&logo=selenium&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-FF7300?style=for-the-badge&logo=testng&logoColor=white)
![JDBC](https://img.shields.io/badge/JDBC-00758F?style=for-the-badge&logo=java&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![Apache POI](https://img.shields.io/badge/Apache%20POI-231F20?style=for-the-badge&logo=apache&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)

Overview

This project is a custom-built testing framework using Maven structure, designed for automated testing of the Orange HRM Demo site. The framework supports both UI and database smoke and regression tests, and includes the following features:

## Dependencies

The following dependencies are required for the project to work. These dependencies are added in the `pom.xml` file:


 - **Selenium**: Used for UI test automation.
 - **Cucumber**: Used for behavior-driven development (BDD).
 - **TestNG**: Used for organizing and running tests.
 - **Cucumber TestNG**: Integrates Cucumber with TestNG.
 - **SLF4J API**: Logging framework.
 - **SLF4J Simple**: Simple logging implementation for SLF4J.
 - **Apache Commons Lang**: Utility library for Java.
 - **Extent Reports Cucumber Adapter**: Integrates Extent Reports with Cucumber.
 - **Apache POI**: Library for reading and writing Excel files.
 - **MySQL Connector**: JDBC driver for MySQL.

## Reporting
Detailed and visually appealing Basic and Extent Reports, enhanced with optional screenshots for better clarity and understanding of test outcomes. Reports can be generated as PDF files or viewed in the browser via spark.html.


## Parallel Testing

To run tests in parallel using TestNG XML files, you can use the provided `ParallelTest.xml` file.
Follow these steps to enable parallel execution:

1. **Use the `ParallelTest.xml` file**:
    - Open the `ParallelTest.xml` file located in the `src/test/XML` directory.
      - Ensure the suite tag includes `parallel` and `thread-count` attributes. For example:
        ```xml
        <!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
        <suite name="All Test Suite" parallel="tests" thread-count="2">
        <test name="test1">
            <parameter name="browserType" value="BrowserName"></parameter>
                <classes>
                <class name="Runners.testName"></class>
                </classes>
            </test>
            
        <test name="test2">
            <parameter name="browserType" value="BrowserName"></parameter>
                <classes>
                <class name="Runners.testName"></class>
                </classes>

            </test>
        </suite>
        ```

2. **Run the tests**:
    - In IntelliJ IDEA, right-click on the `ParallelTest.xml` file and select `Run 'ParallelTest.xml'`.
    - This will execute the tests defined in the XML file in parallel, according to the configuration.




### Key Benefits

- **Seamless Integration**: Easily integrate UI and DB tests in a single framework.
- **Behavior-Driven Development**: Use Gherkin syntax to define test scenarios in a human-readable format.
- **Cross-Browser Support**: Test your application across multiple browsers to ensure compatibility.
- **Detailed Reporting**: Generate comprehensive test reports to quickly identify and fix issues. Reports are produced in both HTML and PDF formats and may include screenshots.
- **Parameterized Testing**: Use data tables for running tests with multiple sets of data.
- **Easy Configuration**: Simple configuration for different environments and databases.
- **Apache POI Integration**: Read and write Excel files using Apache POI.
- **Page Object Model (POM)**: Improve test maintenance and readability by using the Page Object Model design pattern.

### Application Under Test

This custom-built framework is currently used to test the [OrangeHRM](https://opensource-demo.orangehrmlive.com/web/index.php/auth/login) application. OrangeHRM is a comprehensive solution that requires thorough testing to ensure its reliability and performance.

## Folder Structure

```
CucumberPractice/
│
├──.idea/                      # IntelliJ IDEA configuration files
├── Config                      #Config file for UserId Password and Url
├── src/
│   ├── main/                   # Main source code
│   └── test/                   # Test source code
│       ├── java/
│       │   ├── _JDBC/              #JDBC related files
│       │   ├── ApachePOI/          # Apache POI
│       │   ├── FeatureFiles/       # Gherkin feature files
│       │   ├── Pages/              # Page Object Model files
│       │   ├── Runners/            # TestNG runner classes
│       │   ├── StepDefinitions/    # Cucumber step definitions
│       │   ├── Utilities/          # Utility classes and helpers
│       │   
│       ├──resources/
│       │  ├── cucumber.properties  # Cucumber configuration files
│       │  └── extent.properties    # Extent reporting configuration files
│       └── XML/                    # XML configuration files
│ 
├── target/                     # Maven build output
├── test-output/                # TestNG and Extent reports
├── testReports/                # Custom test reports
├── .gitignore                  # Git ignore file
├── pom.xml                     # Maven configuration file
└── README.md                   # Project README file
```

## Contact

For questions or issues, please open an issue in this repository.

---

