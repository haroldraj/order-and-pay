# 🍽️ Order & Pay — Microservices Architecture

**Order & Pay** is a distributed microservices system built with **Spring Boot**, **PostgreSQL**, **Kafka**, and **Docker**.  
It simulates a real-world food ordering platform where users can place orders, make payments, and track deliveries, while restaurants manage their menus and order preparation.

---

## 🧭 Architecture Overview

The platform follows a **Domain-Driven, Hexagonal (Ports & Adapters)** architecture with clear boundaries between business logic, persistence, and communication layers.

### 🔹 Microservices

| Service | Responsibility |
|----------|----------------|
| 🧍‍♂️ **User Service** | Manages users, roles, and addresses |
| 🍕 **Restaurant Service** | Manages restaurants, menus, and availability |
| 🧾 **Order Service** | Handles order creation, snapshots, and history tracking |
| 💳 **Payment Service** | Processes payments and publishes payment events |
| 🚚 **Delivery Service** | Manages driver assignment and delivery tracking |

Each service has its own database and communicates asynchronously via **Apache Kafka**.

---

## 🧩 Core Technologies

| Category | Stack |
|-----------|--------|
| **Language & Framework** | Java 21 + Spring Boot 3.5 |
| **Architecture** | Hexagonal / Ports & Adapters |
| **Persistence** | PostgreSQL + Flyway (for DB migrations) |
| **Message Broker** | Apache Kafka (for event-driven communication) |
| **Caching & Messaging** | Redis (optional, for performance) |
| **Containerization** | Docker & Docker Compose |
| **CI/CD (optional)** | GitHub Packages (for shared library distribution) |
| **Testing** | JUnit 5 + Cucumber for BDD |
| **Mapping** | MapStruct + Lombok |
| **Logging** | SLF4J + Logback |

---

## 🧱 Shared Library — `order-and-pay-library`

A reusable Maven library containing:
- Common DTOs (`RoleType`, `BaseResponse`, event models)
- Shared utility classes and converters (e.g., JSONB → Map)
- Standardized response objects and enums

This module is published to **GitHub Packages** and imported by every microservice.

---

## 🧾 Order Lifecycle

1. **User** creates an order through `Order Service`
2. `Order Service` persists the order as `PENDING_PAYMENT` and publishes an `order.created` event
3. **Payment Service** consumes it, processes the transaction, and emits a `payment.processed` event
4. `Order Service` updates order status → `PAID` and emits `order.confirmed`
5. **Restaurant Service** starts preparation → emits `order.prepared`
6. **Delivery Service** assigns a driver → emits `delivery.assigned`
7. `Order Service` marks it as `DELIVERING` and logs the full status history

Every message is also stored in an **inbox/outbox table** for full traceability and replay support.

---

## 🧠 Key Design Features

### ✅ Clean & Independent Services
Each service has its own:
- Database schema  
- Domain model  
- API (REST and/or Kafka listeners)

### ✅ Data Snapshots
Orders store **immutable snapshots** of:
- Restaurant info (`restaurant_snapshot`)
- Delivery address (`address_snapshot`)

This guarantees order history integrity even if restaurant or address data changes later.

### ✅ Event-Driven Consistency
- Events are published and consumed through **Kafka topics**  
- Each event is saved in **outbox/inbox tables** for reliability  
- Services stay **loosely coupled** and resilient to downtime

### ✅ UUIDs Everywhere
- All entities use native `UUID` identifiers (PostgreSQL `uuid` type)
- Ensures type safety, compact storage, and better joins

---
