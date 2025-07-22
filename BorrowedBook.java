import java.time.LocalDate;

public class BorrowedBook {
    private Book book;
    private String borrowerName;
    private LocalDate dueDate;

    public BorrowedBook(Book book, String borrowerName, LocalDate dueDate) {
        this.book = book;
        this.borrowerName = borrowerName;
        this.dueDate = dueDate;
    }

    public Book getBook() { return book; }
    public String getBorrowerName() { return borrowerName; }
    public LocalDate getDueDate() { return dueDate; }

    public boolean isOverdue() {
        return LocalDate.now().isAfter(dueDate);
    }

    public double calculateOverdueFee() {
        if (!isOverdue()) return 0;
        long days = java.time.temporal.ChronoUnit.DAYS.between(dueDate, LocalDate.now());
        return days * 2.0; // ₹2 per day overdue
    }

    public String toString() {
        String status = isOverdue() ? "⚠️ Overdue (₹" + calculateOverdueFee() + ")" : "🟢 On time";
        return String.format("%s | Borrowed by: %s | Due: %s | %s", book.getTitle(), borrowerName, dueDate, status);
    }
}