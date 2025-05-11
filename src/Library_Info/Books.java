package Library_Info;

public class Books {

    private String title;
    private String author;
    private String genre;
    private int publicationYear;
    private int numberOfPages;
    private String isbn;
    private double price;
    private String publisher;

    public Books(String title, String author, String genre, int publicationYear, int numberOfPages,
                String isbn, double price ) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.numberOfPages = numberOfPages;
        this.isbn = isbn;
        this.price = price;
    }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public int getPublicationYear() { return publicationYear; }
    public int getNumberOfPages() { return numberOfPages; }
    public String getIsbn() { return isbn; }
    public double getPrice() { return price; }

    @Override
    public String toString(){
        return String.format("Books[title=%s, author=%s, year=%d, pages=%d, isbn=%s, price=%.2f]",
           title,author,publicationYear,numberOfPages,isbn,price);
    }
}
