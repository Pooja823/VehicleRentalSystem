# 🚗 Vehicle Rental System

> “Because even vehicles deserve proper management.” 😄

A console-based **Vehicle Rental Management System** developed in **Java** using core Object-Oriented Programming concepts.  
This project allows customers to book, update, and manage rentals for cars, bikes, and trucks efficiently.

---

## ✨ Features

✅ Add new customers  
✅ Rent Cars, Bikes, and Trucks  
✅ Prevent double booking using custom exceptions  
✅ Update existing bookings  
✅ Delete bookings  
✅ Display all customer booking details  
✅ Interactive menu-driven console interface  

---

## 🧠 Concepts Used

This project demonstrates strong understanding of:

- Object-Oriented Programming (OOP)
- Interfaces
- Exception Handling
- Arrays
- Classes & Objects
- Encapsulation
- Method Overriding
- Menu-driven Java applications

---

## 🛠️ Tech Stack

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)

![OOP](https://img.shields.io/badge/OOP-Concepts-blue?style=for-the-badge)

![Exception Handling](https://img.shields.io/badge/Exception-Handling-red?style=for-the-badge)

![Console Application](https://img.shields.io/badge/Console-App-green?style=for-the-badge)

---

## 🚘 Vehicle Types Supported

### 🚗 Cars
- Mehran 2012 Red MT 895
- Mehran 2015 Blue XY 123
- Mehran 2018 White AB 456
- Mehran 2020 Black MN 789

### 🏍️ Bikes
- Red CD 70 2013 KK-905
- Black 125 2018 OP-666

### 🚚 Trucks
- Grey Isuzui 2016 XD-065
- Brown Mercedes 2010 PF-691
- Blue Daihatsu 2009 FG-566

---

## ⚙️ How It Works

1. Add a customer
2. Select vehicle category
3. Choose available vehicle
4. System checks if already booked
5. Booking confirmed 🎉

If someone tries to book an already rented vehicle:

```java
throw new AlreadyBookedException("This vehicle is already booked!");
```

Because sharing is caring… but not when it comes to rented vehicles 😅

---

## 📂 Project Structure

```bash
VehicleRentalSystem1.java
│
├── VehicleRental (Interface)
├── AlreadyBookedException
├── CarRental
├── Cars
├── Bikes
├── Trucks
└── VehicleRentalSystem1 (Main Class)
```

---

## 💡 Sample Menu

```text
--- Vehicle Rental System Menu ---

1. Add New Customer
2. Book Vehicle
3. Delete Booking
4. Show All Bookings
5. Exit
6. Update Booking
```

---

## 🎯 Learning Outcome

This project helped me strengthen:
- Real-world problem solving
- Java OOP implementation
- Exception handling logic
- Application flow design
- Console-based UI handling

---

## 🚀 Future Improvements

- Database integration (MySQL)
- GUI using JavaFX/Swing
- Online booking support
- Payment gateway simulation
- Admin authentication system

---

## 👩‍💻 Author

**Pooja Myagade**  
B.E. Computer Science Engineering  
KLE Technological University, Hubballi

---

## 🌟 Final Note

> “A good engineer writes code that works.  
> A great engineer writes code that prevents double booking too.” 😎
