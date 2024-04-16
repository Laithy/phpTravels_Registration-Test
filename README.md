# Travel Website Registration Automation with Selenium (Java)
This project provides a comprehensive and user-friendly automation framework for testing the registration process of a travel website using Selenium with Java.

### Key Features:

- **Automated Registration Testing:** Efficiently tests all registration steps (excluding reCaptcha) for a streamlined testing experience.

- **Enhanced Clarity:** Leverages the Page Object Model (POM) design pattern for well-structured and easily readable code.

- **Behavior-Driven Development (BDD):** Utilizes Cucumber to create readily understandable test cases, even for non-technical stakeholders.

- **Reusable Parameters:** Enhances code reusability across diverse test scenarios through parameterized feature files.

- **Robust Assertions:** Employs TestNG for robust assertions, ensuring expected behavior aligns with actual results.

- **Detailed Reporting with Screenshots:** Generates comprehensive reports with the Cucumber reporter plugin, including statistics, test run details, and screenshots of failed scenarios for clear analysis. This addresses the limitation of native Cucumber reports in capturing screenshots.

### Test Automation Scope

The code automates the entire registration process except for one step: reCAPTCHA verification. Due to the unreliability of external CAPTCHA-solving services and the common practice of disabling them in production, this step is left for manual testing.

### Test Reporting

#### **Cucumber reporter plugin generates reports after each run, including**
- Test run statistics
- Data about the run
- Screenshots of failed scenarios (not supported by native Cucumber reporting)

### Test Design

I have designed some test cases for this feature to ensure its quality and compliance with the requirements provided, and I have implemented three of them in the test script for the sake of demonstration, the rest of the test cases can be found here: https://docs.google.com/spreadsheets/d/1S4TKAYfu1QqzJsGzWqt-_QrWh-FX_CKAa-pwSxdVAWk/edit?usp=sharing
