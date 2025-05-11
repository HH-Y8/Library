package Library_Info;

import java.util.*;
import java.util.stream.Collectors;

public class Run { public static void main(String[] args) {
    List<Books> books = new ArrayList<>(Arrays.asList(
            new Books("Java Basics", "Ali", "Programming", 2015, 300, "111", 40.5),
            new Books("Advanced Java", "Sara", "Programming", 2019, 500, "222", 55.0),
            new Books("History of Iran", "Mohammad", "History", 2012, 250, "333", 30.0),
            new Books("Mystery Island", "Sara", "Fiction", 2020, 320, "444", 35.5),
            new Books("Design Patterns", "Ali", "Programming", 2018, 450, "555", 48.0)
    ));

    books.add(new Books("Java 8 in Action", "John", "Programming", 2021, 380, "666", 45.0));

    String isbnToRemove = "333";
    books.removeIf(book -> book.getIsbn().equals(isbnToRemove));

    String authorSearch = "Sara";
    List<Books> byAuthor = books.stream()
            .filter(book -> book.getAuthor().equalsIgnoreCase(authorSearch))
            .collect(Collectors.toList());
    System.out.println("Books by Sara: " + byAuthor);

    String genreSearch = "Programming";
    List<Books> byGenre = books.stream()
            .filter(book -> book.getGenre().equalsIgnoreCase(genreSearch))
            .collect(Collectors.toList());
    System.out.println("Books in Programming genre: " + byGenre);

    int year = 2017;
    List<Books> recentBooks = books.stream()
            .filter(book -> book.getPublicationYear() > year)
            .collect(Collectors.toList());
    System.out.println("Books after " + year + ": " + recentBooks);

    List<Books> sortedByPagesDesc = books.stream()
            .sorted(Comparator.comparingInt(Books::getNumberOfPages).reversed())
            .collect(Collectors.toList());
    System.out.println("Books sorted by pages (desc): " + sortedByPagesDesc);

    String titleToFind = "Mystery Island";
    Optional<Books> foundBook = books.stream()
            .filter(book -> book.getTitle().equalsIgnoreCase(titleToFind))
            .findFirst();
    foundBook.ifPresent(book -> System.out.println("Found book: " + book));

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
}
}
