# 🗂️ What's Where - Simple Explanation

## 📍 Your Current Project Structure

```
demo/                                    ← Root folder
│
├── 📄 pom.xml                           ← Parent POM (manages all services)
│
├── 📁 src/                              ← YOUR OLD CODE (keep it!)
│   └── main/java/com/example/demo/
│       ├── model/
│       │   ├── User.java                ← Will move to customer-service
│       │   ├── Account.java             ← Will move to account-service
│       │   └── Transaction.java         ← Will move to transaction-service
│       ├── repository/
│       ├── controller/
│       └── Service/
│
├── 📁 config-server/                    ← EMPTY! Just pom.xml
│   └── pom.xml                          ← No code yet
│
├── 📁 eureka-server/                    ← EMPTY! Just pom.xml
│   └── pom.xml                          ← No code yet
│
├── 📁 api-gateway/                      ← EMPTY! Just pom.xml
│   └── pom.xml                          ← No code yet
│
├── 📁 customer-service/                 ← EMPTY! Just pom.xml
│   └── pom.xml                          ← Will get User.java later
│
├── 📁 account-service/                  ← EMPTY! Just pom.xml
│   └── pom.xml                          ← Will get Account.java later
│
├── 📁 transaction-service/              ← EMPTY! Just pom.xml
│   └── pom.xml                          ← Will get Transaction.java later
│
├── 📁 notification-service/             ← EMPTY! Just pom.xml
│   └── pom.xml                          ← No code yet
│
└── 📁 common-module/                    ← EMPTY! Just pom.xml
    └── pom.xml                          ← No code yet
```

---

## ❓ Your Questions Answered

### Q1: "What's inside account-service?"
**A:** Almost NOTHING! Just:
- `pom.xml` (empty module config)
- `target/` folder (Maven build output, ignore it)

**NO CODE YET!** We only created the folder structure.

---

### Q2: "Why do I keep my old code in src/?"
**A:** We kept it as REFERENCE!

**Your old code:**
- `src/main/java/.../model/User.java`
- `src/main/java/.../model/Account.java`
- `src/main/java/.../model/Transaction.java`

**We'll migrate it later:**
- `User.java` → `customer-service/src/.../Customer.java`
- `Account.java` → `account-service/src/.../Account.java`
- `Transaction.java` → `transaction-service/src/.../Transaction.java`

**For now, keep it!** It's your reference code.

---

### Q3: "What is API Gateway, Common Module, Config Server?"

These are **INFRASTRUCTURE SERVICES** (not business logic):

#### 🗄️ **config-server/**
- **What:** Centralized configuration storage
- **Why:** All services get config from one place
- **Status:** Empty, will build in Phase 2
- **Example:** Stores `application.properties` for all services

#### 🔍 **eureka-server/**
- **What:** Service discovery server
- **Why:** Services need to find each other
- **Status:** Empty, will build in Phase 2
- **Example:** Like a phone book - "Where is customer-service?"

#### 🚪 **api-gateway/**
- **What:** Single entry point for all requests
- **Why:** Clients don't call services directly
- **Status:** Empty, will build in Phase 2
- **Example:** All requests go through gateway first

#### 📦 **common-module/**
- **What:** Shared code (DTOs, exceptions, utils)
- **Why:** Avoid duplicating code across services
- **Status:** Empty, will build later
- **Example:** Shared exception classes, DTOs

#### 👤 **customer-service/**
- **What:** Manages customers/users
- **Why:** Separate service for customer operations
- **Status:** Empty, will get your `User.java` code in Phase 3

#### 💳 **account-service/**
- **What:** Manages bank accounts
- **Why:** Separate service for account operations
- **Status:** Empty, will get your `Account.java` code in Phase 4

#### 💸 **transaction-service/**
- **What:** Handles transactions
- **Why:** Separate service for transaction operations
- **Status:** Empty, will get your `Transaction.java` code in Phase 5

#### 🔔 **notification-service/**
- **What:** Sends notifications (email, SMS)
- **Why:** Separate service for notifications
- **Status:** Empty, will build in Phase 6

---

## 🎯 What We've Done So Far

✅ **Phase 1 Complete:**
- Created folder structure
- Created parent POM
- Created module POMs
- Deleted unnecessary `.iml` files

**Everything is EMPTY except structure!**

---

## 🚀 What's Next?

**Phase 2:** Build infrastructure services
- Config Server
- Eureka Server
- API Gateway

**Phase 3+:** Migrate your code
- Move User → customer-service
- Move Account → account-service
- Move Transaction → transaction-service

---

## 💡 Key Points

1. **Service folders are EMPTY** - Just structure, no code
2. **Old code in `src/`** - Keep it as reference
3. **We build incrementally** - One service at a time
4. **No bugs** - Just empty folders waiting for code!

**This is NORMAL!** We're building from scratch! 🎯

