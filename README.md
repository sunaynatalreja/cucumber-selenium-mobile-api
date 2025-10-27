# cucumber-selenium-mobile-api

## Overview  
A test automation framework combining UI (web), mobile (Appium) and API testing using Cucumber & Selenium. Built for scalable BDD automation across platforms.

## Key Features  
- Cucumber BDD feature-files and step definitions.  
- UI automation via Selenium WebDriver.  
- Mobile automation support via Appium.  
- API testing via REST clients.  
- Parallel execution & reporting (e.g., extent/allure).  
- Configurable for multiple environments and device platforms.

## Project Structure  
```txt
cucumber-selenium-mobile-api/
├── src/
│ ├── main/java/ # framework core classes
│ ├── test/java/ # test runners, step definitions
│ └── resources/ # feature files, config files
├── pom.xml # Maven build file
└── README.md
```
Using my [framworkutil](https://github.com/sunaynatalreja/frameworkutil) dependency, a demo framework to show web,api, mobile automation

## Prerequisites  
- Java 11+  
- Maven 3.8+  
- Appium server (for mobile tests)  
- Correct WebDriver binaries & device/emulator setup for mobile

## Build & Run  
```bash
# Clone repository
git clone https://github.com/sunaynatalreja/cucumber-selenium-mobile-api.git
cd cucumber-selenium-mobile-api
```

# Build
mvn clean install

# Run all tests
mvn test

## Usage

- Modify the config (e.g., src/resources/config.properties) to set browser, mobile device, environment.
- Feature files define BDD scenarios; step definitions map to automation tasks.
- Use Maven profiles or parameters to switch between web, mobile or API test suites.
- Test reports are generated in target/ directory.

## Contributing

Contributions are welcome.

Fork the repository

Create a feature branch (git checkout -b feature/your-feature)

Commit and push (git push origin feature/your-feature)

Open a Pull Request for review

## License

This project is licensed under the MIT License. See the LICENSE file for details.
MIT License

Copyright (c) 2025 Sunayna Talreja

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

