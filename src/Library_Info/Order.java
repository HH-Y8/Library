package Library_Info;
import java.util.Date;
import java.util.List;

public class Order {

  int orderId;
    User user;
    Books book;
    int quantity;

    public Order(int orderId, User user, Books book, int quantity) {
        this.orderId = orderId;
        this.user = user;
        this.book = book;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return quantity * book.getPrice();
    }

    @Override
    public String toString() {
        return "Order#" + orderId + " - " + book.getTitle() + " x" + quantity +
                " by " + user.getName() + " | Total: $" + getTotalPrice();
    }
}
