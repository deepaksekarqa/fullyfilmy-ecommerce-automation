# 🎬 FullyFilmy – E-Commerce Automation Testing

![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square&logo=java)
![Selenium](https://img.shields.io/badge/Selenium-4.18.1-green?style=flat-square&logo=selenium)
![TestNG](https://img.shields.io/badge/TestNG-7.11.0-red?style=flat-square)
![Maven](https://img.shields.io/badge/Maven-3.x-blue?style=flat-square&logo=apachemaven)
![Status](https://img.shields.io/badge/Tests-5%2F5%20Passed-brightgreen?style=flat-square)

---

## 📌 Project Overview

End-to-end **Selenium automation framework** for FullyFilmy — a Shopify-based movie merchandise e-commerce store.  
This project demonstrates **multi-path product navigation** (category, dropdown, search), **dynamic parameterised page methods**, and production-grade **WaitHelper** architecture on a real live Indian e-commerce website.

**Application Under Test:** https://fullyfilmy.in/

---

## 🎯 Test Cases Covered

| # | Test Method | Description | Result |
|---|------------|-------------|--------|
| 1 | verifyHomepage | Verify URL and logo visibility | ✅ PASSED |
| 2 | addOversizedTshirt | Add product via category navigation | ✅ PASSED |
| 3 | addFullSleeveTshirt | Add product via Shop dropdown | ✅ PASSED |
| 4 | addMetalPoster | Add product via search + increase qty + view cart | ✅ PASSED |
| 5 | cartOperations | Remove all products + verify homepage | ✅ PASSED |

**Total: 5/5 Passed — 0 Failures — 0 Skips**

---

## 🛠️ Tech Stack

| Technology | Version | Purpose |
|-----------|---------|---------|
| Java | 17 | Programming language |
| Selenium WebDriver | 4.18.1 | Browser automation |
| TestNG | 7.11.0 | Test framework |
| Maven | 3.x | Build tool and dependency management |
| WebDriverManager | 5.7.0 | Automatic ChromeDriver management |
| Commons IO | 2.15.1 | Utility support |

---

## 📁 Project Structure

```
fullyfilmyautomation/
├── src/
│   ├── main/java/
│   │   ├── base/
│   │   │   └── BaseClass.java          ← static WebDriver + WebDriverWait
│   │   ├── pages/
│   │   │   ├── HomePage.java           ← URL and logo verification
│   │   │   ├── ProductPage.java        ← All product browsing and cart methods
│   │   │   └── CartPage.java           ← Cart operations and homepage nav
│   │   └── utils/
│   │       └── WaitHelper.java         ← Explicit Wait utility class
│   └── test/java/
│       └── tests/
│           └── TestRun.java            ← 5 @Test methods
├── pom.xml
└── testng.xml
```

---

## ⚙️ Prerequisites

- Java 17 or higher installed
- Maven 3.x installed
- Google Chrome browser installed

---

## 🚀 How to Run

### Option 1 — Run from Eclipse IDE

1. Clone this repository
   ```bash
   git clone https://github.com/deepaksekarqa/fullyfilmy-ecommerce-automation.git
   ```
2. Open Eclipse → **File → Import → Maven → Existing Maven Project**
3. Right click `testng.xml` → **Run As → TestNG Suite**

### Option 2 — Run from Command Line (Maven)

```bash
git clone https://github.com/deepaksekarqa/fullyfilmy-ecommerce-automation.git
cd fullyfilmy-ecommerce-automation
mvn test
```

---

## 📊 Test Results

```
===============================================
FullyFilmy Test Suite
Total tests run: 5, Passes: 5, Failures: 0, Skips: 0
===============================================
```

---

## 🔑 Key Implementation Highlights

- **Dynamic parameterised methods** — single `selectProduct(String productName)` handles product selection across collection pages AND search results — no duplicate methods
- **Single removeProduct()** — always clicks `(//a[@data-cart-remove])[1]` — logs product name for traceability
- **3 product navigation paths** — category link, Shop dropdown hover + collection select, search icon + type + click result
- **JavascriptExecutor click** — used for View Cart button to bypass Shopify overlay intercepts
- **WaitHelper lazy initializer** — `getWaitHelper()` creates instance only on first call — prevents NullPointerException from static driver not being set at field init time
- **Manual verification** — discovered search panel has no category dropdown before scripting — corrected execution plan accordingly

---

## ⚠️ Site Challenges Handled

| Challenge | Solution Applied |
|-----------|----------------|
| Shopify dynamic elements | Explicit Waits (WebDriverWait) throughout |
| Search — no category dropdown | Typed product name directly, waited for result, clicked |
| View Cart overlay intercept | JavascriptExecutor jsClick() |
| Multi-step cart removal | Always clicks first `data-cart-remove` button with sleep for Shopify re-render |

---

## ⚠️ Important Notes

- No personal credentials or payment data is used — site is browsed as a guest
- Thread.sleep used only for Shopify collection/product page load transitions — not as general wait strategy
- SLF4J and CDP warnings in console are harmless

---

## 👨‍💻 Author

**Deepak S** — QA Engineer (Automation & Manual Testing)  
📍 Chennai, India  
🔗 [LinkedIn](https://www.linkedin.com/in/deepaksekar7/) | [GitHub](https://github.com/deepaksekarqa)

---

