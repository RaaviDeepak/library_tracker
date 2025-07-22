import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.List;
import javax.swing.*;

public class LibraryGUI {
    private LibraryManager manager = new LibraryManager();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            splashScreen();
            new LibraryGUI().createAndShowGUI();
        });
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("📚 Library Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 500);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        JPanel buttonPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        String[] buttons = {"Add Book", "Borrow Book", "Return Book", "View Books", "View Borrowed", "Search", "Overdue List"};
        for (String name : buttons) {
            JButton btn = new JButton(name);
            btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
            btn.setFocusPainted(false);
            btn.setBackground(new Color(240, 240, 240));
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

            btn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    btn.setBackground(new Color(173, 216, 230));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btn.setBackground(new Color(240, 240, 240));
                }
            });

            btn.addActionListener(e -> handleAction(name));
            buttonPanel.add(btn);
        }

        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.add(buttonPanel, BorderLayout.NORTH);
        frame.add(panel);
        frame.setVisible(true);
    }

    private void handleAction(String action) {
        switch (action) {
            case "Add Book" -> addBookDialog();
            case "Borrow Book" -> borrowBookDialog();
            case "Return Book" -> returnBookDialog();
            case "View Books" -> showText("📚 Books in Library", formatBooks(manager.getBooks()));
            case "View Borrowed" -> showText("📕 Borrowed Books", formatBorrowed(manager.getBorrowedBooks()));
            case "Search" -> searchBookDialog();
            case "Overdue List" -> showText("⏰ Overdue Books", formatBorrowed(manager.getOverdueBooks()));
        }
    }

    private void addBookDialog() {
        JTextField title = new JTextField(), author = new JTextField(), isbn = new JTextField(), qty = new JTextField();
        Object[] fields = {"Title:", title, "Author:", author, "ISBN:", isbn, "Quantity:", qty};

        if (JOptionPane.showConfirmDialog(null, fields, "Add Book", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            try {
                manager.addBook(title.getText(), author.getText(), isbn.getText(), Integer.parseInt(qty.getText()));
                msg("Book added!");
            } catch (Exception e) {
                msg("Invalid input.");
            }
        }
    }

    private void borrowBookDialog() {
        JTextField isbn = new JTextField(), qty = new JTextField(), name = new JTextField(), due = new JTextField("YYYY-MM-DD");
        Object[] fields = {"ISBN:", isbn, "Quantity:", qty, "Borrower Name:", name, "Due Date:", due};

        if (JOptionPane.showConfirmDialog(null, fields, "Borrow Book", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            try {
                boolean success = manager.borrowBook(isbn.getText(), Integer.parseInt(qty.getText()), name.getText(), LocalDate.parse(due.getText()));
                msg(success ? "Book borrowed!" : "Not enough stock.");
            } catch (Exception e) {
                msg("Invalid input.");
            }
        }
    }

    private void returnBookDialog() {
        JTextField isbn = new JTextField(), qty = new JTextField();
        Object[] fields = {"ISBN:", isbn, "Quantity:", qty};

        if (JOptionPane.showConfirmDialog(null, fields, "Return Book", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            try {
                boolean success = manager.returnBook(isbn.getText(), Integer.parseInt(qty.getText()));
                msg(success ? "Returned!" : "ISBN not found.");
            } catch (Exception e) {
                msg("Invalid input.");
            }
        }
    }

    private void searchBookDialog() {
        String keyword = JOptionPane.showInputDialog("Enter title or author:");
        if (keyword != null && !keyword.isBlank()) {
            List<Book> found = manager.searchBooks(keyword);
            showText("🔍 Search Results", formatBooks(found));
        }
    }

    private String formatBooks(List<Book> list) {
        if (list.isEmpty()) return "No books found.";
        StringBuilder sb = new StringBuilder();
        for (Book b : list) sb.append(b).append("\n");
        return sb.toString();
    }

    private String formatBorrowed(List<BorrowedBook> list) {
        if (list.isEmpty()) return "No borrowed books.";
        StringBuilder sb = new StringBuilder();
        for (BorrowedBook bb : list) sb.append(bb).append("\n");
        return sb.toString();
    }

    private void msg(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    private void showText(String title, String text) {
        JTextArea area = new JTextArea();
        area.setEditable(false);
        area.setFont(new Font("Monospaced", Font.PLAIN, 13));
        JScrollPane scroll = new JScrollPane(area);
        scroll.setPreferredSize(new Dimension(500, 300));

        Timer timer = new Timer(10, null);
        final int[] index = {0};
        timer.addActionListener(e -> {
            if (index[0] < text.length()) {
                area.append(String.valueOf(text.charAt(index[0])));
                index[0]++;
            } else {
                timer.stop();
            }
        });
        timer.start();

        JOptionPane.showMessageDialog(null, scroll, title, JOptionPane.INFORMATION_MESSAGE);
    }

    private static void splashScreen() {
        JFrame splash = new JFrame();
        JLabel label = new JLabel("📚 Library Tracker", JLabel.CENTER);
        label.setFont(new Font("Serif", Font.BOLD, 24));
        splash.add(label);
        splash.setSize(300, 150);
        splash.setLocationRelativeTo(null);
        splash.setUndecorated(true);
        splash.setVisible(true);

        try {
            for (float i = 0f; i <= 1f; i += 0.05f) {
                splash.setOpacity(i);
                Thread.sleep(50);
            }
        } catch (Exception ignored) {}
        splash.dispose();
    }
}