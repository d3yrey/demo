# 📋 Phase 1: Implementation Guide - Parent POM & Structure

## 🎯 What You'll Create

1. **Parent POM** (`pom.xml` at root)
2. **Folder structure** for all services
3. **Basic module POMs** (minimal, just to make Maven happy)

---

## 📁 Step 1: Create Folder Structure

**Location:** In your project root (same level as current `src` folder)

Create these folders (empty for now):

```
demo/                                    ← Your current project (keep it!)
├── src/                                 ← Your current code
├── pom.xml                              ← Your current pom.xml (keep it!)
│
└── [NEW FOLDERS TO CREATE]              ← Create these at same level as demo/
    ├── config-server/
    ├── eureka-server/
    ├── api-gateway/
    ├── customer-service/
    ├── account-service/
    ├── transaction-service/
    ├── notification-service/
    └── common-module/
```

**Wait!** Actually, there are two approaches:

### Approach A: Keep demo separate (Recommended)
```
C:\Users\Nihat\IdeaProjects\ders\
├── demo/                                ← Your current project (keep as-is)
│   ├── src/
│   └── pom.xml
│
└── banking-microservices/               ← NEW parent project
    ├── pom.xml                          ← Parent POM
    ├── config-server/
    ├── eureka-server/
    ├── api-gateway/
    ├── customer-service/
    ├── account-service/
    ├── transaction-service/
    ├── notification-service/
    └── common-module/
```

### Approach B: Convert demo into parent
```
demo/                                    ← Convert this to parent
├── pom.xml                              ← Replace with parent POM
├── config-server/
├── eureka-server/
├── api-gateway/
├── customer-service/
├── account-service/
├── transaction-service/
├── notification-service/
├── common-module/
└── [old-demo]/                          ← Move current code here (optional)
    └── src/
```

**I recommend Approach A** - cleaner separation, easier to learn.

---

## 📝 Step 2: Create Parent POM

**File:** `banking-microservices/pom.xml` (or `demo/pom.xml` if Approach B)

### Complete Parent POM Code:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
         https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <!-- Parent POM Info -->
    <groupId>com.banking</groupId>
    <artifactId>banking-microservices</artifactId>
    <version>1.0.0-SNAPSHOT</version>
    <packaging>pom</packaging>  <!-- ⚠️ Important: packaging is "pom" not "jar" -->
    <name>Banking Microservices</name>
    <description>Spring Boot Banking Microservices Project</description>

    <!-- Spring Boot Parent -->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.5.4</version>
        <relativePath/>
    </parent>

    <!-- Properties - Shared across all modules -->
    <properties>
        <java.version>21</java.version>
        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        
        <!-- Spring Cloud Version -->
        <spring-cloud.version>2024.0.0</spring-cloud.version>
        
        <!-- Common Dependency Versions -->
        <lombok.version>1.18.34</lombok.version>
        <postgresql.version>42.7.4</postgresql.version>
        <mapstruct.version>1.5.5.Final</mapstruct.version>
    </properties>

    <!-- Dependency Management - Defines versions for all child modules -->
    <dependencyManagement>
        <dependencies>
            <!-- Spring Cloud Dependencies -->
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            
            <!-- Lombok -->
            <dependency>
                <groupId>org.projectlombok</groupId>
                <artifactId>lombok</artifactId>
                <version>${lombok.version}</version>
            </dependency>
            
            <!-- PostgreSQL -->
            <dependency>
                <groupId>org.postgresql</groupId>
                <artifactId>postgresql</artifactId>
                <version>${postgresql.version}</version>
            </dependency>
            
            <!-- MapStruct -->
            <dependency>
                <groupId>org.mapstruct</groupId>
                <artifactId>mapstruct</artifactId>
                <version>${mapstruct.version}</version>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <!-- Modules List - All your microservices -->
    <modules>
        <module>config-server</module>
        <module>eureka-server</module>
        <module>api-gateway</module>
        <module>customer-service</module>
        <module>account-service</module>
        <module>transaction-service</module>
        <module>notification-service</module>
        <module>common-module</module>
    </modules>

    <!-- Build Configuration -->
    <build>
        <pluginManagement>
            <plugins>
                <!-- Spring Boot Maven Plugin -->
                <plugin>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-maven-plugin</artifactId>
                </plugin>
                
                <!-- Maven Compiler Plugin -->
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-compiler-plugin</artifactId>
                    <version>3.11.0</version>
                    <configuration>
                        <source>${java.version}</source>
                        <target>${java.version}</target>
                        <annotationProcessorPaths>
                            <!-- Lombok -->
                            <path>
                                <groupId>org.projectlombok</groupId>
                                <artifactId>lombok</artifactId>
                                <version>${lombok.version}</version>
                            </path>
                            <!-- MapStruct -->
                            <path>
                                <groupId>org.mapstruct</groupId>
                                <artifactId>mapstruct-processor</artifactId>
                                <version>${mapstruct.version}</version>
                            </path>
                        </annotationProcessorPaths>
                    </configuration>
                </plugin>
            </plugins>
        </pluginManagement>
    </build>

