# library_tracker
# 📚 Library Tracker – Java GUI Application

**Library Tracker** is a desktop application built using **Java Swing** to manage book records and transactions in a small library setup. This system is ideal for beginners learning GUI programming, file handling, and object-oriented programming in Java. It is completely self-contained, requiring **no external database**, which makes it simple and portable.

---

## 🚀 Features

- 📖 Add new book entries with details like title, author, ISBN, and availability
- 📝 Edit or delete existing book records
- 🔍 Search for books by title, author, or ISBN
- ✅ Issue and return books with tracking of borrowers and due dates
- 📊 View real-time status of book inventory
- 💾 Store data using file handling (text/serialization)
- 🖥️ User-friendly interface using Java Swing components

---

## 🛠️ Built With

| Technology       | Description                       |
|------------------|-----------------------------------|
| Java             | Core language                     |
| Java Swing       | GUI framework for interface       |
| File Handling    | For data persistence              |
| Collections API  | ArrayList, HashMap, etc. for logic|
| IntelliJ/Eclipse | Supported IDEs                   |

---

## 📂 Folder Structure

```
LibraryTracker/
├── src/
│   ├── Main.java
│   ├── LibraryTrackerGUI.java
│   ├── Book.java
│   ├── BookManager.java
│   ├── FileHandler.java
  └── Borrower.java
```

---

## 📥 Installation

1. **Clone the Repository**



2. **Open in IDE**

- Open the project folder in your preferred Java IDE like **IntelliJ**, **Eclipse**, or **NetBeans**

3. **Run the Application**

- Locate the `Main.java` or `LibraryTrackerGUI.java` file
- Compile and run the application
- The GUI will launch and you can start using the app

---



## 🧩 Class Structure

### 1. `Book.java`

- Attributes: `title`, `author`, `isbn`, `available`
- Methods: constructors, getters, setters, toString()

### 2. `Borrower.java`

- Attributes: `name`, `bookIssued`, `issueDate`, `dueDate`
- Methods: setters/getters, calculate overdue, etc.

### 3. `BookManager.java`

- Manages a list of books (using `ArrayList`)
- Methods for `addBook`, `removeBook`, `editBook`, `searchBook`

### 4. `FileHandler.java`

- Read/write data from/to file
- Uses text or serialized file formats

### 5. `LibraryTrackerGUI.java`

- Main GUI class
- Uses `JFrame`, `JPanel`, `JTable`, `JButtons` to build the interface
- Implements listeners for UI actions

---

## 💾 Data Storage Format

The system saves data using simple file handling mechanisms. Here's a sample data format:

### `books.txt`
```
Title: Clean Code
Author: Robert C. Martin
ISBN: 9780132350884
Available: true

Title: Effective Java
Author: Joshua Bloch
ISBN: 9780134685991
Available: false
```

### `borrowers.txt`
```
Name: Ravi Kumar
Book: Effective Java
IssueDate: 2025-07-01
DueDate: 2025-07-15
```

---

## 🧠 Concepts Demonstrated

- Java Object-Oriented Programming
- GUI programming with Swing
- File handling (Text files, Serialization)
- Collection frameworks
- Exception handling
- MVC-like design pattern (separating logic/UI)

---

## 🔒 No External Dependencies

- ✅ No database (like MySQL) required
- ✅ No third-party libraries
- ✅ Pure Java-based solution

---

## 📦 Project Use Cases

- 💼 Java mini-project for college
- 🏫 School or college library systems (offline)
- 👨‍💻 Practice for building GUI-based applications
- 📚 Learning project for mastering file handling in Java

---

## 📈 Future Improvements

- Add login system for admin/staff
- Implement overdue book alerts
- Add CSV export/import functionality
- Enable sorting and filtering in tables
- Option to use XML or JSON for file storage
- Add charts and usage reports using JFreeChart

---

## 🧪 Sample Testing Steps

1. Open the GUI and click **Add Book**
2. Enter book details and submit
3. Go to **View All Books** to confirm the entry
4. Select a book and click **Issue Book**
5. Enter borrower info and confirm
6. Return to home and click **Issued Books** to verify

---

## 🙋 FAQ

**Q1: Do I need to install MySQL?**  
A: No. This application uses Java file handling to manage data.

**Q2: Can I store the data permanently?**  
A: Yes, the app writes to local files (`books.txt`, etc.).

**Q3: Does this work on all systems?**  
A: Yes, it's cross-platform as long as you have Java installed.

**Q4: Can I convert this to a database version later?**  
A: Yes, the logic is modular, so switching to JDBC is possible.

---

## 👨‍💻 Author

- 👩‍💻 *Raavi Deepak**  
- 💼 Java Developer & Student  
-

---


## 📬 Feedback

If you find bugs or have suggestions for improvements, feel free to raise an issue or submit a pull request. Contributions are always welcome!
