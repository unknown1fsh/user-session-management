# User Session Management / Kullanıcı Oturum Yönetimi

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.2-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![Redis](https://img.shields.io/badge/Redis-Memurai-red.svg)](https://www.memurai.com/)
[![MySQL](https://img.shields.io/badge/MySQL-8.0-blue.svg)](https://www.mysql.com/)

---

## 📋 Table of Contents / İçindekiler

- [English](#english)
  - [Overview](#overview)
  - [Features](#features)
  - [Technologies](#technologies)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Configuration](#configuration)
  - [Running the Application](#running-the-application)
  - [API Endpoints](#api-endpoints)
  - [Testing](#testing)
  - [Troubleshooting](#troubleshooting)
- [Türkçe](#türkçe)
  - [Genel Bakış](#genel-bakış)
  - [Özellikler](#özellikler)
  - [Teknolojiler](#teknolojiler)
  - [Gereksinimler](#gereksinimler)
  - [Kurulum](#kurulum)
  - [Yapılandırma](#yapılandırma)
  - [Uygulamayı Çalıştırma](#uygulamayı-çalıştırma)
  - [API Endpoint'leri](#api-endpointleri)
  - [Test Etme](#test-etme)
  - [Sorun Giderme](#sorun-giderme)

---

# English

## Overview

This is a comprehensive Spring Boot-based application for managing user sessions with Redis (Memurai) integration. It provides secure user registration, authentication, and session management with automatic session expiration.

## Features

- ✅ **User Registration**: Secure user registration with password hashing
- ✅ **User Authentication**: Email and password-based login
- ✅ **Session Management**: Redis (Memurai) based session storage with 2-minute TTL
- ✅ **User Logout**: Secure session termination
- ✅ **Input Validation**: Comprehensive request validation
- ✅ **Error Handling**: Global exception handling with detailed error messages
- ✅ **CORS Support**: Cross-origin resource sharing enabled
- ✅ **Internationalization**: English and Turkish language support
- ✅ **Modern UI**: Responsive HTML test page

## Technologies

- **Spring Boot 3.3.2**: Application framework
- **Spring Security**: Authentication and security
- **Spring Data JPA**: Database operations
- **Spring Data Redis**: Redis integration
- **MySQL 8.0**: Relational database
- **Redis (Memurai)**: In-memory session store
- **Lombok**: Code generation
- **Jakarta Validation**: Input validation
- **Java 17**: Programming language

## Prerequisites

Before you begin, ensure you have the following installed:

- **Java 17** or higher
- **Maven 3.6+**
- **MySQL 8.0** (running on localhost:3306)
- **Memurai** (Redis for Windows) - [Download here](https://www.memurai.com/get-memurai)

## Installation

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/user-session-management.git
cd user-session-management
```

### 2. Install Memurai (Redis for Windows)

1. Download Memurai from [https://www.memurai.com/get-memurai](https://www.memurai.com/get-memurai)
2. Run the installer and follow the setup wizard
3. Memurai will start automatically as a Windows service
4. Default port: **6379**

### 3. Create MySQL Database

```sql
CREATE DATABASE IF NOT EXISTS user_session_management;
```

Or use MySQL command line:

```bash
mysql -u root -p12345 -e "CREATE DATABASE IF NOT EXISTS user_session_management;"
```

### 4. Configure Application

Edit `src/main/resources/application.properties`:

```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/user_session_management?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=12345

# Redis (Memurai) Configuration
spring.redis.host=localhost
spring.redis.port=6379
```

## Running the Application

### Using Maven

```bash
mvn clean install
mvn spring-boot:run
```

### Using IDE

Run the `UserSessionManagementApplication` class directly from your IDE.

The application will start on **http://localhost:8080**

## API Endpoints

### Register User
```http
POST /api/auth/register
Content-Type: application/json

{
  "name": "John Doe",
  "email": "john@example.com",
  "password": "password123"
}
```

**Response:**
```json
{
  "id": 1,
  "name": "John Doe",
  "email": "john@example.com"
}
```

### Login
```http
POST /api/auth/login
Content-Type: application/json

{
  "email": "john@example.com",
  "password": "password123"
}
```

**Response:**
```json
{
  "message": "Login Success",
  "sessionId": "session:1",
  "userId": 1
}
```

### Logout
```http
POST /api/auth/logout
Content-Type: application/json

{
  "userId": 1
}
```

**Response:**
```json
{
  "message": "Logout Success"
}
```

## Testing

### Web Interface

1. Start the application
2. Open your browser and navigate to: **http://localhost:8080**
3. Use the modern HTML interface to test:
   - User registration
   - User login
   - User logout
   - Session management

### Using cURL

```bash
# Register
curl -X POST http://localhost:8080/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{"name":"Test User","email":"test@example.com","password":"test123"}'

# Login
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{"email":"test@example.com","password":"test123"}'

# Logout
curl -X POST http://localhost:8080/api/auth/logout \
  -H "Content-Type: application/json" \
  -d '{"userId":1}'
```

## Troubleshooting

### Redis Connection Issues

**Problem:** `Unable to connect to Redis`

**Solution:**
1. Ensure Memurai service is running:
   ```powershell
   Get-Service -Name "*memurai*"
   ```
2. Check if Memurai is listening on port 6379
3. Verify Redis configuration in `application.properties`

### Database Connection Issues

**Problem:** `Cannot connect to MySQL`

**Solution:**
1. Ensure MySQL service is running
2. Verify database exists: `user_session_management`
3. Check username and password in `application.properties`
4. Ensure MySQL is accessible on `localhost:3306`

### Port Already in Use

**Problem:** `Port 8080 is already in use`

**Solution:**
Change the port in `application.properties`:
```properties
server.port=8081
```

---

# Türkçe

## Genel Bakış

Bu, Redis (Memurai) entegrasyonu ile kullanıcı oturum yönetimi için kapsamlı bir Spring Boot tabanlı uygulamadır. Otomatik oturum sona erme ile güvenli kullanıcı kaydı, kimlik doğrulama ve oturum yönetimi sağlar.

## Özellikler

- ✅ **Kullanıcı Kaydı**: Şifre hashleme ile güvenli kullanıcı kaydı
- ✅ **Kullanıcı Kimlik Doğrulama**: E-posta ve şifre tabanlı giriş
- ✅ **Oturum Yönetimi**: 2 dakika TTL ile Redis (Memurai) tabanlı oturum depolama
- ✅ **Kullanıcı Çıkışı**: Güvenli oturum sonlandırma
- ✅ **Girdi Doğrulama**: Kapsamlı istek doğrulama
- ✅ **Hata Yönetimi**: Detaylı hata mesajları ile global exception handling
- ✅ **CORS Desteği**: Cross-origin resource sharing etkin
- ✅ **Çoklu Dil Desteği**: İngilizce ve Türkçe dil desteği
- ✅ **Modern Arayüz**: Responsive HTML test sayfası

## Teknolojiler

- **Spring Boot 3.3.2**: Uygulama framework'ü
- **Spring Security**: Kimlik doğrulama ve güvenlik
- **Spring Data JPA**: Veritabanı işlemleri
- **Spring Data Redis**: Redis entegrasyonu
- **MySQL 8.0**: İlişkisel veritabanı
- **Redis (Memurai)**: Bellek içi oturum deposu
- **Lombok**: Kod üretimi
- **Jakarta Validation**: Girdi doğrulama
- **Java 17**: Programlama dili

## Gereksinimler

Başlamadan önce aşağıdakilerin kurulu olduğundan emin olun:

- **Java 17** veya üzeri
- **Maven 3.6+**
- **MySQL 8.0** (localhost:3306'da çalışıyor olmalı)
- **Memurai** (Windows için Redis) - [Buradan indirin](https://www.memurai.com/get-memurai)

## Kurulum

### 1. Repository'yi Klonlayın

```bash
git clone https://github.com/your-username/user-session-management.git
cd user-session-management
```

### 2. Memurai'yi Kurun (Windows için Redis)

1. Memurai'yi [https://www.memurai.com/get-memurai](https://www.memurai.com/get-memurai) adresinden indirin
2. Kurulum dosyasını çalıştırın ve sihirbazı takip edin
3. Memurai otomatik olarak Windows servisi olarak başlayacaktır
4. Varsayılan port: **6379**

### 3. MySQL Veritabanı Oluşturun

```sql
CREATE DATABASE IF NOT EXISTS user_session_management;
```

Veya MySQL komut satırını kullanın:

```bash
mysql -u root -p12345 -e "CREATE DATABASE IF NOT EXISTS user_session_management;"
```

### 4. Uygulamayı Yapılandırın

`src/main/resources/application.properties` dosyasını düzenleyin:

```properties
# Veritabanı Yapılandırması
spring.datasource.url=jdbc:mysql://localhost:3306/user_session_management?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=12345

# Redis (Memurai) Yapılandırması
spring.redis.host=localhost
spring.redis.port=6379
```

## Uygulamayı Çalıştırma

### Maven Kullanarak

```bash
mvn clean install
mvn spring-boot:run
```

### IDE Kullanarak

IDE'nizden `UserSessionManagementApplication` sınıfını doğrudan çalıştırın.

Uygulama **http://localhost:8080** adresinde başlayacaktır.

## API Endpoint'leri

### Kullanıcı Kaydı
```http
POST /api/auth/register
Content-Type: application/json

{
  "name": "Ahmet Yılmaz",
  "email": "ahmet@example.com",
  "password": "sifre123"
}
```

**Yanıt:**
```json
{
  "id": 1,
  "name": "Ahmet Yılmaz",
  "email": "ahmet@example.com"
}
```

### Giriş
```http
POST /api/auth/login
Content-Type: application/json

{
  "email": "ahmet@example.com",
  "password": "sifre123"
}
```

**Yanıt:**
```json
{
  "message": "Login Success",
  "sessionId": "session:1",
  "userId": 1
}
```

### Çıkış
```http
POST /api/auth/logout
Content-Type: application/json

{
  "userId": 1
}
```

**Yanıt:**
```json
{
  "message": "Logout Success"
}
```

## Test Etme

### Web Arayüzü

1. Uygulamayı başlatın
2. Tarayıcınızda şu adrese gidin: **http://localhost:8080**
3. Modern HTML arayüzünü kullanarak test edin:
   - Kullanıcı kaydı
   - Kullanıcı girişi
   - Kullanıcı çıkışı
   - Oturum yönetimi

### cURL Kullanarak

```bash
# Kayıt
curl -X POST http://localhost:8080/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{"name":"Test Kullanıcı","email":"test@example.com","password":"test123"}'

# Giriş
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{"email":"test@example.com","password":"test123"}'

# Çıkış
curl -X POST http://localhost:8080/api/auth/logout \
  -H "Content-Type: application/json" \
  -d '{"userId":1}'
```

## Sorun Giderme

### Redis Bağlantı Sorunları

**Sorun:** `Unable to connect to Redis`

**Çözüm:**
1. Memurai servisinin çalıştığından emin olun:
   ```powershell
   Get-Service -Name "*memurai*"
   ```
2. Memurai'nin 6379 portunda dinlediğini kontrol edin
3. `application.properties` dosyasındaki Redis yapılandırmasını doğrulayın

### Veritabanı Bağlantı Sorunları

**Sorun:** `Cannot connect to MySQL`

**Çözüm:**
1. MySQL servisinin çalıştığından emin olun
2. Veritabanının var olduğunu doğrulayın: `user_session_management`
3. `application.properties` dosyasındaki kullanıcı adı ve şifreyi kontrol edin
4. MySQL'in `localhost:3306` adresinde erişilebilir olduğundan emin olun

### Port Zaten Kullanımda

**Sorun:** `Port 8080 is already in use`

**Çözüm:**
`application.properties` dosyasında portu değiştirin:
```properties
server.port=8081
```

---

## 📝 License

This project is open source and available under the [MIT License](LICENSE).

## 🤝 Contributing

Contributions, issues, and feature requests are welcome! Feel free to check the [issues page](https://github.com/your-username/user-session-management/issues).

## 👤 Author

**Your Name**
- GitHub: [@unknown1fsh](https://github.com/unknown1fsh)

---

**Made with ❤️ using Spring Boot**
