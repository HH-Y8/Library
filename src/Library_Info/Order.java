package Library_Info;
import java.util.Date;
import java.util.List;

public class Order {
    private String orderId;
    private User user;
    private List<Books> book;
    private Date orderDate;

    public Order(String orderId, User user, List<Books> book, Date orderDate) {
        this.orderId = orderId;
        this.user = user;
        this.book = book;
        this.orderDate = orderDate;
    }
    public String getOrderId() { return orderId; }
    public User getUser() { return user; }
    public List<Books> getBooks() { return book; }
    public Date getOrderDate() { return orderDate; }

    @Override
    public String toString(){
        return String.format("order[orderId=%s, user=%s, date=%s, book=%s]"
        ,orderId, user.getName(),orderDate,book);
    }
}
