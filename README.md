# AIMS - An Internet Media Store 📀📚🎵

AIMS (An Internet Media Store) là một ứng dụng mô phỏng một cửa hàng bán sản phẩm đa phương tiện như DVD, CD và sách. Dự án này bắt đầu như một bài tập thực hành trong lớp Lập trình Hướng Đối Tượng tại Đại học Bách Khoa Hà Nội (HUST), và sau đó được mở rộng thành một hệ thống tương đối hoàn chỉnh bao gồm cả giao diện đồ họa (GUI), xử lý logic, và các mô hình hướng đối tượng phức tạp.

## 🧠 Tính năng chính

### 1. **Quản lý sản phẩm đa phương tiện**

* Hỗ trợ nhiều loại media: **DVD**, **CD**, **Book**
* Thông tin hiển thị khác nhau tùy loại (VD: CD có artist, track list; Book có danh sách tác giả, v.v.)

### 2. **Cửa hàng và giỏ hàng**

* Xem danh sách media hiện có trong store
* Tìm kiếm theo: **tiêu đề**, **thể loại**, hoặc **giá**
* Thêm sản phẩm vào giỏ hàng, xem chi tiết, và **nghe/xem demo** (playable media)
* **Sắp xếp** giỏ hàng theo tiêu đề hoặc giá

### 3. **Tính năng giỏ hàng nâng cao**

* Cập nhật số lượng, xóa sản phẩm
* **Tặng ngẫu nhiên 1 sản phẩm** miễn phí
* **Lọc theo ID hoặc tiêu đề** trong giỏ
* Tính tổng tiền, tính VAT và phí vận chuyển theo khối lượng và địa điểm

### 4. **Đặt hàng và thanh toán**

* Nhập thông tin giao hàng
* Thanh toán bằng **thẻ tín dụng** (giả lập)
* In hóa đơn, hiển thị kết quả giao dịch

### 5. **Giao diện người dùng**

* **Console-based CLI**: giao diện menu đơn giản để thao tác toàn bộ ứng dụng
* **Swing & JavaFX GUI**: chuyển đổi sang giao diện đồ họa trực quan

  * View Store (Swing)
  * View Cart (JavaFX)
  * Update Store

### 6. **Chế độ Quản trị viên**

* Đăng nhập quản lý
* Thêm/Xóa media trong kho
* Duyệt và quản lý đơn hàng chờ xử lý

## 📁 Cấu trúc repo (tùy bạn có thể đổi thư mục hoặc refactor)

```
/src
 └── hust/soict/dsai/aims
     ├── media/              # Lớp mô hình cho DVD, CD, Book, Media, Track
     ├── store/              # Store, quản lý các media hiện có
     ├── cart/               # Cart, thao tác giỏ hàng
     ├── screen/             # GUI Screens (Swing & JavaFX)
     ├── utils/              # Comparator, Exception, Validator,...
     └── Aims.java           # Main CLI chương trình
```

## 🔧 Công nghệ & kỹ thuật

* Java 8
* OOP nâng cao: Kế thừa, Trừu tượng, Interface
* Collections: `ArrayList`, `Comparator`, `ObservableList`
* GUI: `Swing`, `JavaFX`
* Thiết kế UML: Use Case, Class Diagram (sử dụng Astah)
* Exception Handling
* Design pattern: Playable Interface, Media abstraction, Polymorphism via `toString()`, override `equals()`

## 💻 Cách chạy dự án

### Cách 1: Chạy bằng CLI

```bash
javac -d bin src/hust/soict/dsai/aims/Aims.java
java -cp bin hust.soict.dsai.aims.Aims
```

### Cách 2: Chạy GUI

* Chạy `StoreScreen.java` (Swing)
* Chạy `CartScreen.java` (JavaFX)

> ⚠️ Với JavaFX, nếu bạn dùng JDK > 8, cần thêm thư viện JavaFX vào classpath. Xem hướng dẫn JavaFX tại [https://openjfx.io](https://openjfx.io)

## 🧪 Một số tính năng bạn có thể thử

* Thêm mới CD có nhiều track, nghe CD
* Thêm sách có nhiều tác giả, hiển thị
* Tìm kiếm DVD có từ khóa trong tiêu đề
* Chơi một DVD có length <= 0 (xử lý ngoại lệ)
* Thanh toán với thẻ không hợp lệ (test giả lập)

## 📸 Hình ảnh

*Tạm thời không có*

## 🧑‍💻 Tác giả

* **Phạm Công Sơn**
* [Son.PC205220@hust.edu.vn](mailto:Son.PC205220@hust.edu.vn)
* Đại học Bách Khoa Hà Nội (HUST)
