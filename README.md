# FeeDo 寵物餐廳後端管理系統 (FeeDo Pet Restaurant Backend)

這是一個專為寵物餐廳設計的後端管理系統，基於 **Spring Boot** 框架開發。系統核心在於高效處理餐廳內部的行政資料，包含員工管理、寵物檔案維護以及細緻的權限控管機制。

## 核心功能 (Core Features)

* **員工資料管理 (Employee Management)**：
    * 完整的 CRUD 功能，支援員工基本資訊、職位與入職狀態維護。
    * 整合權限級別，確保不同職位的員工僅能存取特定資源。
* **寵物檔案維護 (Pet Records)**：
    * 紀錄餐廳店寵或顧客寵物的詳細檔案（如種類、年齡、健康狀態）。
    * 提供靈活的搜尋介面，可快速調閱特定寵物資訊。
* **權限控管系統 (Authority Management)**：
    * 基於角色的存取控制 (RBAC)，實現不同層級的管理權限（管理員、櫃台、一般員工）。
    * 確保敏感資料（如薪資、內部備註）受到保護。
* **餐廳資源整合**：
    * 預留未來擴充點，可與訂位系統或餐飲管理模組進行對接。

---

## 技術棧 (Tech Stack)

* **Language**: Java 17+
- **Framework**: Spring Boot 3.x
- **Persistence**: Spring Data JPA / Hibernate
- **Database**: MySQL / PostgreSQL (請根據實際使用填寫)
- **Security**: Spring Security (處理登入驗證與權限派發)
- **API Standards**: RESTful API
- **Build Tool**: Maven

---

## 系統架構與設計 (System Architecture)

本專案著重於 **後端邏輯與資料完整性**：
1.  **實體關聯設計 (ERD)**：建立員工 (Employee) 與寵物 (Pet) 的邏輯關聯，並透過權限表 (Authority) 進行交叉驗證。
2.  **Service 層封裝**：將業務邏輯（如權限校驗、資料過濾）封裝於 Service 層，確保 Controller 層的簡潔與 API 的可維護性。
3.  **安全性設計**：實作密碼加密儲存與 Token 驗證機制（若有使用 JWT 請加註）。

---

## 如何運行 (Getting Started)

### 前置準備
* JDK 17 或以上版本
* Maven 3.6+
* 資料庫環境 (如 MySQL 8.0)

### 執行步驟
1. 複製專案：`git clone [Repository URL]`
2. 修改配置：前往 `src/main/resources/application.properties` 修改資料庫帳號與密碼。
3. 編譯並運行：
   ```bash
   mvn clean install
   mvn spring-boot:run
