package Library_Info;

import com.sun.xml.internal.ws.transport.http.HttpMetadataPublisher;

import java.util.*;
import java.util.stream.Collectors;

public class Run { public static void main(String[] args) {
    List<Books> books = new ArrayList<>(Arrays.asList(
            new Books("Divan hafez", "Hafez", "poem", 1700, 300, "111", 40.5),
            new Books("java programming", "Sara", "Programming", 2000, 500, "222", 55.0),
            new Books("History of Iran", "Mohammad", "History", 2012, 250, "333", 30.0),
            new Books("golestan", "sadi", "poem", 1770, 320, "444", 35.5),
            new Books("Design Patterns", "Ali", "Programming", 2018, 450, "555", 48.0)
    ));
        List<publisher> publishers = new ArrayList<>(Arrays.asList(
         new publisher("chap farda", "karaj.....", "0236..."),
         new publisher("berooz","tehran....","021366.....")
    ));

    User u1 = new User(1, "Ali Reza", "ali@example.com");
    User u2 = new User(2, "Sara M", "sara@example.com");

    List<Order> orders = Arrays.asList(new Order(101, u1, books.get(0), 2),
            new Order(102, u2, books.get(1), 1),
            new Order(103, u1, books.get(3), 3));

     //اضافه کردن کتاب
    books.add(new Books("Aftab", "John", "mystery", 2021, 380, "666", 45.0));

    //حذف کتاب با  isbn
    String isbnToRemove = "333";
    books.removeIf(book -> book.getIsbn().equals(isbnToRemove));

    //   سرچ کتاب بر اساس نویسنده
    String authorSearch = "sadi";
    List<Books> byAuthor = books.stream()
            .filter(book -> book.getAuthor().equalsIgnoreCase(authorSearch))
            .collect(Collectors.toList());
    System.out.println("Books by sadi: " + byAuthor);

    // سرچ کتاب بر اساس ژانر
    String genreSearch = "Programming";
    List<Books> byGenre = books.stream()
            .filter(book -> book.getGenre().equalsIgnoreCase(genreSearch))
            .collect(Collectors.toList());
    System.out.println("Books in Programming genre: " + byGenre);

    //کتاب های بعد از سال 2017
    int year = 2017;
    List<Books> recentBooks = books.stream()
            .filter(book -> book.getPublicationYear() > year)
            .collect(Collectors.toList());
    System.out.println("Books after " + year + ": " + recentBooks);

    //مرتب سازس کتاب ها بر اساس تعداد صفحات از زیادبه کم
    List<Books> sortedByPagesDesc = books.stream()
            .sorted(Comparator.comparingInt(Books::getNumberOfPages).reversed())
            .collect(Collectors.toList());
    System.out.println("Books sorted by pages (desc): " + sortedByPagesDesc);

    //سرچ کتاب براساس نام کتاب
    String titleToFind = "Divan hafez";
    Optional<Books> foundBook = books.stream()
            .filter(book -> book.getTitle().equalsIgnoreCase(titleToFind))
            .findFirst();
    foundBook.ifPresent(book -> System.out.println("Found book: " + book));

    //تعداد کتاب ها و میانگین صفحات
    long totalBooks = books.size();
    double avgPages = books.stream()
            .mapToInt(Books::getNumberOfPages)
            .average()
            .orElse(0);
    Map<String, List<Books>> booksByGenre = books.stream()
            .collect(Collectors.groupingBy(Books::getGenre));

    System.out.println("Total books: " + totalBooks);
    System.out.println("Average pages: " + avgPages);
    System.out.println("Books grouped by genre:");
    booksByGenre.forEach((genre, list) -> System.out.println(" - " + genre + ": " + list));

    // سفارش‌ها
    System.out.println("\n--- Book Orders ---");
    orders.forEach(System.out::println);

    System.out.println("\n--- Orders by User: Ali Reza ---");
    orders.stream()
            .filter(order -> order.user.getName().equals("Ali Reza"))
            .forEach(System.out::println);

    System.out.println("\n--- Total Revenue ---");
    double totalRevenue = orders.stream()
            .mapToDouble(Order::getTotalPrice)
            .sum();
    System.out.println("Total Revenue: $" + totalRevenue);


// سفارش‌ها بر اساس ژانر
    System.out.println("\n--- Orders Grouped by Genre ---");
    Map<String, List<Order>> ordersByGenre = orders.stream()
            .collect(Collectors.groupingBy(order -> order.book.getGenre()));
    ordersByGenre.forEach((genre, orderList) -> {
        System.out.println("Genre: " + genre);
        orderList.forEach(order -> System.out.println(" - " + order));
    });

}
}
