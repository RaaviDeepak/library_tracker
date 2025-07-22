public class Book {
    private String title, author, isbn;
    private int quantity;

    public Book(String title, String author, String isbn, int quantity) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.quantity = quantity;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getISBN() { return isbn; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String toString() {
        return String.format("📘 %s by %s | ISBN: %s | Qty: %d", title, author, isbn, quantity);
    }
}