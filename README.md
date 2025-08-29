
# End to End Testing of Demo E-Commerce Website

This project contains end-to-end (E2E) automation tests for a demo e-commerce application (Rahul Shetty Academy Client App
).The tests are implemented in Java using Selenium WebDriver with TestNG, simulating real user actions such as login, product selection, checkout, and payment.

Tech Stack

Language: Java (JDK 8 or higher)

Automation Framework: Selenium WebDriver

Test Runner: TestNG

Browser: Microsoft Edge (via EdgeDriver)

## Test Scenarios Covered
The test suite validates the following user journeys:
1.	Login
User logs in with valid credentials.

2.	Product Selection
Browse product dashboard.

Identify and select IPHONE 13 PRO.

Add the product to the cart.

3.	Checkout
Navigate to cart.

Proceed with checkout.

4.	Payment & Order Confirmation
Enter CVV and select country.

Place an order.

Verify Thank You message and retrieve Order ID.

5.	Logout
User signs out successfully.






## Getting Started
1. Prerequisites

Make sure you have the following installed:

Java JDK (8 or above)

Maven (for dependency management)

Microsoft Edge Browser

Edge WebDriver (matching your browser version)

## 📂 Source Code
The complete source code is available here: [Rolex Repository](https://github.com/Rangeeshbala/Rolex/blob/master/src/test/java/project/E2E.java)