</project>
```

---

## 🔍 Explanation of Key Parts

### 1. `<packaging>pom</packaging>`
- **What it means:** This POM doesn't create a JAR/WAR, it just manages other modules
- **Why:** Parent POMs are "container" projects, not runnable applications

### 2. `<properties>`
- **What it means:** Variables shared by all child modules
- **Why:** Change Spring Boot version in ONE place, all services update

### 3. `<dependencyManagement>`
- **What it means:** Defines versions, but doesn't add dependencies
- **Why:** Child modules can use dependencies without specifying versions
- **Example:** Child says `<dependency><groupId>org.projectlombok</groupId><artifactId>lombok</artifactId></dependency>` - version comes from parent!

### 4. `<modules>`
- **What it means:** Lists all child modules
- **Why:** Maven knows to build these when you run `mvn install` at root

---

## 📝 Step 3: Create Minimal Module POMs

For each service folder, create a minimal `pom.xml`:

### Example: `customer-service/pom.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
         https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <!-- Reference to Parent POM -->
    <parent>
        <groupId>com.banking</groupId>
        <artifactId>banking-microservices</artifactId>
        <version>1.0.0-SNAPSHOT</version>
    </parent>

    <!-- This Module's Info -->
    <artifactId>customer-service</artifactId>
    <name>Customer Service</name>
    <description>Customer Management Microservice</description>

    <!-- Dependencies will be added later in Phase 2+ -->
    <dependencies>
        <!-- We'll add dependencies when we build this service -->
    </dependencies>

</project>
```

**Create similar POMs for:**
- `config-server/pom.xml`
- `eureka-server/pom.xml`
- `api-gateway/pom.xml`
- `account-service/pom.xml`
- `transaction-service/pom.xml`
- `notification-service/pom.xml`
- `common-module/pom.xml`

**Template for all:**
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
         https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>com.banking</groupId>
        <artifactId>banking-microservices</artifactId>
        <version>1.0.0-SNAPSHOT</version>
    </parent>

    <artifactId>[SERVICE-NAME]</artifactId>
    <name>[Service Display Name]</name>
    <description>[Service Description]</description>

    <dependencies>
        <!-- Will be added later -->
    </dependencies>

</project>
```

**Replace `[SERVICE-NAME]` with:**
- `config-server` → "Config Server"
- `eureka-server` → "Eureka Server"
- `api-gateway` → "API Gateway"
- `customer-service` → "Customer Service"
- `account-service` → "Account Service"
- `transaction-service` → "Transaction Service"
- `notification-service` → "Notification Service"
- `common-module` → "Common Module"

---

## ✅ Step 4: Verify Structure

After creating everything, test it:

```bash
# Navigate to parent directory
cd banking-microservices

# Clean and compile (should work even though modules are empty)
mvn clean install
```

**Expected result:**
- ✅ All modules compile (even if empty)
- ✅ No errors
- ✅ Maven recognizes the structure

---

## 🎯 Quick Reference: What Each Part Does

| Part | Purpose | Example |
|------|---------|---------|
| **Parent POM** | Manages versions, defines structure | `banking-microservices/pom.xml` |
| **Module POM** | Individual service configuration | `customer-service/pom.xml` |
| **dependencyManagement** | Version definitions (not actual dependencies) | Defines Lombok version |
| **modules** | List of child projects | Tells Maven what to build |
| **packaging=pom** | Parent is not a JAR, just a container | Parent doesn't run |

---

## 🚨 Common Mistakes to Avoid

1. ❌ **Forgetting `<packaging>pom</packaging>`** in parent
   - ✅ Parent must have `packaging=pom`

2. ❌ **Wrong parent path in child POMs**
   - ✅ Use correct `groupId`, `artifactId`, `version`

3. ❌ **Adding dependencies in parent's `<dependencies>`**
   - ✅ Use `<dependencyManagement>` for versions
   - ✅ Add actual dependencies in child modules

4. ❌ **Missing modules in parent's `<modules>` list**
   - ✅ List all folders that have `pom.xml`

---

## 📋 Checklist

- [ ] Created parent folder `banking-microservices/`
- [ ] Created parent `pom.xml` with all sections
- [ ] Created all 8 service folders
- [ ] Created `pom.xml` in each service folder
- [ ] Verified `mvn clean install` works
- [ ] Kept original `demo/` project as reference

---

## 🎓 What You've Learned

1. **Maven Multi-Module Projects** - How parent/child POMs work
2. **Dependency Management** - Centralized version control
3. **Project Structure** - How microservices are organized
4. **Incremental Building** - Structure first, code later

---

## 🚀 Next Steps

Once Phase 1 is complete:
1. ✅ You have the structure
2. ✅ Maven recognizes all modules
3. ✅ Ready to build Config Server (Phase 2)

**When you're done, ask me:**
- "Review my parent POM" - I'll check it
- "What's next?" - I'll guide you to Phase 2
- "Explain [concept]" - I'll teach you

---

## 💡 Pro Tips

1. **Use IDE support:** IntelliJ IDEA recognizes multi-module projects automatically
2. **Version consistency:** All services use same Spring Boot version from parent
3. **Easy updates:** Change version in parent, all children update
4. **Incremental:** Build one service at a time, others can stay empty

Good luck! 🎉

