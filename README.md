# 🧪 Selenium SauceDemo Automation Framework

A **Java + Selenium + TestNG** automation framework built using the **Page Object Model (POM)** to automate the **SauceDemo (Swag Labs)** application.

This project demonstrates **real-world automation framework design**, including login, add-to-cart, cart validation, and a complete **end-to-end checkout flow**.

---

## 🚀 Tech Stack

- Java  
- Selenium WebDriver  
- TestNG  
- Maven  
- ChromeDriver  
- Page Object Model (POM)  
- Git & GitHub  

---

## 📁 Project Structure

```
OpenCartProject
│
├── src
│ └── test
│ └── java
│ ├── base
│ │ └── BaseTest.java
│ │
│ ├── pages
│ │ ├── LoginPage.java
│ │ ├── ProductsPage.java
│ │ ├── CartPage.java
│ │ └── CheckoutPage.java
│ │
│ ├── tests
│ │ ├── LoginTest.java
│ │ ├── ProductsPageTest.java
│ │ ├── CartPageTest.java
│ │ ├── AddToCartTest.java
│ │ └── CheckoutTest.java
│ │
│ └── utils
│ └── DemoWait.java
│
├── pom.xml
├── .gitignore
└── README.md
```


---

## 🧩 Page Objects Implemented

- **LoginPage** – Handles login actions and validations  
- **ProductsPage** – Product listing, add-to-cart actions  
- **CartPage** – Cart validations and navigation  
- **CheckoutPage** – Checkout form, overview, and order confirmation  

📌 Each page:
- Encapsulates locators and actions
- Uses **explicit waits**
- Contains **no assertions**

---

## 🧪 Test Coverage

### ✅ Login Tests
- Valid login
- Locked-out user validation
- Invalid credentials validation

### ✅ Products Page Tests
- Products page display validation
- Product count verification
- Cart icon navigation

### ✅ Cart Tests
- Cart page validation
- Empty cart verification
- Continue shopping navigation

### ✅ Add To Cart Flow
- Add product to cart
- Cart badge count validation
- Cart item verification

### ✅ End-to-End Checkout Flow

Login → Add to Cart → Cart → Checkout → Finish → Order Confirmation


---

## 🕒 Demo Mode (Slow Execution)

For learning and visual verification, the framework includes **controlled demo delays** using a utility class.

- Helps beginners visually track each step
- Can be easily removed for production or CI runs

> ⚠️ Demo delays are used **only for learning purposes**.

---

## 🛡️ Browser Popup Handling

Chrome password manager and password breach warnings are **disabled using ChromeOptions preferences**, ensuring:

- No browser-level interruptions
- Stable and reliable automation execution

---

## ▶️ How to Run the Tests

### 1️⃣ Clone the Repository
```
git clone https://github.com/<SivaJaswanthKonijeti>/selenium-saucedemo-automation.git

```

### 2️⃣ Navigate to Project Directory
```
cd selenium-saucedemo-automation

```

### 3️⃣ Run All Tests
```
mvn test

```

### 🔑 SauceDemo Test Credentials
* Username: standard_user
* Password: secret_sauce
