import java.time.LocalDate;
import java.util.*;

public class LibraryManager {
    private List<Book> books = new ArrayList<>();
    private List<BorrowedBook> borrowedBooks = new ArrayList<>();

    public void addBook(String title, String author, String isbn, int qty) {
        for (Book b : books) {
            if (b.getISBN().equals(isbn)) {
                b.setQuantity(b.getQuantity() + qty);
                return;
            }
        }
        books.add(new Book(title, author, isbn, qty));
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<BorrowedBook> getBorrowedBooks() {
        return borrowedBooks;
    }

    public boolean borrowBook(String isbn, int qty, String borrowerName, LocalDate dueDate) {
        for (Book b : books) {
            if (b.getISBN().equals(isbn) && b.getQuantity() >= qty) {
                b.setQuantity(b.getQuantity() - qty);
                borrowedBooks.add(new BorrowedBook(new Book(b.getTitle(), b.getAuthor(), b.getISBN(), qty), borrowerName, dueDate));
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(String isbn, int qty) {
        Iterator<BorrowedBook> it = borrowedBooks.iterator();
        boolean returned = false;

        while (it.hasNext()) {
            BorrowedBook bb = it.next();
            if (bb.getBook().getISBN().equals(isbn)) {
                for (Book b : books) {
                    if (b.getISBN().equals(isbn)) {
                        b.setQuantity(b.getQuantity() + qty);
                        it.remove();
                        returned = true;
                        break;
                    }
                }
            }
        }
        return returned;
    }

    public List<BorrowedBook> getOverdueBooks() {
        List<BorrowedBook> overdue = new ArrayList<>();
        for (BorrowedBook bb : borrowedBooks) {
            if (bb.isOverdue()) overdue.add(bb);
        }
        return overdue;
    }

    public List<Book> searchBooks(String keyword) {
        List<Book> found = new ArrayList<>();
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                b.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                found.add(b);
            }
        }
        return found;
    }
}